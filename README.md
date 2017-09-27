### JTorch: Java binding of Torch through Swig

The latest C source of Torch (**PyTorch `0.2.0`** C core) should be accessed from [here](https://github.com/pytorch/pytorch/tree/master/torch/lib). 

| C package | Description                 | Mapped Java package |
|-----------|-----------------------------|---------------------|
| `TH      `| Torch CPU                   | `jtorch.cpu        `|
| `THNN    `| Torch CPU neural networks   | `jtorch.cpu        `|
| `THS     `| Torch sparse tensors on CPU | `jtorch.cpu        `|
| `THC     `| Torch GPU                   | `jtorch.cuda       `|
| `THCUNN  `| Torch GPU neural networks   | `jtorch.cuda       `|
| `THCS    `| Torch sparse tensors on GPU | `jtorch.cuda       `|

#### Prerequisites
 - Clang (Mac) / GCC (Linux)
 - JVM 8
 - CUDA 8
 - Swig

#### Building

First build PyTorch from source.

Copy the built C files (libraries, headers) from `<pytorch>/torch/lib/tmp_install` to `<pwd>/tmp_install`.

Then execute the following:

```bash

# Copies the built files to another location
mkdir target
cp -R pytorch/torch/lib/tmp_install/* target/

# Removes system headers
mkdir target/cpp
cp -R target/include/* target/cpp/
cd target/include
for f in $(find . -name \*.h); do
    cat $f | sed -E "s|<TH(.*)>|\"TH\1\"|g" | grep -v "#include <.*>" | grep -v "#include \"cu.*\.h\"" | sed -e "s/__thalign__([0-9])//g" > ../cpp/$f
done
cd ../..


# Expands macros

mkdir target/preprocessed

cc -E target/cpp/TH/TH.h > target/preprocessed/TH.h
cc -I target/cpp/TH -E target/cpp/THS/THS.h > target/preprocessed/THS.h
cc -I target/cpp/TH -I target/cpp/THNN -E target/cpp/THNN/THNN.h > target/preprocessed/THNN.h

cc -I target/cpp/TH -E target/cpp/THC/THC.h > target/preprocessed/THC.h
cc -I target/cpp -I target/cpp/TH -I target/cpp/THC -I target/cpp/THCS -E target/cpp/THCS/THCS.h > target/preprocessed/THCS.h
cc -I target/cpp -I target/cpp/TH -I target/cpp/THC -I target/cpp/THCUNN -E target/cpp/THCUNN/THCUNN.h > target/preprocessed/THCUNN.h

# Generates Swig bindings
mkdir -p src/main/java/jtorch/cpu
mkdir -p src/main/java/jtorch/cuda

swig -java -package jtorch.cpu -outdir src/main/java/jtorch/cpu THCPU.i
swig -java -package jtorch.cuda -outdir src/main/java/jtorch/cuda THCUDA.i

# Compiles JNI wrapper code
cc -c THCPU_wrap.c -I $JAVA_HOME/include -I $JAVA_HOME/include/darwin  -I target/include/TH -I target/include/THS -I target/include/THNN 
cc -c THCUDA_wrap.c -I $JAVA_HOME/include -I $JAVA_HOME/include/darwin -I /usr/local/cuda/include/ -I target/include/TH -I target/include -I target/include/THC -I target/include/THCS -I target/include/THCUNN


# Builds dynamic linking library
cc -dynamiclib -undefined suppress -flat_namespace THCPU_wrap.o -o libjnith.dylib

# Builds Java library
mvn clean compile assembly:single
```
