## JTorch: JVM bindings for Torch (PyTorch C/C++ core)

Corresponding PyTorch version: `0.4.0`

🚧 **Ongoing project** 🚧 **Status: Not ready for use** 🚧

|      | Windows | Linux | MacOS |
|:----:|:-------:|:-----:|:-----:|
| CPU  |         |       |   ✓   |
| CUDA |         |       |   ✓   |

### Installation

**Step 1: Install PyTorch from source.**

Locate the headers (\*.h) and shared libraries (\*.so / \*.dylib / \*.dll)

**Step 2: Build SWIG bindings and publish to local Ivy repository.**
```sh
./build-{mac/linux}.sh
```
You probably need to modify something in the script to make it work.

**[TODO]** Will be refactored into a `Makefile`.


**Step 3: Use!**
```xml
    <dependency>
      <groupId>me.tongfei</groupId>
      <artifactId>jtorch-java</artifactId>
      <version>0.1-TH0.4-SNAPSHOT</version>
    </dependency>
```

When starting a JVM, add `-Djava.library.path=/usr/local/lib` (or where your `libATen.dylib` is), 
or set `$LD_LIBRARY_PATH` to include that directory, so that JVM can properly load native the binary.

### Typemaps

Torch has the following `Storage`/`Tensor` types, which are mapped to the Java corresponding types on the right.

| Torch type      | Element type (C) | Bits | Mapped element type (Java)  | Java type     |
|-----------------|------------------|------|-----------------------------|---------------|
|`THHalfTensor`   |`THHalf`          | 16   |`float`                      |`HalfTensor`   |
|`THFloatTensor`  |`float`           | 32   |`float`                      |`FloatTensor`  |
|`THDoubleTensor` |`double`          | 64   |`double`                     |`DoubleTensor` |
|`THByteTensor`   |`uint8_t`         | 8    |`short`                      |`UByteTensor`  |
|`THCharTensor`   |`int8_t`          | 8    |`byte`                       |`ByteTensor`   |
|`THShortTensor`  |`int16_t`         | 16   |`short`                      |`ShortTensor`  |
|`THIntTensor`    |`int32_t`         | 32   |`int`                        |`IntTensor`    |
|`THLongTensor`   |`int64_t`         | 64   |`long`                       |`LongTensor`   |

