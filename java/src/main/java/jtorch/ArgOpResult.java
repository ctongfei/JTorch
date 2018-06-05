package jtorch;

/**
 * Encapsulates the result obtained from Torch's "arg" ops: such as max/min/median/etc.
 * @author Tongfei Chen
 */
public class ArgOpResult<V, I> {

    public V values;
    public I indices;

    public ArgOpResult(V values, I indices) {
        this.values = values;
        this.indices = indices;
    }

}
