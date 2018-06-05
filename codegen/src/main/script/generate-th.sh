#! /bin/bash

for line in $(cat TYPEMAPS); do

    JCLASS=$(echo $line | cut -d":" -f1)
    JPRIM=$(echo $line | cut -d":" -f2)
    THCLASS=$(echo $line | cut -d":" -f3)
    CARRAYPREFIX=$(echo $line | cut -d":" -f4)
    FLAG=$(echo $line | cut -d":" -f5)
    ACCREAL=$(echo $line | cut -d":" -f6)


    gcc -P -E -C \
        -D"JStorage=${JCLASS}Storage" \
        -D"JType=${JPRIM}" \
        -D"CArray=${CARRAYPREFIX}Array" \
        -D"THStorage=TH${THCLASS}Storage" \
        -D"THStorage_(NAME)=TH${THCLASS}Storage_ ## NAME" \
        Storage.h > ../../../../java/src/main/java/jtorch/${JCLASS}Storage.java

    echo "${JCLASS}Storage.java generated."

    gcc -P -E -C \
        -D"JVector=${JCLASS}Vector" \
        -D"JType=${JPRIM}" \
        -D"CArray=${CARRAYPREFIX}Array" \
        -D"THVector=TH${THCLASS}Vector" \
        -D"THVector_(NAME)=TH${THCLASS}Vector_ ## NAME" \
        -D"${FLAG}" \
        Vector.h > ../../../../java/src/main/java/jtorch/${JCLASS}Vector.java

    echo "${JCLASS}Vector.java generated."

    gcc -P -E -C \
        -D"JTensor=${JCLASS}Tensor" \
        -D"JStorage=${JCLASS}Storage" \
        -D"JType=${JPRIM}" \
        -D"CArray=${CARRAYPREFIX}Array" \
        -D"THTensor=TH${THCLASS}Tensor" \
        -D"THTensor_(NAME)=TH${THCLASS}Tensor_ ## NAME" \
        -D"SWIGTYPE_p_p_THTensor=SWIGTYPE_p_p_TH${THCLASS}Tensor" \
        -D"new_CTensorArray=new_${CARRAYPREFIX}TensorArray" \
        -D"CTensorArray_setitem=${CARRAYPREFIX}TensorArray_setitem" \
        -D"AccReal=${ACCREAL}" \
        -D"${FLAG}" \
        Tensor.h > ../../../../java/src/main/java/jtorch/${JCLASS}Tensor.java

    echo "${JCLASS}Tensor.java generated."

done
