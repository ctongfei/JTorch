package jtorch;

import jtorch.jni.*;

/**
 * Proxy object that wraps around the TH*Tensor C type.
 * @author Tongfei Chen
 */
public class JTensor extends THTensor implements Cloneable, WithFlag, OffHeapMemory {

    /** Creates an empty tensor. */
    public JTensor() {
        this(TH.THTensor_(new)());
    }

    protected JTensor(THTensor underlying) {
        super(THTensor.getCPtr(underlying), true);
    }

    protected long cPtr() {
        return THTensor.getCPtr(this);
    }

    /** Returns the underlying storage object. */
    public JStorage storage() {
        return new JStorage(TH.THTensor_(storage)(this));
    }

    /** Returns the storage offset of this tensor. */
    public long storageOffset() {
        return TH.THTensor_(storageOffset)(this);
    }

    /** Returns the number of dimensions (a.k.a. rank) of this tensor. */
    public int nDimension() {
        return TH.THTensor_(nDimension)(this);
    }

    /** Returns the size of the given dimension. */
    public long size(int dim) {
        return TH.THTensor_(size)(this, dim);
    }

    /** Returns the stride of the given dimension. */
    public long stride(int dim) {
        return TH.THTensor_(stride)(this, dim);
    }

    /** Returns a new storage object that contains the sizes of the dimensions in this tensor. */
    public LongStorage newSizeOf() {
        return new LongStorage(
                TH.THTensor_(newSizeOf)(this)
        );
    }

    /** Returns a new storage object that contains the strides of the dimensions in this tensor. */
    public LongStorage newStrideOf() {
        return new LongStorage(
                TH.THTensor_(newStrideOf)(this)
        );
    }

    /** Returns a SWIG wrapper-wrapped raw pointer of the underlying storage. */
    public CArray data() {
        return CArray.frompointer(TH.THTensor_(data)(this));
    }

    public void setFlag(char flag) {
        TH.THTensor_(setFlag)(this, flag);
    }

    public void clearFlag(char flag) {
        TH.THTensor_(clearFlag)(this, flag);
    }

    /** Creates a shallow copy (pointer copy) of the given tensor. */
    public static JTensor newWithTensor(JTensor tensor) {
        return new JTensor(
                TH.THTensor_(newWithTensor)(tensor)
        );
    }

    /** Creates a new tensor from the given storage, offset, sizes and strides. */
    public static JTensor newWithStorage(JStorage storage, long storageOffset, LongStorage size, LongStorage stride) {
        return new JTensor(
                TH.THTensor_(newWithStorage)(storage, storageOffset, size, stride)
        );
    }

    /** Creates a 1-D tensor with the given size and stride from the given storage. */
    public static JTensor newWithStorage1d(JStorage storage, long storageOffset, long size0, long stride0) {
        return new JTensor(
                TH.THTensor_(newWithStorage1d)(storage, storageOffset, size0, stride0)
        );
    }

    /** Creates a 2-D tensor with the given sizes and strides from the given storage. */
    public static JTensor newWithStorage2d(
            JStorage storage, long storageOffset,
            long size0, long stride0,
            long size1, long stride1) {
        return new JTensor(
                TH.THTensor_(newWithStorage2d)(storage, storageOffset,
                        size0, stride0, size1, stride1)
        );
    }

    /** Creates a 3-D tensor with the given sizes and strides from the given storage. */
    public static JTensor newWithStorage3d(
            JStorage storage, long storageOffset,
            long size0, long stride0,
            long size1, long stride1,
            long size2, long stride2) {
        return new JTensor(
                TH.THTensor_(newWithStorage3d)(storage, storageOffset,
                        size0, stride0, size1, stride1, size2, stride2)
        );
    }

    /** Creates a 4-D tensor with the given sizes and strides from the given storage. */
    public static JTensor newWithStorage4d(
            JStorage storage, long storageOffset,
            long size0, long stride0,
            long size1, long stride1,
            long size2, long stride2,
            long size3, long stride3) {
        return new JTensor(
                TH.THTensor_(newWithStorage4d)(storage, storageOffset,
                        size0, stride0, size1, stride1, size2, stride2, size3, stride3)
        );
    }

    /** Creates a new tensor with the given size and stride array. */
    public static JTensor newWithSize(LongStorage size, LongStorage stride) {
        return new JTensor(
                TH.THTensor_(newWithSize)(size, stride)
        );
    }

    /** Creates a new 1-D tensor with the given size. */
    public static JTensor newWithSize1d(long size0) {
        return new JTensor(
                TH.THTensor_(newWithSize1d)(size0)
        );
    }

    /** Creates a new 2-D tensor with the given sizes. */
    public static JTensor newWithSize2d(long size0, long size1) {
        return new JTensor(
                TH.THTensor_(newWithSize2d)(size0, size1)
        );
    }

    /** Creates a new 3-D tensor with the given sizes. */
    public static JTensor newWithSize3d(long size0, long size1, long size2) {
        return new JTensor(
                TH.THTensor_(newWithSize3d)(size0, size1, size2)
        );
    }

