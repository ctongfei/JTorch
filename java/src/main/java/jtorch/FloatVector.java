package jtorch;

import jtorch.jni.*;

/**
 * Wraps around TH*Vector_* functions that perform low-level array-pointer based operations.
 * @author Tongfei Chen
 */
public class FloatVector {

    ////////////////
    // THVector.h //
    ////////////////
    /** x[i] <- c (length n). */
    public static void fill(CFloatArray x, float c, long n) {
        TH.THFloatVector_fill(x.cast(), c, n);
    }

    /** z[i] <- x[i] + y[i] (length n). */
    public static void cadd(CFloatArray z, CFloatArray x, CFloatArray y, float c, long n) {
        TH.THFloatVector_cadd(z.cast(), x.cast(), y.cast(), c, n);
    }

    /** y[i] <- x[i] + c (length n). */
    public static void adds(CFloatArray y, CFloatArray x, float c, long n) {
        TH.THFloatVector_adds(y.cast(), x.cast(), c, n);
    }

    /** z[i] <- x[i] * y[i] (length n). */
    public static void cmul(CFloatArray z, CFloatArray x, CFloatArray y, long n) {
        TH.THFloatVector_cmul(z.cast(), x.cast(), y.cast(), n);
    }

    /** y[i] <- x[i] * c (length n). */
    public static void muls(CFloatArray y, CFloatArray x, float c, long n) {
        TH.THFloatVector_muls(y.cast(), x.cast(), c, n);
    }

    /** z[i] <- x[i] / y[i] (length n). */
    public static void cdiv(CFloatArray z, CFloatArray x, CFloatArray y, long n) {
        TH.THFloatVector_cdiv(z.cast(), x.cast(), y.cast(), n);
    }

    /** y[i] <- x[i] / c (length n). */
    public static void divs(CFloatArray y, CFloatArray x, float c, long n) {
        TH.THFloatVector_divs(y.cast(), x.cast(), c, n);
    }

    /** y[i] <- x[i] (length n). */
    public static void copy(CFloatArray y, CFloatArray x, long n) {
        TH.THFloatVector_copy(y.cast(), x.cast(), n);
    }

    /** y[i] <- -x[i] (length n). */
    public static void neg(CFloatArray y, CFloatArray x, long n) {
        TH.THFloatVector_neg(y.cast(), x.cast(), n);
    }

    /** data[i] <~ Normal(mean, stddev) (length n). */
    public static void normal_fill(CFloatArray data, long size, Generator generator, float mean, float stddev) {
        TH.THFloatVector_normal_fill(data.cast(), size, generator, mean, stddev);
    }
    /** y[i] = log(x[i]) (length n). */
    public static void log(CFloatArray y, CFloatArray x, long n) {
        TH.THFloatVector_log(y.cast(), x.cast(), n);
    }

    /** y[i] = lgamma(x[i]) (length n). */
    public static void lgamma(CFloatArray y, CFloatArray x, long n) {
        TH.THFloatVector_lgamma(y.cast(), x.cast(), n);
    }

    /** y[i] = digamma(x[i]) (length n). */
    public static void digamma(CFloatArray y, CFloatArray x, long n) {
        TH.THFloatVector_digamma(y.cast(), x.cast(), n);
    }

    /** y[i] = trigamma(x[i]) (length n). */
    public static void trigamma(CFloatArray y, CFloatArray x, long n) {
        TH.THFloatVector_trigamma(y.cast(), x.cast(), n);
    }

    /** y[i] = log10(x[i]) (length n). */
    public static void log10(CFloatArray y, CFloatArray x, long n) {
        TH.THFloatVector_log10(y.cast(), x.cast(), n);
    }

    /** y[i] = log1p(x[i]) (length n). */
    public static void log1p(CFloatArray y, CFloatArray x, long n) {
        TH.THFloatVector_log1p(y.cast(), x.cast(), n);
    }

    /** y[i] = log2(x[i]) (length n). */
    public static void log2(CFloatArray y, CFloatArray x, long n) {
        TH.THFloatVector_log2(y.cast(), x.cast(), n);
    }

    /** y[i] = sigmoid(x[i]) (length n). */
    public static void sigmoid(CFloatArray y, CFloatArray x, long n) {
        TH.THFloatVector_sigmoid(y.cast(), x.cast(), n);
    }

    /** y[i] = exp(x[i]) (length n). */
    public static void exp(CFloatArray y, CFloatArray x, long n) {
        TH.THFloatVector_exp(y.cast(), x.cast(), n);
    }

