package jtorch;

import jtorch.jni.*;

import java.math.BigInteger;

/**
 * Wraps around constants and functions in THMath.h, THLogAdd.h and THSize.h.
 * @author Tongfei Chen
 */
public class Torch {

    /** Frees the given Torch object. */
    public static void free(NativeObject o) {
        TH.THFree(new PtrVoid(o.cPtr()));
    }

    //////////////
    // THMath.h //
    //////////////

    public static double sigmoid(double value) {
        return TH.TH_sigmoid(value);
    }

    public static double frac(double x) {
        return TH.TH_frac(x);
    }

    /** Inverse square root. */
    public static double rsqrt(double x) {
        return TH.TH_rsqrt(x);
    }

    public static double lerp(double a, double b, double weight) {
        return TH.TH_lerp(a, b, weight);
    }

    public static float sigmoidf(float value) {
        return TH.TH_sigmoidf(value);
    }

    public static float fracf(float x) {
        return TH.TH_fracf(x);
    }

    public static float rsqrtf(float x) {
        return TH.TH_rsqrtf(x);
    }

    public static float lerpf(float a, float b, float weight) {
        return TH.TH_lerpf(a, b, weight);
    }

    public static double erfinv(double y) {
        return TH.TH_erfinv(y);
    }

    public static double polevl(double x, double[] A) {
        CDoubleArray a = new CDoubleArray(A.length);
        for (int i = 0; i < A.length; i++)
            a.setitem(i, A[i]);
        return TH.TH_polevl(x, a.cast(), BigInteger.valueOf(A.length));
    }

    public static float polevlf(float x, float[] A) {
        CFloatArray a = new CFloatArray(A.length);
        for (int i = 0; i < A.length; i++)
            a.setitem(i, A[i]);
        return TH.TH_polevlf(x, a.cast(), BigInteger.valueOf(A.length));
    }

    public static double digamma(double x) {
        return TH.TH_digamma(x);
    }

    public static double digmmaf(float x) {
        return TH.TH_digammaf(x);
    }

    public static double trigamma(double x) {
        return TH.TH_trigamma(x);
    }

    public static float trigammaf(float x) {
        return TH.TH_trigammaf(x);
    }

    ////////////////
    // THLogAdd.h //
    ////////////////

    final public static double Log2Pi = TH.getTHLog2Pi();
    final public static double LogZero = TH.getTHLogZero();
    final public static double LogOne = TH.getTHLogOne();

    public static double logAdd(double log_a, double log_b) {
        return TH.THLogAdd(log_a, log_b);
    }

    public static double logSub(double log_a, double log_b) {
        return TH.THLogSub(log_a, log_b);
    }

    public static double expMinusApprox(double x) {
        return TH.THExpMinusApprox(x);
    }

    //////////////
    // THSize.h //
    //////////////

}
