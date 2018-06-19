package jtorch;

/**
 * Manages memory allocated off the JVM heap.
 * @author Tongfei Chen
 */
public interface MainMemoryNativeObject extends NativeObject {

    long cPtr();

    //long sizeInMemory();

}
