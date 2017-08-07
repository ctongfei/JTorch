### JavaTorch: Java binding of Torch through Swig

The latest C source of Torch (PyTorch C core) should be accessed from [here](https://github.com/pytorch/pytorch/tree/master/torch/lib). 

| C package | Description                 | Mapped Java package |
|-----------|-----------------------------|---------------------|
| `TH      `| Torch CPU                   | `jtorch.th         `|
| `THNN    `| Torch CPU neural networks   | `jtorch.thnn       `|
| `THS     `| Torch sparse tensors on CPU | `jtorch.ths        `|
| `THC     `| Torch GPU                   | `jtorch.thc        `|
| `THCUNN  `| Torch GPU neural networks   | `jtorch.thcunn     `|
| `THCS    `| Torch sparse tensors on GPU | `jtorch.thcs       `|

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

# Removes system headers
mkdir target/cpp
cp -R target/include/* target/cpp/
cd target/include
for f in $(find . -name \*.h); do
    cat $f | grep -v "#include <.*>" | sed -e "s/__thalign__([0-9])//g" > ../cpp/$f
done
cd ../..

# Expands macros
mkdir target/preprocessed
cc -E target/cpp/TH/TH.h > target/preprocessed/TH-preprocessed.h

# Generates Swig bindings
mkdir -p src/main/java/jtorch/th

swig -java -package jtorch.th -outdir src/main/java/jtorch/th th.i

# Compiles JNI wrapper code
cc -c th_wrap.c -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/darwin"

# Builds dynamic linking library
cc -dynamiclib -undefined suppress -flat_namespace th_wrap.o -o libjnith.dylib

# Builds Java library
mvn clean compile assembly:single
```
