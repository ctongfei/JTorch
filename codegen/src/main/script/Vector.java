package jtorch;

import jtorch.jni.*;

/**
 * Wraps around TH*Vector_* functions that perform low-level array-pointer based operations.
 * @author Tongfei Chen
 */
public class JVector {

    ////////////////
    // THVector.h //
    ////////////////
    /** x[i] <- c (length n). */
    public static void fill(CArray x, JType c, long n) {
        TH.THVector_(fill)(x.cast(), c, n);
    }

    /** z[i] <- x[i] + y[i] (length n). */
    public static void cadd(CArray z, CArray x, CArray y, JType c, long n) {
        TH.THVector_(cadd)(z.cast(), x.cast(), y.cast(), c, n);
    }

    /** y[i] <- x[i] + c (length n). */
    public static void adds(CArray y, CArray x, JType c, long n) {
        TH.THVector_(adds)(y.cast(), x.cast(), c, n);
    }

    /** z[i] <- x[i] * y[i] (length n). */
    public static void cmul(CArray z, CArray x, CArray y, long n) {
        TH.THVector_(cmul)(z.cast(), x.cast(), y.cast(), n);
    }

    /** y[i] <- x[i] * c (length n). */
    public static void muls(CArray y, CArray x, JType c, long n) {
        TH.THVector_(muls)(y.cast(), x.cast(), c, n);
    }

    /** z[i] <- x[i] / y[i] (length n). */
    public static void cdiv(CArray z, CArray x, CArray y, long n) {
        TH.THVector_(cdiv)(z.cast(), x.cast(), y.cast(), n);
    }

    /** y[i] <- x[i] / c (length n). */
    public static void divs(CArray y, CArray x, JType c, long n) {
        TH.THVector_(divs)(y.cast(), x.cast(), c, n);
    }

    /** y[i] <- x[i] (length n). */
    public static void copy(CArray y, CArray x, long n) {
        TH.THVector_(copy)(y.cast(), x.cast(), n);
    }

    /** y[i] <- -x[i] (length n). */
    public static void neg(CArray y, CArray x, long n) {
        TH.THVector_(neg)(y.cast(), x.cast(), n);
    }

    /** data[i] <~ Normal(mean, stddev) (length n). */
    public static void normal_fill(CArray data, long size, Generator generator, JType mean, JType stddev) {
        TH.THVector_(normal_fill)(data.cast(), size, generator, mean, stddev);
    }

#if defined(TH_REAL_IS_SHORT) || defined(TH_REAL_IS_INT) || defined(TH_REAL_IS_LONG)

    /** y[i] = abs(x[i]) (length n). */
    public static void abs(CArray y, CArray x, long n) {
        TH.THVector_(abs)(y.cast(), x.cast(), n);
    }

#endif

#if defined(TH_REAL_IS_FLOAT) || defined(TH_REAL_IS_DOUBLE)

    /** y[i] = log(x[i]) (length n). */
    public static void log(CArray y, CArray x, long n) {
        TH.THVector_(log)(y.cast(), x.cast(), n);
    }

    /** y[i] = lgamma(x[i]) (length n). */
    public static void lgamma(CArray y, CArray x, long n) {
        TH.THVector_(lgamma)(y.cast(), x.cast(), n);
    }

    /** y[i] = digamma(x[i]) (length n). */
    public static void digamma(CArray y, CArray x, long n) {
        TH.THVector_(digamma)(y.cast(), x.cast(), n);
    }

    /** y[i] = trigamma(x[i]) (length n). */
    public static void trigamma(CArray y, CArray x, long n) {
        TH.THVector_(trigamma)(y.cast(), x.cast(), n);
    }

    /** y[i] = log10(x[i]) (length n). */
    public static void log10(CArray y, CArray x, long n) {
        TH.THVector_(log10)(y.cast(), x.cast(), n);
    }

    /** y[i] = log1p(x[i]) (length n). */
    public static void log1p(CArray y, CArray x, long n) {
        TH.THVector_(log1p)(y.cast(), x.cast(), n);
    }

    /** y[i] = log2(x[i]) (length n). */
    public static void log2(CArray y, CArray x, long n) {
        TH.THVector_(log2)(y.cast(), x.cast(), n);
    }

    /** y[i] = sigmoid(x[i]) (length n). */
    public static void sigmoid(CArray y, CArray x, long n) {
        TH.THVector_(sigmoid)(y.cast(), x.cast(), n);
    }

