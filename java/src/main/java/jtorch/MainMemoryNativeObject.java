package jtorch;

/**
 * @author Tongfei Chen
 */
interface MainMemoryNativeObject extends NativeObject {

    default void close() {
        Torch.free(this);
    }
}
