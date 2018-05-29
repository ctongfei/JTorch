package jtorch;

import jtorch.jni.*;

/**
 * Proxy class for the Torch THGenerator type.
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

    // TODO: copy


    public void free() {
        TH.THGenerator_free(this);
    }

    public void close() {
        free();
    }

}