    /** Creates a new 4-D tensor with the given sizes. */
    public static JTensor newWithSize4d(long size0, long size1, long size2, long size3) {
        return new JTensor(
                TH.THTensor_(newWithSize4d)(size0, size1, size2, size3)
        );
    }

    /** Creates a new tensor that is a clone of the given tensor. */
    public static JTensor newClone(JTensor self) {
        return new JTensor(
                TH.THTensor_(newClone)(self)
        );
    }

    @Override
    public JTensor clone() {
        return JTensor.newClone(this);
    }

    /** Creates a memory-contiguous tensor copy of the given tensor. */
    public static JTensor newContiguous(JTensor self) {
        return new JTensor(
                TH.THTensor_(newContiguous)(self)
        );
    }

    /** Returns a memory-contiguous copy of this tensor. */
    public JTensor contiguous() {
        return newContiguous(this);
    }

    public static JTensor newSelect(JTensor self, int dimension, long sliceIndex) {
        return new JTensor(
                TH.THTensor_(newSelect)(self, dimension, sliceIndex)
        );
    }

    public static JTensor newNarrow(JTensor self, int dimension, long firstIndex, long size) {
        return new JTensor(
                TH.THTensor_(newNarrow)(self, dimension, firstIndex, size)
        );
    }

    public static JTensor newTranspose(JTensor self, int dimension1, int dimension2) {
        return new JTensor(
                TH.THTensor_(newTranspose)(self, dimension1, dimension2)
        );
    }

    public static JTensor newUnfold(JTensor self, int dimension, long size, long step) {
        return new JTensor(
                TH.THTensor_(newUnfold)(self, dimension, size, step)
        );
    }

    public static JTensor newView(JTensor tensor, LongStorage size) {
        return new JTensor(
                TH.THTensor_(newView)(tensor, size)
        );
    }

    public void resize(LongStorage size, LongStorage stride) {
        TH.THTensor_(resize)(this, size, stride);
    }

    public void resizeAs(JTensor src) {
        TH.THTensor_(resizeAs)(this, src);
    }

    public void resize1d(long size0) {
        TH.THTensor_(resize1d)(this, size0);
    }

    public void resize2d(long size0, long size1) {
        TH.THTensor_(resize2d)(this, size0, size1);
    }

    public void resize3d(long size0, long size1, long size2) {
        TH.THTensor_(resize3d)(this, size0, size1, size2);
    }

    public void resize4d(long size0, long size1, long size2, long size3) {
        TH.THTensor_(resize4d)(this, size0, size1, size2, size3);
    }

    public void resize5d(long size0, long size1, long size2, long size3, long size4) {
        TH.THTensor_(resize5d)(this, size0, size1, size2, size3, size4);
    }

    public void set(JTensor src) {
        TH.THTensor_(set)(this, src);
    }

    public void setStorage(JStorage storage, long storageOffset, LongStorage size, LongStorage stride) {
        TH.THTensor_(setStorage)(this, storage, storageOffset, size, stride);
    }

    public void setStorage1d(JStorage storage, long storageOffset, long size0, long stride0) {
        TH.THTensor_(setStorage1d)(this, storage, storageOffset, size0, stride0);
    }

    public void setStorage2d(JStorage storage, long storageOffset,
                             long size0, long stride0,
                             long size1, long stride1
    ) {
        TH.THTensor_(setStorage2d)(this, storage, storageOffset,
                size0, stride0,
                size1, stride1
        );
    }

    public void setStorage3d(JStorage storage, long storageOffset,
                             long size0, long stride0,
                             long size1, long stride1,
                             long size2, long stride2
    ) {
        TH.THTensor_(setStorage3d)(this, storage, storageOffset,
                size0, stride0,
                size1, stride1,
                size2, stride2
        );
    }

    public void setStorage4d(JStorage storage, long storageOffset,
                             long size0, long stride0,
                             long size1, long stride1,
                             long size2, long stride2,
                             long size3, long stride3
    ) {
        TH.THTensor_(setStorage4d)(this, storage, storageOffset,
                size0, stride0,
                size1, stride1,
                size2, stride2,
                size3, stride3
        );
    }

    public JTensor narrow(int dimension, long firstIndex, long size) {
        JTensor r = new JTensor();
        TH.THTensor_(narrow)(r, this, dimension, firstIndex, size);
        return r;
    }

    public JTensor select(int dimension, long sliceIndex) {
        JTensor r = new JTensor();
        TH.THTensor_(select)(r, this, dimension, sliceIndex);
        return r;
    }

    public JTensor transpose(int dimension1, int dimension2) {
        JTensor r = new JTensor();
        TH.THTensor_(transpose)(r, this, dimension1, dimension2);
        return r;
    }

    public JTensor unfold(int dimension, long size, long step) {
        JTensor r = new JTensor();
        TH.THTensor_(unfold)(r, this, dimension, size, step);
        return r;
    }

    public JTensor squeeze() {
        JTensor r = new JTensor();
        TH.THTensor_(squeeze)(r, this);
        return r;
    }