    /** y[i] = expm1(x[i]) (length n). */
    public static void expm1(CFloatArray y, CFloatArray x, long n) {
        TH.THFloatVector_expm1(y.cast(), x.cast(), n);
    }

    /** y[i] = erf(x[i]) (length n). */
    public static void erf(CFloatArray y, CFloatArray x, long n) {
        TH.THFloatVector_erf(y.cast(), x.cast(), n);
    }

    /** y[i] = erfinv(x[i]) (length n). */
    public static void erfinv(CFloatArray y, CFloatArray x, long n) {
        TH.THFloatVector_erfinv(y.cast(), x.cast(), n);
    }

    /** y[i] = cos(x[i]) (length n). */
    public static void cos(CFloatArray y, CFloatArray x, long n) {
        TH.THFloatVector_cos(y.cast(), x.cast(), n);
    }

    /** y[i] = acos(x[i]) (length n). */
    public static void acos(CFloatArray y, CFloatArray x, long n) {
        TH.THFloatVector_acos(y.cast(), x.cast(), n);
    }

    /** y[i] = cosh(x[i]) (length n). */
    public static void cosh(CFloatArray y, CFloatArray x, long n) {
        TH.THFloatVector_cosh(y.cast(), x.cast(), n);
    }

    /** y[i] = sin(x[i]) (length n). */
    public static void sin(CFloatArray y, CFloatArray x, long n) {
        TH.THFloatVector_sin(y.cast(), x.cast(), n);
    }

    /** y[i] = asin(x[i]) (length n). */
    public static void asin(CFloatArray y, CFloatArray x, long n) {
        TH.THFloatVector_asin(y.cast(), x.cast(), n);
    }

    /** y[i] = sinh(x[i]) (length n). */
    public static void sinh(CFloatArray y, CFloatArray x, long n) {
        TH.THFloatVector_sinh(y.cast(), x.cast(), n);
    }

    /** y[i] = tan(x[i]) (length n). */
    public static void atan(CFloatArray y, CFloatArray x, long n) {
        TH.THFloatVector_atan(y.cast(), x.cast(), n);
    }

    /** y[i] = tanh(x[i]) (length n). */
    public static void tanh(CFloatArray y, CFloatArray x, long n) {
        TH.THFloatVector_tanh(y.cast(), x.cast(), n);
    }

    /** y[i] = pow(x[i], c) (length n). */
    public static void pow(CFloatArray y, CFloatArray x, float c, long n) {
        TH.THFloatVector_pow(y.cast(), x.cast(), c, n);
    }

    /** y[i] = sqrt(x[i]) (length n). */
    public static void sqrt(CFloatArray y, CFloatArray x, long n) {
        TH.THFloatVector_sqrt(y.cast(), x.cast(), n);
    }

    /** y[i] = rsqrt(x[i]) (length n). */
    public static void rsqrt(CFloatArray y, CFloatArray x, long n) {
        TH.THFloatVector_rsqrt(y.cast(), x.cast(), n);
    }

    /** y[i] = ceil(x[i]) (length n). */
    public static void ceil(CFloatArray y, CFloatArray x, long n) {
        TH.THFloatVector_ceil(y.cast(), x.cast(), n);
    }

    /** y[i] = floor(x[i]) (length n). */
    public static void floor(CFloatArray y, CFloatArray x, long n) {
        TH.THFloatVector_floor(y.cast(), x.cast(), n);
    }

    /** y[i] = round(x[i]) (length n). */
    public static void round(CFloatArray y, CFloatArray x, long n) {
        TH.THFloatVector_round(y.cast(), x.cast(), n);
    }

    /** y[i] = abs(x[i]) (length n). */
    public static void abs(CFloatArray y, CFloatArray x, long n) {
        TH.THFloatVector_abs(y.cast(), x.cast(), n);
    }

    /** y[i] = trunc(x[i]) (length n). */
    public static void trunc(CFloatArray y, CFloatArray x, long n) {
        TH.THFloatVector_trunc(y.cast(), x.cast(), n);
    }

    /** y[i] = frac(x[i]) (length n). */
    public static void frac(CFloatArray y, CFloatArray x, long n) {
        TH.THFloatVector_frac(y.cast(), x.cast(), n);
    }

    /** y[i] = cinv(x[i]) (length n). */
    public static void cinv(CFloatArray y, CFloatArray x, long n) {
        TH.THFloatVector_cinv(y.cast(), x.cast(), n);
    }



}

