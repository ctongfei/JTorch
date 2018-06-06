// GENERATED FROM "generate-th.sh" TO EMULATE C-STYLE TEMPLATES.
// DO NOT MODIFY.

package jtorch;

import jtorch.jni.*;

/**
 * Proxy object that wraps around the TH*Tensor C type.
 * @author Tongfei Chen
 */
public class FloatTensor extends THFloatTensor implements Cloneable, WithFlag, OffHeapMemory {

    /** Creates an empty tensor. */
    public FloatTensor() {
        this(TH.THFloatTensor_new());
    }

    protected FloatTensor(THFloatTensor underlying) {
        super(THFloatTensor.getCPtr(underlying), true);
    }

    public long cPtr() {
        return THFloatTensor.getCPtr(this);
    }

    /** Returns the underlying storage object. */
    public FloatStorage storage() {
        return new FloatStorage(TH.THFloatTensor_storage(this));
    }

    /** Returns the storage offset of this tensor. */
    public long storageOffset() {
        return TH.THFloatTensor_storageOffset(this);
    }

    /** Returns the number of dimensions (a.k.a. rank) of this tensor. */
    public int nDimension() {
        return TH.THFloatTensor_nDimension(this);
    }

    /** Returns the size of the given dimension. */
    public long size(int dim) {
        return TH.THFloatTensor_size(this, dim);
    }

    /** Returns the stride of the given dimension. */
    public long stride(int dim) {
        return TH.THFloatTensor_stride(this, dim);
    }

    /** Returns a new storage object that contains the sizes of the dimensions in this tensor. */
    public LongStorage newSizeOf() {
        return new LongStorage(
                TH.THFloatTensor_newSizeOf(this)
        );
    }

    /** Returns a new storage object that contains the strides of the dimensions in this tensor. */
    public LongStorage newStrideOf() {
        return new LongStorage(
                TH.THFloatTensor_newStrideOf(this)
        );
    }

    /** Returns a SWIG wrapper-wrapped raw pointer of the underlying storage. */
    public CFloatArray data() {
        return CFloatArray.frompointer(TH.THFloatTensor_data(this));
    }

    public void setFlag(char flag) {
        TH.THFloatTensor_setFlag(this, flag);
    }

    public void clearFlag(char flag) {
        TH.THFloatTensor_clearFlag(this, flag);
    }

    /** Creates a shallow copy (pointer copy) of the given tensor. */
    public static FloatTensor newWithTensor(FloatTensor tensor) {
        return new FloatTensor(
                TH.THFloatTensor_newWithTensor(tensor)
        );
    }

    /** Creates a new tensor from the given storage, offset, sizes and strides. */
    public static FloatTensor newWithStorage(FloatStorage storage, long storageOffset, LongStorage size, LongStorage stride) {
        return new FloatTensor(
                TH.THFloatTensor_newWithStorage(storage, storageOffset, size, stride)
        );
    }

    /** Creates a 1-D tensor with the given size and stride from the given storage. */
    public static FloatTensor newWithStorage1d(FloatStorage storage, long storageOffset, long size0, long stride0) {
        return new FloatTensor(
                TH.THFloatTensor_newWithStorage1d(storage, storageOffset, size0, stride0)
        );
    }

    /** Creates a 2-D tensor with the given sizes and strides from the given storage. */
    public static FloatTensor newWithStorage2d(
            FloatStorage storage, long storageOffset,
            long size0, long stride0,
            long size1, long stride1) {
        return new FloatTensor(
                TH.THFloatTensor_newWithStorage2d(storage, storageOffset,
                        size0, stride0, size1, stride1)
        );
    }

    /** Creates a 3-D tensor with the given sizes and strides from the given storage. */
    public static FloatTensor newWithStorage3d(
            FloatStorage storage, long storageOffset,
            long size0, long stride0,
            long size1, long stride1,
            long size2, long stride2) {
        return new FloatTensor(
                TH.THFloatTensor_newWithStorage3d(storage, storageOffset,
                        size0, stride0, size1, stride1, size2, stride2)
        );
    }

    /** Creates a 4-D tensor with the given sizes and strides from the given storage. */
    public static FloatTensor newWithStorage4d(
            FloatStorage storage, long storageOffset,
            long size0, long stride0,
            long size1, long stride1,
            long size2, long stride2,
            long size3, long stride3) {
        return new FloatTensor(
                TH.THFloatTensor_newWithStorage4d(storage, storageOffset,
                        size0, stride0, size1, stride1, size2, stride2, size3, stride3)
        );
    }