    public JTensor squeeze1d(int dimension) {
        JTensor r = new JTensor();
        TH.THTensor_(squeeze1d)(r, this, dimension);
        return r;
    }

    public JTensor unsqueeze1d(int dimension) {
        JTensor r = new JTensor();
        TH.THTensor_(unsqueeze1d)(r, this, dimension);
        return r;
    }

    public boolean isContiguous() {
        return TH.THTensor_(isContiguous)(this) != 0;
    }

    public boolean isSameSizeAs(JTensor that) {
        return TH.THTensor_(isSameSizeAs)(this, that) != 0;
    }

    public boolean isSetTo(JTensor src) {
        return TH.THTensor_(isSetTo)(this, src) != 0;
    }

    public boolean isSize(LongStorage dims) {
        return TH.THTensor_(isSize)(this, dims) != 0;
    }

    public long nElement() {
        return TH.THTensor_(nElement)(this);
    }

    public void retain() {
        TH.THTensor_(retain)(this);
    }

    public void free() {
        TH.THTensor_(free)(this);
    }

    public void freeCopyTo(JTensor dst) {
        TH.THTensor_(freeCopyTo)(this, dst);
    }


    public void set1d(long x0, JType value) {
        TH.THTensor_(set1d)(this, x0, value);
    }

    public JType get1d(long x0) {
        return TH.THTensor_(get1d)(this, x0);
    }

    public void set2d(long x0, long x1, JType value) {
        TH.THTensor_(set2d)(this, x0, x1, value);
    }

    public JType get2d(long x0, long x1) {
        return TH.THTensor_(get2d)(this, x0, x1);
    }

    public void set3d(long x0, long x1, long x2, JType value) {
        TH.THTensor_(set3d)(this, x0, x1, x2, value);
    }

    public JType get3d(long x0, long x1, long x2) {
        return TH.THTensor_(get3d)(this, x0, x1, x2);
    }

    public void set4d(long x0, long x1, long x2, long x3, JType value) {
        TH.THTensor_(set4d)(this, x0, x1, x2, x3, value);
    }

    public JType get4d(long x0, long x1, long x2, long x3) {
        return TH.THTensor_(get4d)(this, x0, x1, x2, x3);
    }

    /** Returns a DescBuff object that describes this tensor. */
    public DescBuff desc() {
        return new DescBuff(
                TH.THTensor_(desc)(this)
        );
    }

    /** Returns a DescBuff object that describes the sizes of this tensor. */
    public DescBuff sizeDesc() {
        return new DescBuff(
                TH.THTensor_(sizeDesc)(this)
        );
    }

    // CONV

    // COPY
    public void copy(JTensor src) {
        TH.THTensor_(copy)(this, src);
    }

    public void copyUByte(UByteTensor src) {
        TH.THTensor_(copyByte)(this, src);
    }

    public void copyByte(ByteTensor src) {
        TH.THTensor_(copyChar)(this, src);
    }

    public void copyShort(ShortTensor src) {
        TH.THTensor_(copyShort)(this, src);
    }

    public void copyInt(IntTensor src) {
        TH.THTensor_(copyInt)(this, src);
    }

    public void copyLong(LongTensor src) {
        TH.THTensor_(copyLong)(this, src);
    }

    public void copyFloat(FloatTensor src) {
        TH.THTensor_(copyFloat)(this, src);
    }

    public void copyDouble(DoubleTensor src) {
        TH.THTensor_(copyDouble)(this, src);
    }

    // TODO: copyHalf

    // MATH
    public void fill(JType value) {
        TH.THTensor_(fill)(this, value);
    }

    public void zero() {
        TH.THTensor_(zero)(this);
    }

    public void maskedFill(UByteTensor mask, JType value) {
        TH.THTensor_(maskedFill)(this, mask, value);
    }

    public void maskedCopy(UByteTensor mask, JTensor src) {
        TH.THTensor_(maskedCopy)(this, mask, src);
    }

    public void maskedSelect(JTensor src, UByteTensor mask) {
        TH.THTensor_(maskedSelect)(this, src, mask);
    }

    public LongTensor nonzero() {
        LongTensor r = new LongTensor();
        TH.THTensor_(nonzero)(r, this);
        return r;
    }

    public JTensor indexSelect(int dim, LongTensor index) {
        JTensor r = new JTensor();
        TH.THTensor_(indexSelect)(r, this, dim, index);
        return r;
    }

    public JTensor indexCopy(int dim, LongTensor index) {
        JTensor r = new JTensor();
        TH.THTensor_(indexCopy)(r, dim, index, this);
        return r;
    }

    public void indexAdd(int dim, LongTensor index, JTensor src) {
        TH.THTensor_(indexAdd)(this, dim, index, src);
    }

    public void indexFill(int dim, LongTensor index, JType value) {
        TH.THTensor_(indexFill)(this, dim, index, value);
    }

    public JTensor take(LongTensor index) {
        JTensor r = new JTensor();
        TH.THTensor_(take)(r, this, index);
        return r;
    }

    public void put(LongTensor index, JTensor src, boolean accumulate) {
        TH.THTensor_(put)(this, index, src, accumulate ? 1 : 0);
    }

