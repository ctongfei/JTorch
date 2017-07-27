#!/usr/bin/env bash

TH=include/TH
THStripped=stripped/TH

echo "Create a copy of the source files"

mkdir $THStripped
cp -R $TH/* $THStripped

echo "Remove system headers"
cd $TH
for f in $(find . -name \*.h); do
    cat $f | grep -v "#include <.*>" | sed -e "s/__thalign__([0-9])//g" > ../../$THStripped/$f
done
cd ../..

echo "Expand macros and includes in C source"
mkdir preprocessed
gcc -E $THStripped/TH.h > preprocessed/TH.h

echo "Generate SWIG bindings"
mkdir torch
mkdir torch/th
swig -java -package torch.swig.th -outdir torch/th th.i

echo "Compile JNI wrapper module"
gcc -c th_wrap.c -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/darwin"

echo "Builds dynamic linking library"
gcc -dynamiclib -undefined suppress -flat_namespace th_wrap.o -o libjnith.dylib

# THFile__.java
# THConstants.java
# THFileVTable.java
echo "Builds Java wrapper library"
javac torch/th/*.java
touch Manifest.txt
jar cfvm torch-th.jar Manifest.txt torch/th/*.class
