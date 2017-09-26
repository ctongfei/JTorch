### JTorch: Java bindings of Torch through Swig

The latest C source of Torch (PyTorch C core) should be accessed from [here](https://github.com/pytorch/pytorch/tree/master/torch/lib). 

| C package | Description                 | Mapped Java package |
|-----------|-----------------------------|---------------------|
| `TH      `| Torch CPU                   | `jtorch.           `|
| `THNN    `| Torch CPU neural networks   | `jtorch.           `|
| `THS     `| Torch sparse tensors on CPU | `jtorch.           `|
| `THC     `| Torch GPU                   | `jtorch.cuda       `|
| `THCUNN  `| Torch GPU neural networks   | `jtorch.cuda       `|
| `THCS    `| Torch sparse tensors on GPU | `jtorch.cuda       `|

#### Prerequisites
 - Clang (Mac) / GCC (Linux)
 - JVM
 - CUDA
 - Swig

#### Building

```bash
# Cloning PyTorch repository from GitHub
git clone https://github.com/pytorch/pytorch.git

# Builds the native Torch library (additional flags optional)
cd pytorch/torch/lib
./build_all.sh --with-cuda --with-nccl --with-distributed
cd ../../..

# Copies the built files to another location
mkdir target
cp -R pytorch/torch/lib/tmp_install/* target/

mkdir target/include/cpu
cp -R target/include/TH/* target/include/cpu
cp -R target/include/THNN/* target/include/cpu
cp -R target/include/THS/* target/include/cpu

# Removes system headers
mkdir target/cpp
cp -R target/include/* target/cpp/
cd target/include
for f in $(find . -name \*.h); do
    cat $f | sed -E "s|<TH(.*)>|\"TH\1\"|g" | grep -v "#include <.*>" | sed -e "s/__thalign__([0-9])//g" > ../cpp/$f
done
cd ../..


# Expands macros
mkdir -p target/cpp/cpu
cp -R target/cpp/TH/* target/cpp/cpu
cp -R target/cpp/THNN/* target/cpp/cpu
cp -R target/cpp/THS/* target/cpp/cpu

mkdir target/preprocessed
cc -E target/cpp/cpu/TH.h > target/preprocessed/TH.h
cc -E target/cpp/cpu/THS.h > target/preprocessed/THS.h
cc -E target/cpp/cpu/THNN.h > target/preprocessed/THNN.h

# Generates Swig bindings
mkdir -p src/main/java/jtorch

swig -java -package jtorch -outdir src/main/java/jtorch THCPU.i

# Compiles JNI wrapper code
cc -c THCPU_wrap.c -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/darwin"

# Builds dynamic linking library
cc -dynamiclib -undefined suppress -flat_namespace THCPU_wrap.o -o libjnith.dylib

# Builds Java library
mvn clean compile assembly:single
```
