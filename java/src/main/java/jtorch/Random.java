package jtorch;

import jtorch.jni.TH;

import java.math.BigInteger;

/**
 * Wraps around THRandom_* functions.
 * @author Tongfei Chen
 */
public class Random {

    public static long seed(Generator generator) {
        return TH.THRandom_seed(generator).longValue();
    }

    public static void manualSeed(Generator generator, long seed) {
        TH.THRandom_manualSeed(generator, BigInteger.valueOf(seed));
    }

    public static long initialSeed(Generator generator) {
        return TH.THRandom_initialSeed(generator).longValue();
    }

    public static long random(Generator generator) {
        return TH.THRandom_random(generator).longValue();
    }

    public static long random64(Generator generator) {
        return TH.THRandom_random64(generator).longValue();
    }

    public static double standard_uniform(Generator generator) {
        return TH.THRandom_standard_uniform(generator);
    }

    public static double uniform(Generator generator, double a, double b) {
        return TH.THRandom_uniform(generator, a, b);
    }

    public static float uniformFloat(Generator generator, float a, float b) {
        return TH.THRandom_uniformFloat(generator, a, b);
    }

    public static double normal(Generator generator, double mean, double stdv) {
        return TH.THRandom_normal(generator, mean, stdv);
    }

    public static double exponential(Generator generator, double lambda) {
        return TH.THRandom_exponential(generator, lambda);
    }

    public static double standard_gamma(Generator generator, double alpha) {
        return TH.THRandom_standard_gamma(generator, alpha);
    }

    public static double cauchy(Generator generator, double median, double sigma) {
        return TH.THRandom_cauchy(generator, median, sigma);
    }

    public static double logNormal(Generator generator, double mean, double stdv) {
        return TH.THRandom_logNormal(generator, mean, stdv);
    }

    public static int geometric(Generator generator, double p) {
        return TH.THRandom_geometric(generator, p);
    }

    public static int bernoulli(Generator generator, double p) {
        return TH.THRandom_bernoulli(generator, p);
    }

}
