#! /bin/bash

TORCH_MODULES=(TH THNN THS)

mkdir -p include
mkdir -p include-swig

echo "Copying include files..."
for m in ${TORCH_MODULES[@]}; do 
    cp -R /usr/local/include/$m ./include/$m; 
    cp -R /usr/local/include/$m ./include-swig/$m;
done


echo "Preprocessing all header files for SWIG..."
#   change '#include <THxxx.h>' to '#include "THxxx.h"'
#   remove system headers
#   remove CUDA headers
#   remove TH_NO_RETURN
#   remove '__thalign__([0-9])'
cd include
for f in $(find . -name \*.h); do        
    cat $f \
    | sed -E "s|<TH(.*)>|\"TH\1\"|g" \
    | grep -v "#include <.*>" \
    | grep -v "#include \"cu.*\.h\"" \
    | grep -v "TH_NO_RETURN" \
    | sed -e "s|__thalign__([0-9])||g" \
    > ../include-swig/$f
done
cd ..

echo "Preprocessing C headers..."
cp torch-cpu.h include-swig
cd include-swig
cc -P -E -I TH -I THNN -I THS torch-cpu.h > torch-cpu-preprocessed.h
cd ..


echo "Generating SWIG bindings..."
mkdir -p cpu/src/main/java/jtorch/cpu
swig -java -package jtorch.cpu -outdir cpu/src/main/java/jtorch/cpu torch-cpu.i

echo "Compiling SWIG generated JNI wrapper code..."

cc -c torch-cpu_wrap.c \
    -I $JAVA_HOME/include \
    -I $JAVA_HOME/include/darwin \
    -I /usr/local/include/TH \
    -I /usr/local/include/THNN \
    -I /usr/local/include/THS

echo "Building dynamic linking library..."
mkdir -p cpu/src/main/resources
cc -dynamiclib -undefined suppress -flat_namespace torch-cpu_wrap.o -o cpu/src/main/resources/libjnitorchcpu.dylib

echo "Publishing to local Ivy repository..."
sbt jniutils/publishLocal cpu/publishLocal
