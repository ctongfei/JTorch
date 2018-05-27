package jtorch;

import jtorch.jni.*;

/**
 * Proxy class for the Torch THCState type.
 * @author Tongfei Chen
 */
public class CudaState extends THCState {

    public CudaState() {
        TH.THCState_alloc();
    }

    public void free() {
        TH.THCState_free(this);
    }

}
