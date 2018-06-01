#! /bin/bash

for line in $(cat TYPEMAPS); do

    JCLASS=$(echo $line | cut -d":" -f1)
    JPRIM=$(echo $line | cut -d":" -f2)
    THCLASS=$(echo $line | cut -d":" -f3)
    CARRAYNAME=$(echo $line | cut -d":" -f4)
    FLAG=$(echo $line | cut -d":" -f5)


    gcc -P -E -C \
        -D"JStorage=${JCLASS}Storage" \
        -D"JType=${JPRIM}" \
        -D"CArray=${CARRAYNAME}" \
        -D"THStorage=TH${THCLASS}Storage" \
        -D"THStorage_(NAME)=TH${THCLASS}Storage_ ## NAME" \
        Storage.h > ../../../../java/src/main/java/jtorch/${JCLASS}Storage.java

    echo "${JCLASS}Storage.java generated."

    gcc -P -E -C \
        -D"JVector=${JCLASS}Vector" \
        -D"JType=${JPRIM}" \
        -D"CArray=${CARRAYNAME}" \
        -D"THVector=TH${THCLASS}Vector" \
        -D"THVector_(NAME)=TH${THCLASS}Vector_ ## NAME" \
        -D"${FLAG}" \
        Vector.h > ../../../../java/src/main/java/jtorch/${JCLASS}Vector.java

    echo "${JCLASS}Vector.java generated."

    # echo "[C] TH${THCLASS}Tensor -> [Java] ${JCLASS}Tensor"

done
