package jtorch;

import jtorch.jni.*;

/**
 * Proxy class for the Torch THDescBuff type.
 * @author Tongfei Chen
 */
public class DescBuff extends THDescBuff {

    protected DescBuff(THDescBuff underlying) {
        super(THDescBuff.getCPtr(underlying), true);
    }

    protected long cPtr() {
        return THDescBuff.getCPtr(this);
    }

    /**
     * Gets the string content in this Torch DescBuff object.
     */
    public String toString() {
        return this.getStr();
    }

}