    public JTensor gather(int dim, LongTensor index) {
        JTensor r = new JTensor();
        TH.THTensor_(gather)(r, this, dim, index);
        return r;
    }

    public void scatter(int dim, LongTensor index, JTensor src) {
        TH.THTensor_(scatter)(this, dim, index, src);
    }

    public void scatterAdd(int dim, LongTensor index, JTensor src) {
        TH.THTensor_(scatterAdd)(this, dim, index, src);
    }

    public void scatterFill(int dim, LongTensor index, JType value) {
        TH.THTensor_(scatterFill)(this, dim, index, value);
    }

    public AccReal dot(JTensor that) {
        return TH.THTensor_(dot)(that, this);
    }

    public JType minall() {
        return TH.THTensor_(minall)(this);
    }

    public JType maxall() {
        return TH.THTensor_(maxall)(this);
    }

    public JType medianall() {
        return TH.THTensor_(medianall)(this);
    }

    public AccReal sumall() {
        return TH.THTensor_(sumall)(this);
    }

    public AccReal prodall() {
        return TH.THTensor_(prodall)(this);
    }

    public JTensor neg() {
        JTensor r = new JTensor();
        TH.THTensor_(neg)(r, this);
        return r;
    }

    public JTensor cInv() {
        JTensor r = new JTensor();
        TH.THTensor_(cinv)(r, this);
        return r;
    }

    public JTensor add(JType value) {
        JTensor r = new JTensor();
        TH.THTensor_(add)(r, this, value);
        return r;
    }

    public JTensor sub(JType value) {
        JTensor r = new JTensor();
        TH.THTensor_(sub)(r, this, value);
        return r;
    }

    public JTensor addScaled(JType value, JType alpha) {
        JTensor r = new JTensor();
        TH.THTensor_(add_scaled)(r, this, value, alpha);
        return r;
    }

    public JTensor sub_scaled(JType value, JType alpha) {
        JTensor r = new JTensor();
        TH.THTensor_(sub_scaled)(r, this, value, alpha);
        return r;
    }

    public JTensor mul(JType value) {
        JTensor r = new JTensor();
        TH.THTensor_(mul)(r, this, value);
        return r;
    }

    public JTensor div(JType value) {
        JTensor r = new JTensor();
        TH.THTensor_(div)(r, this, value);
        return r;
    }

    public JTensor lshift(JType value) {
        JTensor r = new JTensor();
        TH.THTensor_(lshift)(r, this, value);
        return r;
    }

    public JTensor rshift(JType value) {
        JTensor r = new JTensor();
        TH.THTensor_(rshift)(r, this, value);
        return r;
    }

    public JTensor fmod(JType value) {
        JTensor r = new JTensor();
        TH.THTensor_(fmod)(r, this, value);
        return r;
    }

    public JTensor remainder(JType value) {
        JTensor r = new JTensor();
        TH.THTensor_(remainder)(r, this, value);
        return r;
    }

    public JTensor clamp(JType minValue, JType maxValue) {
        JTensor r = new JTensor();
        TH.THTensor_(clamp)(r, this, minValue, maxValue);
        return r;
    }

    public JTensor bitand(JType value) {
        JTensor r = new JTensor();
        TH.THTensor_(bitand)(r, this, value);
        return r;
    }

    public JTensor bitor(JType value) {
        JTensor r = new JTensor();
        TH.THTensor_(bitor)(r, this, value);
        return r;
    }

    public JTensor bitxor(JType value) {
        JTensor r = new JTensor();
        TH.THTensor_(bitxor)(r, this, value);
        return r;
    }

    public JTensor cadd(JType a, JTensor y) {
        JTensor z = new JTensor();
        TH.THTensor_(cadd)(z, this, a, y);
        return z;
    }

    public JTensor csub(JType a, JTensor y) {
        JTensor z = new JTensor();
        TH.THTensor_(csub)(z, this, a, y);
        return z;
    }

    public JTensor cmul(JTensor y) {
        JTensor z = new JTensor();
        TH.THTensor_(cmul)(z, this, y);
        return z;
    }

    public JTensor cpow(JTensor y) {
        JTensor z = new JTensor();
        TH.THTensor_(cpow)(z, this, y);
        return z;
    }

    public JTensor cdiv(JTensor y) {
        JTensor z = new JTensor();
        TH.THTensor_(cdiv)(z, this, y);
        return z;
    }

    public JTensor clshift(JTensor y) {
        JTensor z = new JTensor();
        TH.THTensor_(clshift)(z, this, y);
        return z;
    }

    public JTensor crshift(JTensor y) {
        JTensor z = new JTensor();
        TH.THTensor_(crshift)(z, this, y);
        return z;
    }

    public JTensor cfmod(JTensor y) {
        JTensor z = new JTensor();
        TH.THTensor_(cfmod)(z, this, y);
        return z;
    }

    public JTensor cremainder(JTensor y) {
        JTensor z = new JTensor();
        TH.THTensor_(cremainder)(z, this, y);
        return z;
    }

