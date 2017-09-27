%module TH

%{
    #include <math.h>
    #include <stdbool.h>
    #include <stddef.h>
    #include "target/cpp/TH/TH.h"
    #include "target/cpp/THS/THS.h"
    #include "target/cpp/THNN/THNN.h"
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

%include "target/preprocessed/TH.h"
%include "target/preprocessed/THS.h"
%include "target/preprocessed/THNN.h"
