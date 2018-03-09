%module TH

%{
    #include <math.h>
    #include <stdbool.h>
    #include <stddef.h>
    #include "include/TH/TH.h"
    #include "include/THNN/THNN.h"
    #include "include/THS/THS.h"
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

%include "include-swig/torch-cpu-preprocessed.h"

%pragma(java) jniclasscode=%{

    static {
        try {
            System.loadLibrary("aten");
            jtorch.jniutils.JNILoader.loadLibraryFromJar("jnitorchcpu");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

%}
