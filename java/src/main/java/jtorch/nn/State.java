package jtorch.nn;

import jtorch.jni.*;

/**
 * Proxy class for the Torch THNNState type.
 * @author Tongfei Chen
 */
public class State extends SWIGTYPE_p_void {

    protected State(SWIGTYPE_p_void underlying) {
        super(SWIGTYPE_p_void.getCPtr(underlying), true);
    }

    protected State() {
        super();
    }

    protected long cPtr() {
        return SWIGTYPE_p_void.getCPtr(this);
    }

    public static final State INSTANCE = new State();

}
