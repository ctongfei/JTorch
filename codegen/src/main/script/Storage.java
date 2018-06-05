package jtorch;

import jtorch.jni.*;

/**
 * Java proxy class for the TH*Storage types.
 * @author Tongfei Chen
 */
public class JStorage extends THStorage implements WithFlag, OffHeapMemory {

    public JStorage() {
        this(TH.THStorage_(new)());
    }

    protected JStorage(THStorage underlying) {
        super(THStorage.getCPtr(underlying), true);
    }

    protected long cPtr() {
        return THStorage.getCPtr(this);
    }

    /** Returns the underlying raw pointer wrapped in a SWIG-generated wrapper.*/
    public CArray data() {
        return CArray.frompointer(TH.THStorage_(data)(this));
    }

    /** Returns the size of this storage object. */
    public long size() {
        return TH.THStorage_(size)(this);
    }

    /** Returns the number of bytes of the element stored in this storage object.*/
    public static long elementSize() {
        return TH.THStorage_(elementSize)().longValue();
    }

    /** Sets a specific value in this storage. */
    public void set(long index, JType value) {
        TH.THStorage_(set)(this, index, value);
    }

    /** Gets a specific value in this storage. */
    public JType get(long index) {
        return TH.THStorage_(get)(this, index);
    }

    /** Creates a storage object with the given size. */
    public static JStorage newWithSize(int size) {
        return new JStorage(
                TH.THStorage_(newWithSize)(size)
        );
    }

    /** Creates a storage object with size 1, populating it with the given element. */
    public static JStorage newWithSize1(JType n0) {
        return new JStorage(
                TH.THStorage_(newWithSize1)(n0)
        );
    }

    /** Creates a storage object with size 2, populating it with the given two elements. */
    public static JStorage newWithSize2(JType n0, JType n1) {
        return new JStorage(
                TH.THStorage_(newWithSize2)(n0, n1)
        );
    }

    /** Creates a storage object with size 3, populating it with the given three elements. */
    public static JStorage newWithSize3(JType n0, JType n1, JType n2) {
        return new JStorage(
                TH.THStorage_(newWithSize3)(n0, n1, n2)
        );
    }

    /** Creates a storage object with size 4, populating it with the given four elements. */
    public static JStorage newWithSize4(JType n0, JType n1, JType n2, JType n3) {
        return new JStorage(
                TH.THStorage_(newWithSize4)(n0, n1, n2, n3)
        );
    }

    public static JStorage newWithMapping(String filename, long size, int flags) {
        return new JStorage(
                TH.THStorage_(newWithMapping)(filename, size, flags)
        );
    }

    /** Creates a new storage object with the given data pointer and size. */
    public static JStorage newWithData(CArray data, long size) {
        return new JStorage(
                TH.THStorage_(newWithData)(data.cast(), size)
        );
    }

    public static JStorage newWithAllocator(long size, Allocator allocator, SWIGTYPE_p_void allocatorContext) {
        return new JStorage(
                TH.THStorage_(newWithAllocator)(size, allocator, allocatorContext)
        );
    }

    public static JStorage newWithDataAndAllocator(CArray data, long size, Allocator allocator, SWIGTYPE_p_void allocatorContext) {
        return new JStorage(
                TH.THStorage_(newWithDataAndAllocator)(data.cast(), size, allocator, allocatorContext)
        );
    }

    public void setFlag(char flag) {
        TH.THStorage_(setFlag)(this, flag);
    }

    public void clearFlag(char flag) {
        TH.THStorage_(clearFlag)(this, flag);
    }

    public void retain() {
        TH.THStorage_(retain)(this);
    }

    /** Swaps the memory allocated by two storage objects. */
    public static void swap(JStorage storage1, JStorage storage2) {
        TH.THStorage_(swap)(storage1, storage2);
    }

    /** Frees the memory allocated with this object. */
    public void free() {
        TH.THStorage_(free)(this);
    }

    public void resize(long size) {
        TH.THStorage_(resize)(this, size);
    }

    public void fill(JType value) {
        TH.THStorage_(fill)(this, value);
    }

    public void close() {
        free();
    }

    /**
     * Creates a storage object from a Java array.
     * @implNote Data is copied once.
     * @apiNote Not in Torch.
     */
    public static JStorage fromJava(JType[] data) {
        CArray a = new CArray(data.length);
        for (int i = 0; i < data.length; i++)
            a.setitem(i, data[i]);
        return newWithData(a, data.length);
    }


}
