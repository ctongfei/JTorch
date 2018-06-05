package jtorch;

import jtorch.jni.*;

/**
 * Proxy class for the Torch MapAllocatorContext type.
 * @author Tongfei Chen
 */
public class MapAllocatorContext extends SWIGTYPE_p_THMapAllocatorContext_ implements AutoCloseable {

    protected MapAllocatorContext(SWIGTYPE_p_THMapAllocatorContext_ underlying) {
        super(SWIGTYPE_p_THMapAllocatorContext_.getCPtr(underlying), true);
    }

    protected long cPtr() {
        return SWIGTYPE_p_THMapAllocatorContext_.getCPtr(this);
    }

    public MapAllocatorContext(String filename, int flags) {
        this(TH.THMapAllocatorContext_new(filename, flags));
    }

    public static MapAllocatorContext newWithFd(String filename, int fd, int flags) {
        return new MapAllocatorContext(
                TH.THMapAllocatorContext_newWithFd(filename, fd, flags)
        );
    }

    public String filename() {
        return TH.THMapAllocatorContext_filename(this);
    }

    public int fd() {
        return TH.THMapAllocatorContext_fd(this);
    }

    public long size() {
        return TH.THMapAllocatorContext_size(this);
    }

    public void free() {
        TH.THMapAllocatorContext_free(this);
    }

    public void incref(SWIGTYPE_p_void data) {
        TH.THRefcountedMapAllocator_incref(this, data);
    }

    public void decref(SWIGTYPE_p_void data) {
        TH.THRefcountedMapAllocator_decref(this, data);
    }

    public void close() {
        free();
    }

}
