package jtorch;

import jtorch.jni.*;

/**
 * @author Tongfei Chen
 */
public class FloatVector {

    public static void fill(CFloatArray x, float c, long n) {
        TH.THFloatVector_fill(x.cast(), c, n);
    }

    public static void cadd(CFloatArray z, CFloatArray x, CFloatArray y, float c, long n) {
        TH.THFloatVector_cadd(z.cast(), x.cast(), y.cast(), c, n);
    }

    public static void adds(CFloatArray y, CFloatArray x, float c, long n) {
        TH.THFloatVector_adds(y.cast(), x.cast(), c, n);
    }

    public static

}
