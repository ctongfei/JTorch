#! /bin/bash

PYTORCH_INCLUDE_PATH=/Users/tongfei/my/proj/py/pytorch/torch/lib/tmp_install/include
PYTORCH_DYLIB_PATH=/usr/local/lib/python3.6/site-packages/torch/lib

TORCH_MODULES=(TH THNN THS THC THCUNN THCS)

mkdir -p include
mkdir -p include-swig

echo "Copying include files..."
for m in ${TORCH_MODULES[@]}; do 
    cp -R $PYTORCH_INCLUDE_PATH/$m ./include/$m; 
    cp -R $PYTORCH_INCLUDE_PATH/$m ./include-swig/$m;
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
    | grep -v "__signed" \
    | sed -e "s|__thalign__([0-9])||g" \
    > ../include-swig/$f
done
cd ..

echo "Preprocessing C headers..."
cp torch.h include-swig
cd include-swig
cc -P -E \
  -I TH -I THNN -I THS -I THC -I THCUNN -I THCS torch.h \
  | grep -v "__signed" \
  | grep -v "struct THCState;" \
  | grep -v "typedef struct THCState THCState;" \
  > torch-preprocessed.h
cd ..


echo "Generating SWIG bindings..."
mkdir -p jni/src/main/java/jtorch/jni
swig -DSWIGWORDSIZE64 -java -package jtorch.jni -outdir jni/src/main/java/jtorch/jni torch.i

echo "Compiling SWIG generated JNI wrapper code..."

cc -c torch_wrap.c \
    -I $JAVA_HOME/include \
    -I $JAVA_HOME/include/darwin \
    -I /usr/local/cuda/include \
    -I $PYTORCH_INCLUDE_PATH/TH \
    -I $PYTORCH_INCLUDE_PATH/THNN \
    -I $PYTORCH_INCLUDE_PATH/THS \
    -I $PYTORCH_INCLUDE_PATH/THC \
    -I $PYTORCH_INCLUDE_PATH/THCUNN \
    -I $PYTORCH_INCLUDE_PATH/THCS

echo "Building dynamic linking library..."
mkdir -p jni/src/main/resources
cc -dynamiclib -undefined suppress -flat_namespace torch_wrap.o -o jni/src/main/resources/libjnitorch.dylib

echo "Publishing to local Ivy repository..."
# sbt jniutils/publishLocal core/publishLocal
