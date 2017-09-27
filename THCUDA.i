%module THCUDA

%{
    #include <math.h>
    #include <stdbool.h>
    #include <stddef.h>
    #include "target/include/TH/TH.h"
    #include "target/include/THC/THC.h"
    #include "target/include/THCS/THCS.h"
    #include "target/include/THCUNN/THCUNN.h"
%}

%include "stdint.i"
%include "carrays.i"

%define ptrdiff_t
intptr_t
%enddef

%array_functions(int, intArray);
%array_functions(long, longArray);
%array_functions(float, floatArray);
%array_functions(double, doubleArray);

%include "target/preprocessed/THC.h"
%include "target/preprocessed/THCS.h"
%include "target/preprocessed/THCUNN.h"
