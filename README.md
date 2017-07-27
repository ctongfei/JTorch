### JavaTorch: Java binding of Torch through Swig

The latest C source of Torch (PyTorch C core) should be accessed from [here](https://github.com/pytorch/pytorch/tree/master/torch/lib). 

| C package | Description                 | Mapped Java package |
|-----------|-----------------------------|---------------------|
| `TH      `| Torch CPU                   | `torch.th          `|
| `THNN    `| Torch CPU neural networks   | `torch.thnn        `|
| `THS     `| Torch sparse tensors on CPU | `torch.ths         `|
| `THC     `| Torch GPU                   | `torch.thc         `|
| `THCUNN  `| Torch GPU neural networks   | `torch.thcunn      `|
| `THCS    `| Torch sparse tensors on GPU | `torch.thcs        `|

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

# Copies the source code to another location
mkdir cpp 
cp -R pytorch/torch/lib/* cpp/

# Removes system headers
cd pytorch/torch/lib
for f in $(. -name \*.h); do
    cat $f | grep -v "#include <.*>" | sed -e "s/__thalign__([0-9])//g" > ../../../cpp/$f
done
cd ../../..

# Expands macros
cc -E cpp/TH/TH.h > cpp/TH-preprocessed.h

# Generates Swig bindings
swig -java -package torch.th -outdir src/main/java/torch/th th.i

# Compiles JNI wrapper code
cc -c th_wrap.c -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/darwin"

# Builds dynamic linking library
cc -dynamiclib -undefined suppress -flat_namespace th_wrap.o -o libjnith.dylib

# Builds Java library
mvn clean compile assembly:single
```

