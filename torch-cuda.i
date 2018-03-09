%module THC

%{
    #include <math.h>
    #include <stdbool.h>
    #include <stddef.h>
    #include "include/TH/TH.h"
    #include "include/THC/THC.h"
    #include "include/THCUNN/THCUNN.h"
    #include "include/THCS/THCS.h"
%}

%include "stdint.i"
%include "carrays.i"

%define ptrdiff_t
intptr_t
%enddef

%array_functions(int, intArray);
%array_functions(long, longArray);
%array_functions(long long, longLongArray);
%array_functions(float, floatArray);
%array_functions(double, doubleArray);

%include "include-swig/torch-cuda-preprocessed.h"
