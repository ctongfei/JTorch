package jtorch;

/**
 * Represents an object allocated off-heap, and whose pointer is channeled through SWIG.
 * @author Tongfei Chen
 */
public interface NativeObject extends AutoCloseable {

    long cPtr();

}
