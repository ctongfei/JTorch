package jtorch.cuda;

import jtorch.jni.*;

/**
 * Proxy class for the Torch THCState type.
 * @author Tongfei Chen
 */
public class State extends THCState implements AutoCloseable {

    protected State(THCState underlying) {
        super(THCState.getCPtr(underlying), true);
    }

    protected long cPtr() {
        return THCState.getCPtr(this);
    }

    public State() {
        this(TH.THCState_alloc());
    }

    public void free() {
        TH.THCState_free(this);
    }

    @Override
    public void close() {
        free();
    }
}