    public JTensor cbitand(JTensor y) {
        JTensor z = new JTensor();
        TH.THTensor_(cbitand)(z, this, y);
        return z;
    }

    public JTensor cbitor(JTensor y) {
        JTensor z = new JTensor();
        TH.THTensor_(cbitor)(z, this, y);
        return z;
    }

    public JTensor cbitxor(JTensor y) {
        JTensor z = new JTensor();
        TH.THTensor_(cbitxor)(z, this, y);
        return z;
    }

    /**
     * Computes t + a(s1 * s2), where s1 and s2 are element-wise-multiplied.
     */
    public static JTensor addcmul(JTensor t, JType a, JTensor s1, JTensor s2) {
        JTensor r = new JTensor();
        TH.THTensor_(addcmul)(r, t, a, s1, s2);
        return r;
    }

    /**
     * Computes t + a(s1 / s2), where s1 and s2 are element-wise-divided.
     */
    public static JTensor addcdiv(JTensor t, JType a, JTensor y, JTensor z) {
        JTensor r = new JTensor();
        TH.THTensor_(addcdiv)(r, t, a, y, z);
        return r;
    }

    /** Computes b * t + a * (mat * vec). */
    public static JTensor addmv(JType b, JTensor t, JType a, JTensor mat, JTensor vec) {
        JTensor r = new JTensor();
        TH.THTensor_(addmv)(r, b, t, a, mat, vec);
        return r;
    }

    /** Computes b * t + a * (mat1 * mat2). */
    public static JTensor addmm(JType b, JTensor t, JType a, JTensor mat1, JTensor mat2) {
        JTensor r = new JTensor();
        TH.THTensor_(addmm)(r, b, t, a, mat1, mat2);
        return r;
    }

    /** Computes b * t + a * (vec1 * vec2^T), where vec1 and vec2 are multiplied to yield the outer product. */
    public static JTensor addr(JType b, JTensor t, JType a, JTensor vec1, JTensor vec2) {
        JTensor r = new JTensor();
        TH.THTensor_(addr)(r, b, t, a, vec1, vec2);
        return r;
    }

    /** Computes b * mat + a * ReduceSumOverBatches(bmat1 * bmat2). */
    public static JTensor addbmm(JType b, JTensor mat, JType a, JTensor bmat1, JTensor bmat2) {
        JTensor r = new JTensor();
        TH.THTensor_(addbmm)(r, b, mat, a, bmat1, bmat2);
        return r;
    }

    /**
     * Computes b * t + a * bmm(bmat1, bmat2).
     * @param t [b, n, p]
     * @param bmat1 [b, m, n]
     * @param bmat2 [b, n, p]
     * @return [b, n, p]
     */
    public static JTensor baddbmm(JType b, JTensor t, JType a, JTensor bmat1, JTensor bmat2) {
        JTensor r = new JTensor();
        TH.THTensor_(baddbmm)(r, b, t, a, bmat1, bmat2);
        return r;
    }

    // TODO: what does this do?
    public JTensor match(JTensor that, JType gain) {
        JTensor r = new JTensor();
        TH.THTensor_(match)(r, this, that, gain);
        return r;
    }

    public long numel() {
        return TH.THTensor_(numel)(this);
    }

    public ArgOpResult<JTensor, LongTensor> max(int dim, boolean keepDim) {
        JTensor v = new JTensor();
        LongTensor i = new LongTensor();
        TH.THTensor_(max)(v, i, this, dim, keepDim ? 1 : 0);
        return new ArgOpResult(v, i);
    }

    public ArgOpResult<JTensor, LongTensor> min(int dim, boolean keepDim) {
        JTensor v = new JTensor();
        LongTensor i = new LongTensor();
        TH.THTensor_(min)(v, i, this, dim, keepDim ? 1 : 0);
        return new ArgOpResult(v, i);
    }

    public ArgOpResult<JTensor, LongTensor> kthvalue(long k, int dim, boolean keepDim) {
        JTensor v = new JTensor();
        LongTensor i = new LongTensor();
        TH.THTensor_(kthvalue)(v, i, this, k, dim, keepDim ? 1 : 0);
        return new ArgOpResult(v, i);
    }

    public ArgOpResult<JTensor, LongTensor> mode(int dim, boolean keepDim) {
        JTensor v = new JTensor();
        LongTensor i = new LongTensor();
        TH.THTensor_(mode)(v, i, this, dim, keepDim ? 1 : 0);
        return new ArgOpResult(v, i);
    }

    public ArgOpResult<JTensor, LongTensor> median(int dim, boolean keepDim) {
        JTensor v = new JTensor();
        LongTensor i = new LongTensor();
        TH.THTensor_(median)(v, i, this, dim, keepDim ? 1 : 0);
        return new ArgOpResult(v, i);
    }

    public JTensor sum(int dim, boolean keepDim) {
        JTensor v = new JTensor();
        TH.THTensor_(sum)(v, this, dim, keepDim ? 1 : 0);
        return v;
    }

    public JTensor prod(int dim, boolean keepDim) {
        JTensor v = new JTensor();
        TH.THTensor_(prod)(v, this, dim, keepDim ? 1 : 0);
        return v;
    }

