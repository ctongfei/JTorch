#! /bin/bash

for line in $(cat TYPEMAPS); do

    JCLASS=$(echo $line | cut -d":" -f1)
    JPRIM=$(echo $line | cut -d":" -f2)
    THCLASS=$(echo $line | cut -d":" -f3)
    CARRAYNAME=$(echo $line | cut -d":" -f4)

    echo "[C] TH${THCLASS}Storage -> [Java] ${JCLASS}Storage"

    gcc -P -E -C \
        -D"JStorage=${JCLASS}Storage" \
        -D"JType=${JPRIM}" \
        -D"CArray=${CARRAYNAME}" \
        -D"THStorage=TH${THCLASS}Storage" \
        -D"THStorage_(NAME)=TH${THCLASS}Storage_ ## NAME" \
        Storage.h > ../java/jtorch/${JCLASS}Storage.java

    echo "[C] TH${THCLASS}Tensor -> [Java] ${JCLASS}Tensor"

done
