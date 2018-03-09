## JTorch: JVM bindings for Torch (PyTorch C/C++ core)


|      | Windows | Linux | MacOS |
|:----:|:-------:|:-----:|:-----:|
| CPU  |         |       |   ✓   |
| CUDA |         |       |   ✓   |

### Installation

**Step 1: Build ATen binary.** 
Clone [PyTorch](https://github.com/pytorch/pytorch), go to the `aten` directory (containing the ATen tensor library) and make from there.
```sh
git clone https://github.com/pytorch/pytorch.git
cd pytorch/aten
mkdir build
cd build
cmake .. -DCMAKE_INSTALL_PREFIX=/where/you/want # specify your dest directory
# cmake .. -DNO_CUDA=true  # for CPU only machines
make install
```
You should get `libATen.dylib` at `/usr/local/lib` and also C/C++ include files in `/usr/local/include`.

**Step 2: Build SWIG bindings and publish to local Ivy repository.**
```sh
./build-cpu.sh
./build-cuda.sh  # If you want CUDA support
```

**Step 3: Use!**
```xml
    <dependency>
      <groupId>me.tongfei</groupId>
      <artifactId>jtorch-cpu</artifactId>
      <version>0.3.0-SNAPSHOT</version>
    </dependency>

    <dependency>
      <groupId>me.tongfei</groupId>
      <artifactId>jtorch-cuda</artifactId>
      <version>0.3.0-SNAPSHOT</version>
    </dependency>
```

When starting a JVM, add `-Djava.library.path=/usr/local/lib` (or where your `libATen.dylib` is) so that JVM can properly load the binary.
