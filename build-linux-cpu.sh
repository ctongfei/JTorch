#! /bin/bash
INSTALL_DIR=/home/tongfei/lib/aten

TORCH_MODULES=(TH THNN THS)

mkdir -p include
mkdir -p include-swig

echo "Copying include files..."
for m in ${TORCH_MODULES[@]}; do
    cp -R $INSTALL_DIR/include/$m ./include/$m;
    cp -R $INSTALL_DIR/include/$m ./include-swig/$m;
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

cc -std=c99 -fPIC -static -c torch-cpu_wrap.c \
    -I $JAVA_HOME/include \
    -I $JAVA_HOME/include/linux \
    -I $INSTALL_DIR/include/TH \
    -I $INSTALL_DIR/include/THNN \
    -I $INSTALL_DIR/include/THS

echo "Building dynamic linking library..."
mkdir -p cpu/src/main/resources
cc -shared torch-cpu_wrap.o -o cpu/src/main/resources/libjnitorchcpu.so -Wl,-rpath,$INSTALL_DIR/lib -L $INSTALL_DIR/lib -lATen

echo "Publishing to local Ivy repository..."
sbt jniutils/publishLocal cpu/publishLocal
