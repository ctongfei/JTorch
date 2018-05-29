package jtorch;

import jtorch.jni.*;

import java.math.BigInteger;

/**
 * Proxy class for the Torch THGenerator type.
 * Also includes functions from THRandom.h.
 * @author Tongfei Chen
 */
public class Generator extends SWIGTYPE_p_THGenerator implements AutoCloseable {

    protected Generator(SWIGTYPE_p_THGenerator underlying) {
        super(SWIGTYPE_p_THGenerator.getCPtr(underlying), true);
    }

    protected long cPtr() {
        return SWIGTYPE_p_THGenerator.getCPtr(this);
    }

    public Generator() {
        this(TH.THGenerator_new());
    }

    public Generator copy(Generator from) {
        return new Generator(
                TH.THGenerator_copy(this, from)
        );
    }

    public void free() {
        TH.THGenerator_free(this);
    }

    public void close() {
        free();
    }

    ////////////////
    // THRandom.h //
    ////////////////

    public long seed() {
        return TH.THRandom_seed(this).longValue();
    }

    public void manualSeed(long seed) {
        TH.THRandom_manualSeed(this, BigInteger.valueOf(seed));
    }

    public long initialSeed() {
        return TH.THRandom_initialSeed(this).longValue();
    }

    public long random() {
        return TH.THRandom_random(this).longValue();
    }

    public long random64() {
        return TH.THRandom_random64(this).longValue();
    }

    public double standard_uniform() {
        return TH.THRandom_standard_uniform(this);
    }

    public double uniform(double a, double b) {
        return TH.THRandom_uniform(this, a, b);
    }

    public float uniformFloat(float a, float b) {
        return TH.THRandom_uniformFloat(this, a, b);
    }

    public double normal(double mean, double stdv) {
        return TH.THRandom_normal(this, mean, stdv);
    }

    public double exponential(double lambda) {
        return TH.THRandom_exponential(this, lambda);
    }

    public double standard_gamma(double alpha) {
        return TH.THRandom_standard_gamma(this, alpha);
    }

    public double cauchy(double median, double sigma) {
        return TH.THRandom_cauchy(this, median, sigma);
    }

    public double logNormal(double mean, double stdv) {
        return TH.THRandom_logNormal(this, mean, stdv);
    }

    public int geometric(double p) {
        return TH.THRandom_geometric(this, p);
    }

    public int bernoulli(double p) {
        return TH.THRandom_bernoulli(this, p);
    }

}

