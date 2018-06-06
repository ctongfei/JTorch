package jtorch;

import jtorch.jni.*;

/**
 * Wraps around the C void* type.
 * @author Tongfei Chen
 */
public class PtrVoid extends SWIGTYPE_p_void {

    protected PtrVoid(SWIGTYPE_p_void underlying) {
        super(SWIGTYPE_p_void.getCPtr(underlying), true);
    }

    protected PtrVoid(long cPtr) {
        super(cPtr, true);
    }

    public static PtrVoid create(long cPtr) {
        return new PtrVoid(cPtr);
    }

}
