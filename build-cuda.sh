#! /bin/bash

TORCH_CUDA_MODULES=(THC THCUNN THCS)

mkdir include
mkdir include-swig

# Copy include files

for m in ${TORCH_CUDA_MODULES[@]}; do 
    cp -R /usr/local/include/$m ./include/$m; 
    cp -R /usr/local/include/$m ./include-swig/$m;
done

# preprocess all header files, reduce generated code size.
#   0. change '#include <THxxx.h>' to '#include "THxxx.h"'
#   1. remove system headers
#   2. remove CUDA headers
#   3. remove '__thalign__([0-9])'

cd include
for f in $(find . -name \*.h); do        
    cat $f | sed -E "s|<TH(.*)>|\"TH\1\"|g" | grep -v "#include <.*>" | grep -v "#include \"cu.*\.h\"" | sed -e "s/__thalign__([0-9])//g" > ../include-swig/$f
done
cd ..

cp torch-cuda.h include-swig
cd include-swig
cc -P -E -I TH -I THC -I THCUNN -I THCS torch-cuda.h > torch-cuda-preprocessed.h
cd ..


# Generates Swig bindings
mkdir -p cuda/src/main/java/jtorch/cuda

# remove ((noreturn)), __signed

swig -java -package jtorch.cuda -outdir cuda/src/main/java/jtorch/cuda torch-cuda.i

# Compile SWIG generated JNI wrapper code

cc -c torch-cuda_wrap.c \
    -I $JAVA_HOME/include \
    -I $JAVA_HOME/include/darwin \
    -I /usr/local/cuda/include \
    -I /usr/local/include/TH \
    -I /usr/local/include/THC \
    -I /usr/local/include/THCUNN \
    -I /usr/local/include/THCS

# Builds dynamic linking library
cc -dynamiclib -undefined suppress -flat_namespace torch-cuda_wrap.o -o libjnitorchcuda.dylib

