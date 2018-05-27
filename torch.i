%module TH

%{
    #include <math.h>
    #include <stdbool.h>
    #include <stddef.h>
    #include "include/TH/TH.h"
    #include "include/THNN/THNN.h"
    #include "include/THS/THS.h"
    #include "include/THC/THC.h"
    #include "include/THCUNN/THCUNN.h"
    #include "include/THCS/THCS.h"
%}

%include "stdint.i"
%include "carrays.i"

%define ptrdiff_t
intptr_t
%enddef

%array_class(uint8_t, CUInt8Array);
%array_class(int8_t, CInt8Array);
%array_class(int16_t, CInt16Array);
%array_class(int32_t, CInt32Array);
%array_class(int64_t, CInt64Array);
%array_class(float, CFloatArray);
%array_class(double, CDoubleArray);

%include "include-swig/torch-preprocessed.h"

%pragma(java) jniclasscode=%{

    static {
        try {
            System.loadLibrary("ATen");
            jtorch.jniutils.JNILoader.loadLibraryFromJar("jnitorch");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

%}
