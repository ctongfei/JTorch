%module ATen

%{
    #include <math.h>
    #include <stdbool.h>
    #include <stddef.h>
    #include "include/ATen/ATen.h"
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

%include "include-swig/torch-aten-preprocessed.h"