    public JTensor cumsum(int dim) {
        JTensor v = new JTensor();
        TH.THTensor_(cumsum)(v, this, dim);
        return v;
    }

    public JTensor cumprod(int dim) {
        JTensor v = new JTensor();
        TH.THTensor_(cumprod)(v, this, dim);
        return v;
    }

    public JTensor sign() {
        JTensor r = new JTensor();
        TH.THTensor_(sign)(r, this);
        return r;
    }

    public AccReal trace() {
        return TH.THTensor_(trace)(this);
    }

    public JTensor cross(JTensor b, int dim) {
        JTensor c = new JTensor();
        TH.THTensor_(cross)(c, this, b, dim);
        return c;
    }

    public JTensor cmax(JTensor b) {
        JTensor c = new JTensor();
        TH.THTensor_(cmax)(c, this, b);
        return c;
    }

    public JTensor cmin(JTensor b) {
        JTensor c = new JTensor();
        TH.THTensor_(cmin)(c, this, b);
        return c;
    }

    public JTensor cmaxValue(JType value) {
        JTensor c = new JTensor();
        TH.THTensor_(cmaxValue)(c, this, value);
        return c;
    }

    public JTensor cminValue(JType value) {
        JTensor c = new JTensor();
        TH.THTensor_(cminValue)(c, this, value);
        return c;
    }

    public static JTensor zeros(LongStorage size) {
        JTensor z = new JTensor();
        TH.THTensor_(zeros)(z, size);
        return z;
    }

    public static JTensor zeros(long... size) {
        return zeros(LongStorage.fromJava(size));
    }

    public static JTensor zerosLike(JTensor x) {
        JTensor z = new JTensor();
        TH.THTensor_(zerosLike)(z, x);
        return z;
    }

    public static JTensor ones(LongStorage size) {
        JTensor z = new JTensor();
        TH.THTensor_(ones)(z, size);
        return z;
    }

    public static JTensor ones(long... size) {
        return ones(LongStorage.fromJava(size));
    }

    public static JTensor onesLike(JTensor x) {
        JTensor z = new JTensor();
        TH.THTensor_(onesLike)(z, x);
        return z;
    }

    public JTensor diag(int k) {
        JTensor r = new JTensor();
        TH.THTensor_(diag)(r, this, k);
        return r;
    }

    public static JTensor eye(long n, long m) {
        JTensor r = new JTensor();
        TH.THTensor_(eye)(r, n, m);
        return r;
    }

    public static JTensor arange(AccReal xmin, AccReal xmax, AccReal step) {
        JTensor r = new JTensor();
        TH.THTensor_(arange)(r, xmin, xmax, step);
        return r;
    }

    public static JTensor range(AccReal xmin, AccReal xmax, AccReal step) {
        JTensor r = new JTensor();
        TH.THTensor_(range)(r, xmin, xmax, step);
        return r;
    }

    public static JTensor randperm(Generator generator, long n) {
        JTensor r = new JTensor();
        TH.THTensor_(randperm)(r, generator, n);
        return r;
    }

    public JTensor reshape(LongStorage size) {
        JTensor r = new JTensor();
        TH.THTensor_(reshape)(r, this, size);
        return r;
    }

    public JTensor reshape(long... size) {
        return reshape(LongStorage.fromJava(size));
    }

    public ArgOpResult<JTensor, LongTensor> sort(int dim, boolean descending) {
        JTensor rt = new JTensor();
        LongTensor ri = new LongTensor();
        TH.THTensor_(sort)(rt, ri, this, dim, descending ? 1 : 0);
        return new ArgOpResult(rt, ri);
    }

    public ArgOpResult<JTensor, LongTensor> topk(long k, int dim, boolean largest, boolean sorted) {
        JTensor rt = new JTensor();
        LongTensor ri = new LongTensor();
        TH.THTensor_(topk)(rt, ri, this, k, dim, largest ? 1 : 0, sorted ? 1 : 0);
        return new ArgOpResult(rt, ri);
    }

    public JTensor tril(long k) {
        JTensor r = new JTensor();
        TH.THTensor_(tril)(r, this, k);
        return r;
    }

    public JTensor triu(long k) {
        JTensor r = new JTensor();
        TH.THTensor_(triu)(r, this, k);
        return r;
    }

    public JTensor cat(JTensor that, int dim) {
        JTensor r = new JTensor();
        TH.THTensor_(cat)(r, this, that, dim);
        return r;
    }

    public static JTensor catArray(JTensor[] inputs, int dim) {
        JTensor r = new JTensor();
        SWIGTYPE_p_p_THTensor xs = TH.new_CTensorArray(inputs.length);
        for (int i = 0; i < inputs.length; i++)
            TH.CTensorArray_setitem(xs, i, inputs[i]);
        TH.THTensor_(catArray)(r, xs, inputs.length, dim);
        return r;
    }

    public boolean equal(JTensor that) {
        return TH.THTensor_(equal)(this, that) != 0;
    }

