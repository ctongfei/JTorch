package jtorch;

import jtorch.jni.*;

/**
 * Proxy object that wraps around the THTensor C type.
 * @author Tongfei Chen
 */
public class FloatTensor extends THFloatTensor implements Cloneable, WithFlag {

    /** Creates an empty tensor. */
    public FloatTensor() {
        this(TH.THFloatTensor_new());
    }

    protected FloatTensor(THFloatTensor underlying) {
        super(THFloatTensor.getCPtr(underlying), true);
    }

    protected long cPtr() {
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

    /** Creates a  */
    public static FloatTensor newWithTensor(FloatTensor tensor) {
        return new FloatTensor(
                TH.THFloatTensor_newWithTensor(tensor)
        );
    }

    public static FloatTensor newWithStorage(FloatStorage storage, int storageOffset, LongStorage size, LongStorage stride) {
        return new FloatTensor(
                TH.THFloatTensor_newWithStorage(storage, storageOffset, size, stride)
        );
    }

    public static FloatTensor newWithStorage1d(FloatStorage storage, int storageOffset, long size0, long stride0) {
        return new FloatTensor(
                TH.THFloatTensor_newWithStorage(storage, storageOffset, size0, stride0)
        );
    }

    public static FloatTensor newWithStorage2d(
            FloatStorage storage, int storageOffset,
            long size0, long stride0,
            long size1, long stride1) {
        return new FloatTensor(
                TH.THFloatTensor_newWithStorage2d(storage, storageOffset,
                        size0, stride0, size1, stride1)
        );
    }

    public static FloatTensor newWithStorage3d(
            FloatStorage storage, int storageOffset,
            long size0, long stride0,
            long size1, long stride1,
            long size2, long stride2) {
        return new FloatTensor(
                TH.THFloatTensor_newWithStorage3d(storage, storageOffset,
                        size0, stride0, size1, stride1, size2, stride2)
        );
    }

    public static FloatTensor newWithStorage4d(
            FloatStorage storage, int storageOffset,
            long size0, long stride0,
            long size1, long stride1,
            long size2, long stride2,
            long size3, long stride3) {
        return new FloatTensor(
                TH.THFloatTensor_newWithStorage4d(storage, storageOffset,
                        size0, stride0, size1, stride1, size2, stride2, size3, stride3)
        );
    }

    public static FloatTensor newWithSize(LongStorage size, LongStorage stride) {
        return new FloatTensor(
                TH.THFloatTensor_newWithSize(size, stride)
        );
    }

    public static FloatTensor newWithSize1d(long size0) {
        return new FloatTensor(
                TH.THFloatTensor_newWithSize1d(size0)
        );
    }

    public static FloatTensor newWithSize2d(long size0, long size1) {
        return new FloatTensor(
                TH.THFloatTensor_newWithSize2d(size0, size1)
        );
    }

    public static FloatTensor newWithSize3d(long size0, long size1, long size2) {
        return new FloatTensor(
                TH.THFloatTensor_newWithSize3d(size0, size1, size2)
        );
    }

    public static FloatTensor newWithSize4d(long size0, long size1, long size2, long size3) {
        return new FloatTensor(
                TH.THFloatTensor_newWithSize4d(size0, size1, size2, size3)
        );
    }

    public static FloatTensor newClone(FloatTensor self) {
        return new FloatTensor(
                TH.THFloatTensor_newClone(self)
        );
    }

    @Override
    public FloatTensor clone() {
        return FloatTensor.newClone(this);
    }

    public static FloatTensor newContiguous(FloatTensor self) {
        return new FloatTensor(
                TH.THFloatTensor_newContiguous(self)
        );
    }

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

    public void setStorage(FloatStorage storage, int storageOffset, LongStorage size, LongStorage stride) {
        TH.THFloatTensor_setStorage(this, storage, storageOffset, size, stride);
    }

    public void setStorage1d(FloatStorage storage, int storageOffset, long size0, long stride0) {
        TH.THFloatTensor_setStorage1d(this, storage, storageOffset, size0, stride0);
    }

    public void setStorage2d(FloatStorage storage, int storageOffset,
                             long size0, long stride0,
                             long size1, long stride1
                             ) {
        TH.THFloatTensor_setStorage2d(this, storage, storageOffset,
                size0, stride0,
                size1, stride1
        );
    }

    public void setStorage3d(FloatStorage storage, int storageOffset,
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

    public void setStorage4d(FloatStorage storage, int storageOffset,
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

    public int nElement() {
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

    public void copyHalf(HalfTensor src) {
        TH.THFloatTensor_copyHalf(this, src);
    }

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

    public FloatTensor indexAdd(int dim, LongTensor index, FloatTensor src) {
        TH.THFloatTensor_indexAdd(this, dim, index, src);
    }

    public FloatTensor indexFill(int dim, LongTensor index, float value) {
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

    public AccReal dot(FloatTensor that) {
        return TH.THFloatTensor_dot(that, this);
    }

    public float minAll() {
        return TH.THFloatTensor_minall(this);
    }

    public float maxAll() {
        return TH.THFloatTensor_maxall(this);
    }

    public float medianAll() {
        return TH.THFloatTensor_medianall(this);
    }

    public AccReal sumAll() {
        return TH.THFloatTensor_sumall(this);
    }

    public AccReal prodAll() {
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

    public FloatTensor bitAnd(float value) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_bitand(r, this, value);
        return r;
    }

    public FloatTensor bitOr(float value) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_bitor(r, this, value);
        return r;
    }

    public FloatTensor bitXor(float value) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_bitxor(r, this, value);
        return r;
    }

    public FloatTensor cAdd(float a, FloatTensor y) {
        FloatTensor z = new FloatTensor();
        TH.THFloatTensor_cadd(z, this, a, y);
        return z;
    }

    public FloatTensor cSub(float a, FloatTensor y) {
        FloatTensor z = new FloatTensor();
        TH.THFloatTensor_csub(z, this, a, y);
        return z;
    }

    public FloatTensor cMul(FloatTensor y) {
        FloatTensor z = new FloatTensor();
        TH.THFloatTensor_cmul(z, this, y);
        return z;
    }

    public FloatTensor cPow(FloatTensor y) {
        FloatTensor z = new FloatTensor();
        TH.THFloatTensor_cpow(z, this, y);
        return z;
    }

    public FloatTensor cDiv(FloatTensor y) {
        FloatTensor z = new FloatTensor();
        TH.THFloatTensor_cdiv(z, this, y);
        return z;
    }

    public FloatTensor cLshift(FloatTensor y) {
        FloatTensor z = new FloatTensor();
        TH.THFloatTensor_clshift(z, this, y);
        return z;
    }

    public FloatTensor cRshift(FloatTensor y) {
        FloatTensor z = new FloatTensor();
        TH.THFloatTensor_crshift(z, this, y);
        return z;
    }

    public FloatTensor cFmod(FloatTensor y) {
        FloatTensor z = new FloatTensor();
        TH.THFloatTensor_cfmod(z, this, y);
        return z;
    }

    public FloatTensor cRemainder(FloatTensor y) {
        FloatTensor z = new FloatTensor();
        TH.THFloatTensor_cremainder(z, this, y);
        return z;
    }

    public FloatTensor cBitAnd(FloatTensor y) {
        FloatTensor z = new FloatTensor();
        TH.THFloatTensor_cbitand(z, this, y);
        return z;
    }

    public FloatTensor cBitOr(FloatTensor y) {
        FloatTensor z = new FloatTensor();
        TH.THFloatTensor_cbitor(z, this, y);
        return z;
    }

    public FloatTensor cBitXor(FloatTensor y) {
        FloatTensor z = new FloatTensor();
        TH.THFloatTensor_cbitxor(z, this, y);
        return z;
    }

    public FloatTensor addCMul(float a, FloatTensor y, FloatTensor z) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_addcmul(r, this, a, y, z);
        return r;
    }

    public FloatTensor addCDiv(float a, FloatTensor y, FloatTensor z) {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_addcdiv(r, this, a, y, z);
        return r;
    }

    // addMV
    // addMM
    // addR
    // addBMM
    // bAddBMM
    // match

    public long numel() {
        return TH.THFloatTensor_numel(this);
    }

    // preserveReduceDimSemantics

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

    public ArgOpResult<FloatTensor, LongTensor> kthValue(long k, int dim, boolean keepDim) {
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

    public FloatTensor cumSum(int dim) {
        FloatTensor v = new FloatTensor();
        TH.THFloatTensor_cumsum(v, this, dim);
        return v;
    }

    public FloatTensor cumProd(int dim) {
        FloatTensor v = new FloatTensor();
        TH.THFloatTensor_cumprod(v, this, dim);
        return v;
    }

    public FloatTensor sign() {
        FloatTensor r = new FloatTensor();
        TH.THFloatTensor_sign(r, this);
        return r;
    }

    public AccReal trace() {
        return TH.THFloatTensor_trace(this);
    }

    public FloatTensor cross(FloatTensor b, int dim) {
        FloatTensor c = new FloatTensor();
        TH.THFloatTensor_cross(c, this, b, dim);
        return c;
    }

    public FloatTensor cMax(FloatTensor b) {
        FloatTensor c = new FloatTensor();
        TH.THFloatTensor_cmax(c, this, b);
        return c;
    }

    public FloatTensor cMin(FloatTensor b) {
        FloatTensor c = new FloatTensor();
        TH.THFloatTensor_cmin(c, this, b);
        return c;
    }

    public FloatTensor cMaxValue(float value) {
        FloatTensor c = new FloatTensor();
        TH.THFloatTensor_cmaxValue(c, this, value);
        return c;
    }

    public FloatTensor cMinValue(float value) {
        FloatTensor c = new FloatTensor();
        TH.THFloatTensor_cminValue(c, this, value);
        return c;
    }

    public static FloatTensor zeros(LongStorage size) {
        FloatTensor z = new FloatTensor();
        TH.THFloatTensor_zeros(z, size);
        return z;
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

    // aRange
    // range
    // randperm
    // reshape
    // sort
    // topk
    // tril
    // triu
    // cat
    // catArray
    // equal
    // (lt/le/gt/ge/ne/eq)(Value/Tensor)(/T)
    // pow
    // tpow

    // abs

    // sigmoid/log/lgamma/digamma/trigamma/polygamma/log10/log1p/log2
    // exp/expm1/cos/acos/cosh/sin/asin/sinh/tan/atan/atan2/tanh
    // erf/erfinv/sqrt/rsqrt/ceil/floor/round/abs/trunc/frac/lerp
    // mean/std/var/norm/renorm/dist/histc/bhistc
    // meanall/varall/stdall/normall/linspace/logspace/rand/randn
    // dirichlet_grad
    // logicalall/logicalany


    // RANDOM


    // CONV


    public String toString() {
        return desc().getStr();
    }
}
