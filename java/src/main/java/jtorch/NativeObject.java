package jtorch;

/**
 * @author Tongfei Chen
 */
public interface NativeObject extends AutoCloseable {

    long cPtr();

    default void close() {
        Torch.free(this);
    }

}
