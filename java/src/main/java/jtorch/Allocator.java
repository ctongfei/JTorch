package jtorch;

import jtorch.jni.*;

/**
 * Proxy class for the Torch Allocator type.
 * @author Tongfei Chen
 */
public class Allocator extends THAllocator implements NativeObject {

    protected Allocator(THAllocator underlying) {
        super(THAllocator.getCPtr(underlying), true);
    }

    public long cPtr() {
        return THAllocator.getCPtr(this);
    }

    public static Allocator defaultAllocator() {
        return new Allocator(TH.getTHDefaultAllocator());
    }

    public static Allocator mapAllocator() {
        return new Allocator(TH.getTHMapAllocator());
    }

    public static Allocator refCountedMapAllocator() {
        return new Allocator(TH.getTHRefcountedMapAllocator());
    }

}