    /** y[i] = exp(x[i]) (length n). */
    public static void exp(CArray y, CArray x, long n) {
        TH.THVector_(exp)(y.cast(), x.cast(), n);
    }

    /** y[i] = expm1(x[i]) (length n). */
    public static void expm1(CArray y, CArray x, long n) {
        TH.THVector_(expm1)(y.cast(), x.cast(), n);
    }

    /** y[i] = erf(x[i]) (length n). */
    public static void erf(CArray y, CArray x, long n) {
        TH.THVector_(erf)(y.cast(), x.cast(), n);
    }

    /** y[i] = erfinv(x[i]) (length n). */
    public static void erfinv(CArray y, CArray x, long n) {
        TH.THVector_(erfinv)(y.cast(), x.cast(), n);
    }

    /** y[i] = cos(x[i]) (length n). */
    public static void cos(CArray y, CArray x, long n) {
        TH.THVector_(cos)(y.cast(), x.cast(), n);
    }

    /** y[i] = acos(x[i]) (length n). */
    public static void acos(CArray y, CArray x, long n) {
        TH.THVector_(acos)(y.cast(), x.cast(), n);
    }

    /** y[i] = cosh(x[i]) (length n). */
    public static void cosh(CArray y, CArray x, long n) {
        TH.THVector_(cosh)(y.cast(), x.cast(), n);
    }

    /** y[i] = sin(x[i]) (length n). */
    public static void sin(CArray y, CArray x, long n) {
        TH.THVector_(sin)(y.cast(), x.cast(), n);
    }

    /** y[i] = asin(x[i]) (length n). */
    public static void asin(CArray y, CArray x, long n) {
        TH.THVector_(asin)(y.cast(), x.cast(), n);
    }

    /** y[i] = sinh(x[i]) (length n). */
    public static void sinh(CArray y, CArray x, long n) {
        TH.THVector_(sinh)(y.cast(), x.cast(), n);
    }

    /** y[i] = tan(x[i]) (length n). */
    public static void atan(CArray y, CArray x, long n) {
        TH.THVector_(atan)(y.cast(), x.cast(), n);
    }

    /** y[i] = tanh(x[i]) (length n). */
    public static void tanh(CArray y, CArray x, long n) {
        TH.THVector_(tanh)(y.cast(), x.cast(), n);
    }

    /** y[i] = pow(x[i], c) (length n). */
    public static void pow(CArray y, CArray x, JType c, long n) {
        TH.THVector_(pow)(y.cast(), x.cast(), c, n);
    }

    /** y[i] = sqrt(x[i]) (length n). */
    public static void sqrt(CArray y, CArray x, long n) {
        TH.THVector_(sqrt)(y.cast(), x.cast(), n);
    }

    /** y[i] = rsqrt(x[i]) (length n). */
    public static void rsqrt(CArray y, CArray x, long n) {
        TH.THVector_(rsqrt)(y.cast(), x.cast(), n);
    }

    /** y[i] = ceil(x[i]) (length n). */
    public static void ceil(CArray y, CArray x, long n) {
        TH.THVector_(ceil)(y.cast(), x.cast(), n);
    }

    /** y[i] = floor(x[i]) (length n). */
    public static void floor(CArray y, CArray x, long n) {
        TH.THVector_(floor)(y.cast(), x.cast(), n);
    }

    /** y[i] = round(x[i]) (length n). */
    public static void round(CArray y, CArray x, long n) {
        TH.THVector_(round)(y.cast(), x.cast(), n);
    }

    /** y[i] = abs(x[i]) (length n). */
    public static void abs(CArray y, CArray x, long n) {
        TH.THVector_(abs)(y.cast(), x.cast(), n);
    }

    /** y[i] = trunc(x[i]) (length n). */
    public static void trunc(CArray y, CArray x, long n) {
        TH.THVector_(trunc)(y.cast(), x.cast(), n);
    }

    /** y[i] = frac(x[i]) (length n). */
    public static void frac(CArray y, CArray x, long n) {
        TH.THVector_(frac)(y.cast(), x.cast(), n);
    }

    /** y[i] = cinv(x[i]) (length n). */
    public static void cinv(CArray y, CArray x, long n) {
        TH.THVector_(cinv)(y.cast(), x.cast(), n);
    }

#endif

}
