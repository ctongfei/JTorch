package jtorch;

import jtorch.jni.*;

import java.math.BigInteger;

/**
 * Wraps around constants and functions in THMath.h, THLogAdd.h and THSize.h.
 * @author Tongfei Chen
 */
public class Torch {

    //////////////
    // THMath.h //
    //////////////

    public double sigmoid(double value) {
        return TH.TH_sigmoid(value);
    }

    public double frac(double x) {
        return TH.TH_frac(x);
    }

    /** Inverse square root. */
    public double rsqrt(double x) {
        return TH.TH_rsqrt(x);
    }

    public double lerp(double a, double b, double weight) {
        return TH.TH_lerp(a, b, weight);
    }

    public float sigmoidf(float value) {
        return TH.TH_sigmoidf(value);
    }

    public float fracf(float x) {
        return TH.TH_fracf(x);
    }

    public float rsqrtf(float x) {
        return TH.TH_rsqrtf(x);
    }

    public float lerpf(float a, float b, float weight) {
        return TH.TH_lerpf(a, b, weight);
    }

    public double erfinv(double y) {
        return TH.TH_erfinv(y);
    }

    public double polevl(double x, double[] A) {
        CDoubleArray a = new CDoubleArray(A.length);
        for (int i = 0; i < A.length; i++)
            a.setitem(i, A[i]);
        return TH.TH_polevl(x, a.cast(), BigInteger.valueOf(A.length));
    }

    public float polevlf(float x, float[] A) {
        CFloatArray a = new CFloatArray(A.length);
        for (int i = 0; i < A.length; i++)
            a.setitem(i, A[i]);
        return TH.TH_polevlf(x, a.cast(), BigInteger.valueOf(A.length));
    }

    public double digamma(double x) {
        return TH.TH_digamma(x);
    }

    public double digmmaf(float x) {
        return TH.TH_digammaf(x);
    }

    public double trigamma(double x) {
        return TH.TH_trigamma(x);
    }

    public float trigammaf(float x) {
        return TH.TH_trigammaf(x);
    }

    ////////////////
    // THLogAdd.h //
    ////////////////

    final public static double Log2Pi = TH.getTHLog2Pi();
    final public static double LogZero = TH.getTHLogZero();
    final public static double LogOne = TH.getTHLogOne();

    double logAdd(double log_a, double log_b) {
        return TH.THLogAdd(log_a, log_b);
    }

    double logSub(double log_a, double log_b) {
        return TH.THLogSub(log_a, log_b);
    }

    double expMinusApprox(double x) {
        return TH.THExpMinusApprox(x);
    }

    //////////////
    // THSize.h //
    //////////////

}
