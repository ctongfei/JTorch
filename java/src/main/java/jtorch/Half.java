package jtorch;

import jtorch.jni.*;

/**
 * @author Tongfei Chen
 */
public class Half extends __THHalf {

    public Half() { this(TH.TH_float2half(0f)); }

    protected Half(__THHalf underlying) {
        super(__THHalf.getCPtr(underlying), true);
    }

    protected long cPtr() {
        return __THHalf.getCPtr(this);
    }

    public float toFloat() {
        return TH.TH_half2float(this);
    }

    public static Half fromFloat(float f) {
        return new Half(TH.TH_float2half(f));
    }

}