    /** Creates a new tensor with the given size and stride array. */
    public static FloatTensor newWithSize(LongStorage size, LongStorage stride) {
        return new FloatTensor(
                TH.THFloatTensor_newWithSize(size, stride)
        );
    }

    /** Creates a new 1-D tensor with the given size. */
    public static FloatTensor newWithSize1d(long size0) {
        return new FloatTensor(
                TH.THFloatTensor_newWithSize1d(size0)
        );
    }

    /** Creates a new 2-D tensor with the given sizes. */
    public static FloatTensor newWithSize2d(long size0, long size1) {
        return new FloatTensor(
                TH.THFloatTensor_newWithSize2d(size0, size1)
        );
    }

    /** Creates a new 3-D tensor with the given sizes. */
    public static FloatTensor newWithSize3d(long size0, long size1, long size2) {
        return new FloatTensor(
                TH.THFloatTensor_newWithSize3d(size0, size1, size2)
        );
    }

    /** Creates a new 4-D tensor with the given sizes. */
    public static FloatTensor newWithSize4d(long size0, long size1, long size2, long size3) {
        return new FloatTensor(
                TH.THFloatTensor_newWithSize4d(size0, size1, size2, size3)
        );
    }

    /** Creates a new tensor that is a clone of the given tensor. */
    public static FloatTensor newClone(FloatTensor self) {
        return new FloatTensor(
                TH.THFloatTensor_newClone(self)
        );
    }

    @Override
    public FloatTensor clone() {
        return FloatTensor.newClone(this);
    }

    /** Creates a memory-contiguous tensor copy of the given tensor. */
    public static FloatTensor newContiguous(FloatTensor self) {
        return new FloatTensor(
                TH.THFloatTensor_newContiguous(self)
        );
    }

    /** Returns a memory-contiguous copy of this tensor. */
    public FloatTensor contiguous() {
        return newContiguous(this);
    }

    public static FloatTensor newSelect(FloatTensor self, int dimension, long sliceIndex) {
        return new FloatTensor(
                TH.THFloatTensor_newSelect(self, dimension, sliceIndex)
        );
    }

    public static FloatTensor newNarrow(FloatTensor self, int dimension, long firstIndex, long size) {
        return new FloatTensor(
                TH.THFloatTensor_newNarrow(self, dimension, firstIndex, size)
        );
    }

    public static FloatTensor newTranspose(FloatTensor self, int dimension1, int dimension2) {
        return new FloatTensor(
                TH.THFloatTensor_newTranspose(self, dimension1, dimension2)
        );
    }

    public static FloatTensor newUnfold(FloatTensor self, int dimension, long size, long step) {
        return new FloatTensor(
                TH.THFloatTensor_newUnfold(self, dimension, size, step)
        );
    }

    public static FloatTensor newView(FloatTensor tensor, LongStorage size) {
        return new FloatTensor(
                TH.THFloatTensor_newView(tensor, size)
        );
    }

    public void resize(LongStorage size, LongStorage stride) {
        TH.THFloatTensor_resize(this, size, stride);
    }

    public void resizeAs(FloatTensor src) {
        TH.THFloatTensor_resizeAs(this, src);
    }

    public void resize1d(long size0) {
        TH.THFloatTensor_resize1d(this, size0);
    }

    public void resize2d(long size0, long size1) {
        TH.THFloatTensor_resize2d(this, size0, size1);
    }

    public void resize3d(long size0, long size1, long size2) {
        TH.THFloatTensor_resize3d(this, size0, size1, size2);
    }

    public void resize4d(long size0, long size1, long size2, long size3) {
        TH.THFloatTensor_resize4d(this, size0, size1, size2, size3);
    }

    public void resize5d(long size0, long size1, long size2, long size3, long size4) {
        TH.THFloatTensor_resize5d(this, size0, size1, size2, size3, size4);
    }

    public void set(FloatTensor src) {
        TH.THFloatTensor_set(this, src);
    }

    public void setStorage(FloatStorage storage, long storageOffset, LongStorage size, LongStorage stride) {
        TH.THFloatTensor_setStorage(this, storage, storageOffset, size, stride);
    }

    public void setStorage1d(FloatStorage storage, long storageOffset, long size0, long stride0) {
        TH.THFloatTensor_setStorage1d(this, storage, storageOffset, size0, stride0);
    }

    public void setStorage2d(FloatStorage storage, long storageOffset,
                             long size0, long stride0,
                             long size1, long stride1
    ) {
        TH.THFloatTensor_setStorage2d(this, storage, storageOffset,
                size0, stride0,
                size1, stride1
        );
    }

