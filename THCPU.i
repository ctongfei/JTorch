%module TH

%{
    #include "target/include/cpu/TH.h"
    #include "target/include/cpu/THS.h"
    #include "target/include/cpu/THNN.h"
%}

%include "carrays.i"
%array_functions(int, intArray);
%array_functions(long, longArray);
%array_functions(float, floatArray);
%array_functions(double, doubleArray);
%include "target/preprocessed/TH.h"
%include "target/preprocessed/THS.h"
%include "target/preprocessed/THNN.h"
