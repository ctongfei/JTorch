#! /bin/bash

TORCH_CUDA_MODULES=(THC THCUNN THCS)

mkdir -p include
mkdir -p include-swig

echo "Copying include files..."
for m in ${TORCH_CUDA_MODULES[@]}; do 
    cp -R /usr/local/include/$m ./include/$m; 
    cp -R /usr/local/include/$m ./include-swig/$m;
done

echo "Preprocessing all header files for SWIG..."
#   0. change '#include <THxxx.h>' to '#include "THxxx.h"'
#   1. remove system headers
#   2. remove CUDA headers
#   3. remove '__thalign__([0-9])'
cd include
for f in $(find . -name \*.h); do        
    cat $f \
    | sed -E "s|<TH(.*)>|\"TH\1\"|g" \
    | grep -v "#include <.*>" \
    | grep -v "#include \"cu.*\.h\"" \
    | grep -v "TH_NO_RETURN" \
    | grep -v "__signed" \
    | sed -e "s|__thalign__([0-9])||g" \
    > ../include-swig/$f
done
cd ..

echo "Preprocessing C headers..."
cp torch-cuda.h include-swig
cd include-swig
cc -P -E -I TH -I THC -I THCUNN -I THCS torch-cuda.h \
  | grep -v "__signed" \
  > torch-cuda-preprocessed.h
cd ..


echo "Generates Swig bindings..."
mkdir -p cuda/src/main/java/jtorch/cuda/jni
swig -java -package jtorch.cuda.jni -outdir cuda/src/main/java/jtorch/cuda/jni torch-cuda.i

echo "Compile SWIG generated JNI wrapper code..."

cc -c torch-cuda_wrap.c \
    -I $JAVA_HOME/include \
    -I $JAVA_HOME/include/darwin \
    -I /usr/local/cuda/include \
    -I /usr/local/include/TH \
    -I /usr/local/include/THC \
    -I /usr/local/include/THCUNN \
    -I /usr/local/include/THCS

echo "Builds dynamic linking library..."
mkdir -p cuda/src/main/resources
cc -dynamiclib -undefined suppress -flat_namespace torch-cuda_wrap.o -o cuda/src/main/resources/libjnitorchcuda.dylib

echo "Publishing to local Ivy repository..."
sbt cuda/publishLocal