    public boolean equals(Object that) {
        return (that instanceof THTensor) && equal((JTensor) that);
    }

    public UByteTensor ltValue(JType value) {
        UByteTensor r = new UByteTensor();
        TH.THTensor_(ltValue)(r, this, value);
        return r;
    }

    public UByteTensor leValue(JType value) {
        UByteTensor r = new UByteTensor();
        TH.THTensor_(leValue)(r, this, value);
        return r;
    }

    public UByteTensor gtValue(JType value) {
        UByteTensor r = new UByteTensor();
        TH.THTensor_(gtValue)(r, this, value);
        return r;
    }

    public UByteTensor geValue(JType value) {
        UByteTensor r = new UByteTensor();
        TH.THTensor_(geValue)(r, this, value);
        return r;
    }

    public UByteTensor neValue(JType value) {
        UByteTensor r = new UByteTensor();
        TH.THTensor_(eqValue)(r, this, value);
        return r;
    }

    public UByteTensor eqValue(JType value) {
        UByteTensor r = new UByteTensor();
        TH.THTensor_(eqValue)(r, this, value);
        return r;
    }


    public UByteTensor ltTensor(JTensor that) {
        UByteTensor r = new UByteTensor();
        TH.THTensor_(ltTensor)(r, this, that);
        return r;
    }

    public UByteTensor leTensor(JTensor that) {
        UByteTensor r = new UByteTensor();
        TH.THTensor_(leTensor)(r, this, that);
        return r;
    }

    public UByteTensor gtTensor(JTensor that) {
        UByteTensor r = new UByteTensor();
        TH.THTensor_(gtTensor)(r, this, that);
        return r;
    }

    public UByteTensor geTensor(JTensor that) {
        UByteTensor r = new UByteTensor();
        TH.THTensor_(geTensor)(r, this, that);
        return r;
    }

    public UByteTensor neTensor(JTensor that) {
        UByteTensor r = new UByteTensor();
        TH.THTensor_(eqTensor)(r, this, that);
        return r;
    }

    public UByteTensor eqTensor(JTensor that) {
        UByteTensor r = new UByteTensor();
        TH.THTensor_(eqTensor)(r, this, that);
        return r;
    }

    // (lt/le/gt/ge/ne/eq)(Value/Tensor)(/T)

    public JTensor pow(JType value) {
        JTensor r = new JTensor();
        TH.THTensor_(pow)(r, this, value);
        return r;
    }

    public static JTensor tpow(JType value, JTensor t) {
        JTensor r = new JTensor();
        TH.THTensor_(tpow)(r, value, t);
        return r;
    }

#if defined(TH_REAL_IS_SHORT) || defined(TH_REAL_IS_INT) || defined(TH_REAL_IS_LONG)

    public JTensor abs() {
        JTensor r = new JTensor();
        TH.THTensor_(abs)(r, this);
        return r;
    }

#endif

#if defined(TH_REAL_IS_FLOAT) || defined(TH_REAL_IS_DOUBLE)

    public JTensor sigmoid() {
        JTensor r = new JTensor();
        TH.THTensor_(sigmoid)(r, this);
        return r;
    }

    public JTensor log() {
        JTensor r = new JTensor();
        TH.THTensor_(log)(r, this);
        return r;
    }

    public JTensor lgamma() {
        JTensor r = new JTensor();
        TH.THTensor_(lgamma)(r, this);
        return r;
    }

    public JTensor digamma() {
        JTensor r = new JTensor();
        TH.THTensor_(digamma)(r, this);
        return r;
    }

    public JTensor trigamma() {
        JTensor r = new JTensor();
        TH.THTensor_(trigamma)(r, this);
        return r;
    }

    public JTensor polygamma(long n) {
        JTensor r = new JTensor();
        TH.THTensor_(polygamma)(r, n, this);
        return r;
    }

    public JTensor log10() {
        JTensor r = new JTensor();
        TH.THTensor_(log10)(r, this);
        return r;
    }

    public JTensor log1p() {
        JTensor r = new JTensor();
        TH.THTensor_(log1p)(r, this);
        return r;
    }

    public JTensor log2() {
        JTensor r = new JTensor();
        TH.THTensor_(log2)(r, this);
        return r;
    }

    public JTensor exp() {
        JTensor r = new JTensor();
        TH.THTensor_(exp)(r, this);
        return r;
    }

    public JTensor expm1() {
        JTensor r = new JTensor();
        TH.THTensor_(expm1)(r, this);
        return r;
    }

    public JTensor cos() {
        JTensor r = new JTensor();
        TH.THTensor_(cos)(r, this);
        return r;
    }

    public JTensor acos() {
        JTensor r = new JTensor();
        TH.THTensor_(acos)(r, this);
        return r;
    }

    public JTensor cosh() {
        JTensor r = new JTensor();
        TH.THTensor_(cosh)(r, this);
        return r;
    }

    public JTensor sin() {
        JTensor r = new JTensor();
        TH.THTensor_(sin)(r, this);
        return r;
    }

    public JTensor asin() {
        JTensor r = new JTensor();
        TH.THTensor_(asin)(r, this);
        return r;
    }

