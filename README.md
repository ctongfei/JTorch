## JTorch
JVM bindings for Torch (PyTorch C Core)


|      | Windows | Linux | MacOS |
|:----:|:-------:|:-----:|:-----:|
| CPU  |         |       |   ✓   |
| CUDA |         |       |   ✓   |

### Usage

```sh
java -Djava.library.path=/usr/local/lib ...
```

### Installation

First clone [PyTorch](https://github.com/pytorch/pytorch), go to the `aten` directory (containing the ATen tensor library) and make from there.
```sh
git clone https://github.com/pytorch/pytorch.git
cd pytorch/aten
mkdir build
cd build
cmake .. -DCMAKE_INSTALL_PREFIX=/where/you/want # specify your dest directory
# cmake .. -DNO_CUDA=true  # for CPU only machines
make install
```

Then run the scripts in this repository.
