#! /bin/bash
INSTALL_DIR=/home/tongfei/lib/aten

TORCH_CUDA_MODULES=(THC THCUNN THCS)

mkdir -p include
mkdir -p include-swig

echo "Copying include files..."
for m in ${TORCH_CUDA_MODULES[@]}; do 
    cp -R $INSTALL_DIR/include/$m ./include/$m; 
    cp -R $INSTALL_DIR/include/$m ./include-swig/$m;
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
cc -P -E -I . -I TH -I THC -I THCUNN -I THCS torch-cuda.h \
  | grep -v "__signed" \
  > torch-cuda-preprocessed.h
cd ..


echo "Generates Swig bindings..."
mkdir -p cuda/src/main/java/jtorch/cuda/jni
swig -java -package jtorch.cuda.jni -outdir cuda/src/main/java/jtorch/cuda/jni torch-cuda.i

echo "Compile SWIG generated JNI wrapper code..."

cc -std=c99 -fPIC -static -c torch-cuda_wrap.c \
    -I $JAVA_HOME/include \
    -I $JAVA_HOME/include/linux \
    -I /usr/local/cuda/include \
    -I $INSTALL_DIR/include \
    -I $INSTALL_DIR/include/TH \
    -I $INSTALL_DIR/include/THC \
    -I $INSTALL_DIR/include/THCUNN \
    -I $INSTALL_DIR/include/THCS

echo "Builds dynamic linking library..."
mkdir -p cuda/src/main/resources
cc -shared torch-cuda_wrap.o -o cuda/src/main/resources/libjnitorchcuda.so -Wl,-rpath,$INSTALL_DIR/lib -L $INSTALL_DIR/lib -lATen

echo "Publishing to local Ivy repository..."
sbt cuda/publishLocal