    public void setStorage3d(FloatStorage storage, long storageOffset,
                             long size0, long stride0,
                             long size1, long stride1,
                             long size2, long stride2
    ) {
        TH.THFloatTensor_setStorage3d(this, storage, storageOffset,
                size0, stride0,
                size1, stride1,
                size2, stride2
        );
    }

    public void setStorage4d(FloatStorage storage, long storageOffset,
                             long size0, long stride0,
                             long size1, long stride1,
                             long size2, long stride2,
                             long size3, long stride3
    ) {
        TH.THFloatTensor_setStorage4d(this, storage, storageOffset,
                size0, stride0,
                size1, stride1,
                size2, stride2,
                size3, stride3
        );
    }

    public FloatTensor narrow(int dimension, long firstIndex, long size) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_narrow(r, this, dimension, firstIndex, size);
        return r;
    }

    public FloatTensor select(int dimension, long sliceIndex) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_select(r, this, dimension, sliceIndex);
        return r;
    }

    public FloatTensor transpose(int dimension1, int dimension2) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_transpose(r, this, dimension1, dimension2);
        return r;
    }

    public FloatTensor unfold(int dimension, long size, long step) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_unfold(r, this, dimension, size, step);
        return r;
    }

    public FloatTensor squeeze() {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_squeeze(r, this);
        return r;
    }

    public FloatTensor squeeze1d(int dimension) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_squeeze1d(r, this, dimension);
        return r;
    }

    public FloatTensor unsqueeze1d(int dimension) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_unsqueeze1d(r, this, dimension);
        return r;
    }

    public boolean isContiguous() {
        return TH.THFloatTensor_isContiguous(this) != 0;
    }

    public boolean isSameSizeAs(FloatTensor that) {
        return TH.THFloatTensor_isSameSizeAs(this, that) != 0;
    }

    public boolean isSetTo(FloatTensor src) {
        return TH.THFloatTensor_isSetTo(this, src) != 0;
    }

    public boolean isSize(LongStorage dims) {
        return TH.THFloatTensor_isSize(this, dims) != 0;
    }

    public long nElement() {
        return TH.THFloatTensor_nElement(this);
    }

    public void retain() {
        TH.THFloatTensor_retain(this);
    }

    public void free() {
        TH.THFloatTensor_free(this);
    }

    public void freeCopyTo(FloatTensor dst) {
        TH.THFloatTensor_freeCopyTo(this, dst);
    }


    public void set1d(long x0, float value) {
        TH.THFloatTensor_set1d(this, x0, value);
    }

    public float get1d(long x0) {
        return TH.THFloatTensor_get1d(this, x0);
    }

    public void set2d(long x0, long x1, float value) {
        TH.THFloatTensor_set2d(this, x0, x1, value);
    }

    public float get2d(long x0, long x1) {
        return TH.THFloatTensor_get2d(this, x0, x1);
    }

    public void set3d(long x0, long x1, long x2, float value) {
        TH.THFloatTensor_set3d(this, x0, x1, x2, value);
    }

    public float get3d(long x0, long x1, long x2) {
        return TH.THFloatTensor_get3d(this, x0, x1, x2);
    }

    public void set4d(long x0, long x1, long x2, long x3, float value) {
        TH.THFloatTensor_set4d(this, x0, x1, x2, x3, value);
    }

    public float get4d(long x0, long x1, long x2, long x3) {
        return TH.THFloatTensor_get4d(this, x0, x1, x2, x3);
    }

    /** Returns a DescBuff object that describes this tensor. */
    public DescBuff desc() {
        return new DescBuff(
                TH.THFloatTensor_desc(this)
        );
    }

    /** Returns a DescBuff object that describes the sizes of this tensor. */
    public DescBuff sizeDesc() {
        return new DescBuff(
                TH.THFloatTensor_sizeDesc(this)
        );
    }

    // CONV

    // COPY
    public void copy(FloatTensor src) {
        TH.THFloatTensor_copy(this, src);
    }

    public void copyUByte(UByteTensor src) {
        TH.THFloatTensor_copyByte(this, src);
    }

    public void copyByte(ByteTensor src) {
        TH.THFloatTensor_copyChar(this, src);
    }

    public void copyShort(ShortTensor src) {
        TH.THFloatTensor_copyShort(this, src);
    }

    public void copyInt(IntTensor src) {
        TH.THFloatTensor_copyInt(this, src);
    }

    public void copyLong(LongTensor src) {
        TH.THFloatTensor_copyLong(this, src);
    }

    public void copyFloat(FloatTensor src) {
        TH.THFloatTensor_copyFloat(this, src);
    }

    public void copyDouble(DoubleTensor src) {
        TH.THFloatTensor_copyDouble(this, src);
    }

    // TODO: copyHalf

    // MATH
    public void fill(float value) {
        TH.THFloatTensor_fill(this, value);
    }

    public void zero() {
        TH.THFloatTensor_zero(this);
    }

    public void maskedFill(UByteTensor mask, float value) {
        TH.THFloatTensor_maskedFill(this, mask, value);
    }

    public void maskedCopy(UByteTensor mask, FloatTensor src) {
        TH.THFloatTensor_maskedCopy(this, mask, src);
    }

    public void maskedSelect(FloatTensor src, UByteTensor mask) {
        TH.THFloatTensor_maskedSelect(this, src, mask);
    }

    public LongTensor nonzero() {
        LongTensor r = new LongTensor();
        TH.THFloatTensor_nonzero(r, this);
        return r;
    }

    public FloatTensor indexSelect(int dim, LongTensor index) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_indexSelect(r, this, dim, index);
        return r;
    }

    public FloatTensor indexCopy(int dim, LongTensor index) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_indexCopy(r, dim, index, this);
        return r;
    }

    public void indexAdd(int dim, LongTensor index, FloatTensor src) {
        TH.THFloatTensor_indexAdd(this, dim, index, src);
    }

    public void indexFill(int dim, LongTensor index, float value) {
        TH.THFloatTensor_indexFill(this, dim, index, value);
    }

    public FloatTensor take(LongTensor index) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_take(r, this, index);
        return r;
    }

    public void put(LongTensor index, FloatTensor src, boolean accumulate) {
        TH.THFloatTensor_put(this, index, src, accumulate ? 1 : 0);
    }

    public FloatTensor gather(int dim, LongTensor index) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_gather(r, this, dim, index);
        return r;
    }

    public void scatter(int dim, LongTensor index, FloatTensor src) {
        TH.THFloatTensor_scatter(this, dim, index, src);
    }

    public void scatterAdd(int dim, LongTensor index, FloatTensor src) {
        TH.THFloatTensor_scatterAdd(this, dim, index, src);
    }

    public void scatterFill(int dim, LongTensor index, float value) {
        TH.THFloatTensor_scatterFill(this, dim, index, value);
    }

    public double dot(FloatTensor that) {
        return TH.THFloatTensor_dot(that, this);
    }

    public float minall() {
        return TH.THFloatTensor_minall(this);
    }

    public float maxall() {
        return TH.THFloatTensor_maxall(this);
    }

    public float medianall() {
        return TH.THFloatTensor_medianall(this);
    }

    public double sumall() {
        return TH.THFloatTensor_sumall(this);
    }

    public double prodall() {
        return TH.THFloatTensor_prodall(this);
    }

    public FloatTensor neg() {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_neg(r, this);
        return r;
    }

    public FloatTensor cInv() {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_cinv(r, this);
        return r;
    }

    public FloatTensor add(float value) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_add(r, this, value);
        return r;
    }

    public FloatTensor sub(float value) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_sub(r, this, value);
        return r;
    }

    public FloatTensor addScaled(float value, float alpha) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_add_scaled(r, this, value, alpha);
        return r;
    }

    public FloatTensor sub_scaled(float value, float alpha) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_sub_scaled(r, this, value, alpha);
        return r;
    }

    public FloatTensor mul(float value) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_mul(r, this, value);
        return r;
    }

    public FloatTensor div(float value) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_div(r, this, value);
        return r;
    }

    public FloatTensor lshift(float value) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_lshift(r, this, value);
        return r;
    }

    public FloatTensor rshift(float value) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_rshift(r, this, value);
        return r;
    }

    public FloatTensor fmod(float value) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_fmod(r, this, value);
        return r;
    }

    public FloatTensor remainder(float value) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_remainder(r, this, value);
        return r;
    }

    public FloatTensor clamp(float minValue, float maxValue) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_clamp(r, this, minValue, maxValue);
        return r;
    }

    public FloatTensor bitand(float value) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_bitand(r, this, value);
        return r;
    }

    public FloatTensor bitor(float value) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_bitor(r, this, value);
        return r;
    }

    public FloatTensor bitxor(float value) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_bitxor(r, this, value);
        return r;
    }

    public FloatTensor cadd(float a, FloatTensor y) {
        FloatTensor z = new FloatTensor();
        TH.THFloatTensor_cadd(z, this, a, y);
        return z;
    }

    public FloatTensor csub(float a, FloatTensor y) {
        FloatTensor z = new FloatTensor();
        TH.THFloatTensor_csub(z, this, a, y);
        return z;
    }

    public FloatTensor cmul(FloatTensor y) {
        FloatTensor z = new FloatTensor();
        TH.THFloatTensor_cmul(z, this, y);
        return z;
    }

    public FloatTensor cpow(FloatTensor y) {
        FloatTensor z = new FloatTensor();
        TH.THFloatTensor_cpow(z, this, y);
        return z;
    }

    public FloatTensor cdiv(FloatTensor y) {
        FloatTensor z = new FloatTensor();
        TH.THFloatTensor_cdiv(z, this, y);
        return z;
    }

    public FloatTensor clshift(FloatTensor y) {
        FloatTensor z = new FloatTensor();
        TH.THFloatTensor_clshift(z, this, y);
        return z;
    }

    public FloatTensor crshift(FloatTensor y) {
        FloatTensor z = new FloatTensor();
        TH.THFloatTensor_crshift(z, this, y);
        return z;
    }

    public FloatTensor cfmod(FloatTensor y) {
        FloatTensor z = new FloatTensor();
        TH.THFloatTensor_cfmod(z, this, y);
        return z;
    }

    public FloatTensor cremainder(FloatTensor y) {
        FloatTensor z = new FloatTensor();
        TH.THFloatTensor_cremainder(z, this, y);
        return z;
    }

    public FloatTensor cbitand(FloatTensor y) {
        FloatTensor z = new FloatTensor();
        TH.THFloatTensor_cbitand(z, this, y);
        return z;
    }

    public FloatTensor cbitor(FloatTensor y) {
        FloatTensor z = new FloatTensor();
        TH.THFloatTensor_cbitor(z, this, y);
        return z;
    }

    public FloatTensor cbitxor(FloatTensor y) {
        FloatTensor z = new FloatTensor();
        TH.THFloatTensor_cbitxor(z, this, y);
        return z;
    }

    /**
     * Computes t + a(s1 * s2), where s1 and s2 are element-wise-multiplied.
     */
    public static FloatTensor addcmul(FloatTensor t, float a, FloatTensor s1, FloatTensor s2) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_addcmul(r, t, a, s1, s2);
        return r;
    }

    /**
     * Computes t + a(s1 / s2), where s1 and s2 are element-wise-divided.
     */
    public static FloatTensor addcdiv(FloatTensor t, float a, FloatTensor y, FloatTensor z) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_addcdiv(r, t, a, y, z);
        return r;
    }

    /** Computes b * t + a * (mat * vec). */
    public static FloatTensor addmv(float b, FloatTensor t, float a, FloatTensor mat, FloatTensor vec) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_addmv(r, b, t, a, mat, vec);
        return r;
    }

    /** Computes b * t + a * (mat1 * mat2). */
    public static FloatTensor addmm(float b, FloatTensor t, float a, FloatTensor mat1, FloatTensor mat2) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_addmm(r, b, t, a, mat1, mat2);
        return r;
    }

    /** Computes b * t + a * (vec1 * vec2^T), where vec1 and vec2 are multiplied to yield the outer product. */
    public static FloatTensor addr(float b, FloatTensor t, float a, FloatTensor vec1, FloatTensor vec2) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_addr(r, b, t, a, vec1, vec2);
        return r;
    }

    /** Computes b * mat + a * ReduceSumOverBatches(bmat1 * bmat2). */
    public static FloatTensor addbmm(float b, FloatTensor mat, float a, FloatTensor bmat1, FloatTensor bmat2) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_addbmm(r, b, mat, a, bmat1, bmat2);
        return r;
    }

    /**
     * Computes b * t + a * bmm(bmat1, bmat2).
     * @param t [b, n, p]
     * @param bmat1 [b, m, n]
     * @param bmat2 [b, n, p]
     * @return [b, n, p]
     */
    public static FloatTensor baddbmm(float b, FloatTensor t, float a, FloatTensor bmat1, FloatTensor bmat2) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_baddbmm(r, b, t, a, bmat1, bmat2);
        return r;
    }

    // TODO: what does this do?
    public FloatTensor match(FloatTensor that, float gain) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_match(r, this, that, gain);
        return r;
    }

    public long numel() {
        return TH.THFloatTensor_numel(this);
    }

    public ArgOpResult<FloatTensor, LongTensor> max(int dim, boolean keepDim) {
        FloatTensor v = new FloatTensor();
        LongTensor i = new LongTensor();
        TH.THFloatTensor_max(v, i, this, dim, keepDim ? 1 : 0);
        return new ArgOpResult(v, i);
    }

    public ArgOpResult<FloatTensor, LongTensor> min(int dim, boolean keepDim) {
        FloatTensor v = new FloatTensor();
        LongTensor i = new LongTensor();
        TH.THFloatTensor_min(v, i, this, dim, keepDim ? 1 : 0);
        return new ArgOpResult(v, i);
    }

    public ArgOpResult<FloatTensor, LongTensor> kthvalue(long k, int dim, boolean keepDim) {
        FloatTensor v = new FloatTensor();
        LongTensor i = new LongTensor();
        TH.THFloatTensor_kthvalue(v, i, this, k, dim, keepDim ? 1 : 0);
        return new ArgOpResult(v, i);
    }

    public ArgOpResult<FloatTensor, LongTensor> mode(int dim, boolean keepDim) {
        FloatTensor v = new FloatTensor();
        LongTensor i = new LongTensor();
        TH.THFloatTensor_mode(v, i, this, dim, keepDim ? 1 : 0);
        return new ArgOpResult(v, i);
    }

    public ArgOpResult<FloatTensor, LongTensor> median(int dim, boolean keepDim) {
        FloatTensor v = new FloatTensor();
        LongTensor i = new LongTensor();
        TH.THFloatTensor_median(v, i, this, dim, keepDim ? 1 : 0);
        return new ArgOpResult(v, i);
    }

    public FloatTensor sum(int dim, boolean keepDim) {
        FloatTensor v = new FloatTensor();
        TH.THFloatTensor_sum(v, this, dim, keepDim ? 1 : 0);
        return v;
    }

    public FloatTensor prod(int dim, boolean keepDim) {
        FloatTensor v = new FloatTensor();
        TH.THFloatTensor_prod(v, this, dim, keepDim ? 1 : 0);
        return v;
    }

    public FloatTensor cumsum(int dim) {
        FloatTensor v = new FloatTensor();
        TH.THFloatTensor_cumsum(v, this, dim);
        return v;
    }

    public FloatTensor cumprod(int dim) {
        FloatTensor v = new FloatTensor();
        TH.THFloatTensor_cumprod(v, this, dim);
        return v;
    }

    public FloatTensor sign() {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_sign(r, this);
        return r;
    }

    public double trace() {
        return TH.THFloatTensor_trace(this);
    }

    public FloatTensor cross(FloatTensor b, int dim) {
        FloatTensor c = new FloatTensor();
        TH.THFloatTensor_cross(c, this, b, dim);
        return c;
    }

    public FloatTensor cmax(FloatTensor b) {
        FloatTensor c = new FloatTensor();
        TH.THFloatTensor_cmax(c, this, b);
        return c;
    }

    public FloatTensor cmin(FloatTensor b) {
        FloatTensor c = new FloatTensor();
        TH.THFloatTensor_cmin(c, this, b);
        return c;
    }

    public FloatTensor cmaxValue(float value) {
        FloatTensor c = new FloatTensor();
        TH.THFloatTensor_cmaxValue(c, this, value);
        return c;
    }

    public FloatTensor cminValue(float value) {
        FloatTensor c = new FloatTensor();
        TH.THFloatTensor_cminValue(c, this, value);
        return c;
    }

    public static FloatTensor zeros(LongStorage size) {
        FloatTensor z = new FloatTensor();
        TH.THFloatTensor_zeros(z, size);
        return z;
    }

    public static FloatTensor zeros(long... size) {
        return zeros(LongStorage.fromJava(size));
    }

    public static FloatTensor zerosLike(FloatTensor x) {
        FloatTensor z = new FloatTensor();
        TH.THFloatTensor_zerosLike(z, x);
        return z;
    }

    public static FloatTensor ones(LongStorage size) {
        FloatTensor z = new FloatTensor();
        TH.THFloatTensor_ones(z, size);
        return z;
    }

    public static FloatTensor ones(long... size) {
        return ones(LongStorage.fromJava(size));
    }

    public static FloatTensor onesLike(FloatTensor x) {
        FloatTensor z = new FloatTensor();
        TH.THFloatTensor_onesLike(z, x);
        return z;
    }

    public FloatTensor diag(int k) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_diag(r, this, k);
        return r;
    }

    public static FloatTensor eye(long n, long m) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_eye(r, n, m);
        return r;
    }

    public static FloatTensor arange(double xmin, double xmax, double step) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_arange(r, xmin, xmax, step);
        return r;
    }

    public static FloatTensor range(double xmin, double xmax, double step) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_range(r, xmin, xmax, step);
        return r;
    }

    public static FloatTensor randperm(Generator generator, long n) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_randperm(r, generator, n);
        return r;
    }

    public FloatTensor reshape(LongStorage size) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_reshape(r, this, size);
        return r;
    }

    public FloatTensor reshape(long... size) {
        return reshape(LongStorage.fromJava(size));
    }

    public ArgOpResult<FloatTensor, LongTensor> sort(int dim, boolean descending) {
        FloatTensor rt = new FloatTensor();
        LongTensor ri = new LongTensor();
        TH.THFloatTensor_sort(rt, ri, this, dim, descending ? 1 : 0);
        return new ArgOpResult(rt, ri);
    }

    public ArgOpResult<FloatTensor, LongTensor> topk(long k, int dim, boolean largest, boolean sorted) {
        FloatTensor rt = new FloatTensor();
        LongTensor ri = new LongTensor();
        TH.THFloatTensor_topk(rt, ri, this, k, dim, largest ? 1 : 0, sorted ? 1 : 0);
        return new ArgOpResult(rt, ri);
    }

    public FloatTensor tril(long k) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_tril(r, this, k);
        return r;
    }

    public FloatTensor triu(long k) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_triu(r, this, k);
        return r;
    }

    public FloatTensor cat(FloatTensor that, int dim) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_cat(r, this, that, dim);
        return r;
    }

    public static FloatTensor catArray(FloatTensor[] inputs, int dim) {
        FloatTensor r = new FloatTensor();
        SWIGTYPE_p_p_THFloatTensor xs = TH.new_CFloatTensorArray(inputs.length);
        for (int i = 0; i < inputs.length; i++)
            TH.CFloatTensorArray_setitem(xs, i, inputs[i]);
        TH.THFloatTensor_catArray(r, xs, inputs.length, dim);
        return r;
    }

    public boolean equal(FloatTensor that) {
        return TH.THFloatTensor_equal(this, that) != 0;
    }

    public boolean equals(Object that) {
        return (that instanceof THFloatTensor) && equal((FloatTensor) that);
    }

    public UByteTensor ltValue(float value) {
        UByteTensor r = new UByteTensor();
        TH.THFloatTensor_ltValue(r, this, value);
        return r;
    }

    public UByteTensor leValue(float value) {
        UByteTensor r = new UByteTensor();
        TH.THFloatTensor_leValue(r, this, value);
        return r;
    }

    public UByteTensor gtValue(float value) {
        UByteTensor r = new UByteTensor();
        TH.THFloatTensor_gtValue(r, this, value);
        return r;
    }

    public UByteTensor geValue(float value) {
        UByteTensor r = new UByteTensor();
        TH.THFloatTensor_geValue(r, this, value);
        return r;
    }

    public UByteTensor neValue(float value) {
        UByteTensor r = new UByteTensor();
        TH.THFloatTensor_eqValue(r, this, value);
        return r;
    }

    public UByteTensor eqValue(float value) {
        UByteTensor r = new UByteTensor();
        TH.THFloatTensor_eqValue(r, this, value);
        return r;
    }


    public UByteTensor ltTensor(FloatTensor that) {
        UByteTensor r = new UByteTensor();
        TH.THFloatTensor_ltTensor(r, this, that);
        return r;
    }

    public UByteTensor leTensor(FloatTensor that) {
        UByteTensor r = new UByteTensor();
        TH.THFloatTensor_leTensor(r, this, that);
        return r;
    }

    public UByteTensor gtTensor(FloatTensor that) {
        UByteTensor r = new UByteTensor();
        TH.THFloatTensor_gtTensor(r, this, that);
        return r;
    }

    public UByteTensor geTensor(FloatTensor that) {
        UByteTensor r = new UByteTensor();
        TH.THFloatTensor_geTensor(r, this, that);
        return r;
    }

    public UByteTensor neTensor(FloatTensor that) {
        UByteTensor r = new UByteTensor();
        TH.THFloatTensor_eqTensor(r, this, that);
        return r;
    }

    public UByteTensor eqTensor(FloatTensor that) {
        UByteTensor r = new UByteTensor();
        TH.THFloatTensor_eqTensor(r, this, that);
        return r;
    }

    // (lt/le/gt/ge/ne/eq)(Value/Tensor)(/T)

    public FloatTensor pow(float value) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_pow(r, this, value);
        return r;
    }

    public static FloatTensor tpow(float value, FloatTensor t) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_tpow(r, value, t);
        return r;
    }
    public FloatTensor sigmoid() {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_sigmoid(r, this);
        return r;
    }

    public FloatTensor log() {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_log(r, this);
        return r;
    }

    public FloatTensor lgamma() {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_lgamma(r, this);
        return r;
    }

    public FloatTensor digamma() {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_digamma(r, this);
        return r;
    }

    public FloatTensor trigamma() {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_trigamma(r, this);
        return r;
    }

    public FloatTensor polygamma(long n) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_polygamma(r, n, this);
        return r;
    }

    public FloatTensor log10() {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_log10(r, this);
        return r;
    }

    public FloatTensor log1p() {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_log1p(r, this);
        return r;
    }

    public FloatTensor log2() {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_log2(r, this);
        return r;
    }

    public FloatTensor exp() {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_exp(r, this);
        return r;
    }

    public FloatTensor expm1() {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_expm1(r, this);
        return r;
    }

    public FloatTensor cos() {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_cos(r, this);
        return r;
    }

    public FloatTensor acos() {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_acos(r, this);
        return r;
    }

    public FloatTensor cosh() {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_cosh(r, this);
        return r;
    }

    public FloatTensor sin() {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_sin(r, this);
        return r;
    }

    public FloatTensor asin() {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_asin(r, this);
        return r;
    }

    public FloatTensor sinh() {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_sinh(r, this);
        return r;
    }

    public FloatTensor tan() {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_tan(r, this);
        return r;
    }

    public FloatTensor atan() {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_atan(r, this);
        return r;
    }

    public static FloatTensor atan2(FloatTensor x, FloatTensor y) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_atan2(r, x, y);
        return r;
    }

    public FloatTensor tanh() {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_tanh(r, this);
        return r;
    }
    public FloatTensor erf() {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_erf(r, this);
        return r;
    }
    public FloatTensor erfinv() {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_erfinv(r, this);
        return r;
    }
    public FloatTensor sqrt() {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_sqrt(r, this);
        return r;
    }
    public FloatTensor rsqrt() {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_rsqrt(r, this);
        return r;
    }
    public FloatTensor ceil() {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_ceil(r, this);
        return r;
    }
    public FloatTensor floor() {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_floor(r, this);
        return r;
    }
    public FloatTensor round() {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_round(r, this);
        return r;
    }
    public FloatTensor abs() {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_abs(r, this);
        return r;
    }
    public FloatTensor trunc() {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_trunc(r, this);
        return r;
    }
    public FloatTensor frac() {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_frac(r, this);
        return r;
    }
    public static FloatTensor lerp(FloatTensor x, FloatTensor y, float w) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_lerp(r, x, y, w);
        return r;
    }

    public FloatTensor mean(int dim, boolean keepdim) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_mean(r, this, dim, keepdim ? 1 : 0);
        return r;
    }
    public FloatTensor std(int dim, boolean biased, boolean keepdim) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_std(r, this, dim, biased ? 1 : 0, keepdim ? 1 : 0);
        return r;
    }

    public FloatTensor var(int dim, boolean biased, boolean keepdim) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_var(r, this, dim, biased ? 1 : 0, keepdim ? 1 : 0);
        return r;
    }

    public FloatTensor norm(float value, int dim, boolean keepdim) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_norm(r, this, value, dim, keepdim ? 1 : 0);
        return r;
    }
    public FloatTensor renorm(float value, int dim, float maxnorm) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_renorm(r, this, value, dim, maxnorm);
        return r;
    }
    public double dist(FloatTensor that, float value) {
        return TH.THFloatTensor_dist(this, that, value);
    }

    // histc
    // bhistc

    public double meanall() {
        return TH.THFloatTensor_meanall(this);
    }

    public double varall(boolean biased) {
        return TH.THFloatTensor_varall(this, biased ? 1 : 0);
    }
    public double stdall(boolean biased) {
        return TH.THFloatTensor_stdall(this, biased ? 1 : 0);
    }
    public double normall(float value) {
        return TH.THFloatTensor_normall(this, value);
    }

    public static FloatTensor linspace(float a, float b, long n) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_linspace(r, a, b, n);
        return r;
    }

    public static FloatTensor logspace(float a, float b, long n) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_logspace(r, a, b, n);
        return r;
    }

    public static FloatTensor rand(Generator generator, LongStorage size) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_rand(r, generator, size);
        return r;
    }

    public static FloatTensor randn(Generator generator, LongStorage size) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_randn(r, generator, size);
        return r;
    }

    // dirichlet_Grad
    // RANDOM


    // CONV

    public void close() {
        free();
    }

    public String toString() {
        return desc().getStr();
    }
}

