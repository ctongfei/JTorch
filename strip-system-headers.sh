TH=include/TH
THStripped=include/TH-stripped

mkdir include/TH-Stripped
cp -R include/TH/* include/TH-Stripped
cd include/TH

for f in $(find . -name \*.h); do
    cat $f | grep -v "#include <.*>" | sed -e "s/__thalign__([0-9])//g" > ../TH-Stripped/$f
done

cd ../..

touch include/TH-preprocessed.h
gcc -E include/TH-Stripped/TH.h > include/TH-preprocessed.h
swig -java -package torch.th -outdir java-out/ th.i
gcc -c th_wrap.c -I"$JAVA_HOME/include" -I"$JAVA_HOME/include/darwin"
gcc -dynamiclib -undefined suppress -flat_namespace th_wrap.o -o libth.dylib 