    public JTensor sinh() {
        JTensor r = new JTensor();
        TH.THTensor_(sinh)(r, this);
        return r;
    }

    public JTensor tan() {
        JTensor r = new JTensor();
        TH.THTensor_(tan)(r, this);
        return r;
    }

    public JTensor atan() {
        JTensor r = new JTensor();
        TH.THTensor_(atan)(r, this);
        return r;
    }

    public static JTensor atan2(JTensor x, JTensor y) {
        JTensor r = new JTensor();
        TH.THTensor_(atan2)(r, x, y);
        return r;
    }

    public JTensor tanh() {
        JTensor r = new JTensor();
        TH.THTensor_(tanh)(r, this);
        return r;
    }
    public JTensor erf() {
        JTensor r = new JTensor();
        TH.THTensor_(erf)(r, this);
        return r;
    }
    public JTensor erfinv() {
        JTensor r = new JTensor();
        TH.THTensor_(erfinv)(r, this);
        return r;
    }
    public JTensor sqrt() {
        JTensor r = new JTensor();
        TH.THTensor_(sqrt)(r, this);
        return r;
    }
    public JTensor rsqrt() {
        JTensor r = new JTensor();
        TH.THTensor_(rsqrt)(r, this);
        return r;
    }
    public JTensor ceil() {
        JTensor r = new JTensor();
        TH.THTensor_(ceil)(r, this);
        return r;
    }
    public JTensor floor() {
        JTensor r = new JTensor();
        TH.THTensor_(floor)(r, this);
        return r;
    }
    public JTensor round() {
        JTensor r = new JTensor();
        TH.THTensor_(round)(r, this);
        return r;
    }
    public JTensor abs() {
        JTensor r = new JTensor();
        TH.THTensor_(abs)(r, this);
        return r;
    }
    public JTensor trunc() {
        JTensor r = new JTensor();
        TH.THTensor_(trunc)(r, this);
        return r;
    }
    public JTensor frac() {
        JTensor r = new JTensor();
        TH.THTensor_(frac)(r, this);
        return r;
    }
    public static JTensor lerp(JTensor x, JTensor y, JType w) {
        JTensor r = new JTensor();
        TH.THTensor_(lerp)(r, x, y, w);
        return r;
    }

    public JTensor mean(int dim, boolean keepdim) {
        JTensor r = new JTensor();
        TH.THTensor_(mean)(r, this, dim, keepdim ? 1 : 0);
        return r;
    }
    public JTensor std(int dim, boolean biased, boolean keepdim) {
        JTensor r = new JTensor();
        TH.THTensor_(std)(r, this, dim, biased ? 1 : 0, keepdim ? 1 : 0);
        return r;
    }

    public JTensor var(int dim, boolean biased, boolean keepdim) {
        JTensor r = new JTensor();
        TH.THTensor_(var)(r, this, dim, biased ? 1 : 0, keepdim ? 1 : 0);
        return r;
    }

    public JTensor norm(JType value, int dim, boolean keepdim) {
        JTensor r = new JTensor();
        TH.THTensor_(norm)(r, this, value, dim, keepdim ? 1 : 0);
        return r;
    }
    public JTensor renorm(JType value, int dim, JType maxnorm) {
        JTensor r = new JTensor();
        TH.THTensor_(renorm)(r, this, value, dim, maxnorm);
        return r;
    }
    public AccReal dist(JTensor that, JType value) {
        return TH.THTensor_(dist)(this, that, value);
    }

    // histc
    // bhistc

    public AccReal meanall() {
        return TH.THTensor_(meanall)(this);
    }

    public AccReal varall(boolean biased) {
        return TH.THTensor_(varall)(this, biased ? 1 : 0);
    }
    public AccReal stdall(boolean biased) {
        return TH.THTensor_(stdall)(this, biased ? 1 : 0);
    }
    public AccReal normall(JType value) {
        return TH.THTensor_(normall)(this, value);
    }

    public static JTensor linspace(JType a, JType b, long n) {
        JTensor r = new JTensor();
        TH.THTensor_(linspace)(r, a, b, n);
        return r;
    }

    public static JTensor logspace(JType a, JType b, long n) {
        JTensor r = new JTensor();
        TH.THTensor_(logspace)(r, a, b, n);
        return r;
    }

    public static JTensor rand(Generator generator, LongStorage size) {
        JTensor r = new JTensor();
        TH.THTensor_(rand)(r, generator, size);
        return r;
    }

    public static JTensor randn(Generator generator, LongStorage size) {
        JTensor r = new JTensor();
        TH.THTensor_(randn)(r, generator, size);
        return r;
    }

    // dirichlet_Grad

#endif

#if defined(TH_REAL_IS_BYTE)

    public boolean logicalall() {
        return TH.THTensor_(logicalall)(this) != 0;
    }

    public boolean logicalany() {
        return TH.THTensor_(logicalany)(this) != 0;
    }

#endif

    // RANDOM


    // CONV

    public void close() {
        free();
    }

    public String toString() {
        return desc().getStr();
    }
}
