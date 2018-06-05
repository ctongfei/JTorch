package jtorch;

import jtorch.jni.*;

/**
 * Proxy class for the Torch THGeneratorState type.
 * @author Tongfei Chen
 */
public class GeneratorState extends SWIGTYPE_p_THGeneratorState {

    protected GeneratorState(SWIGTYPE_p_THGeneratorState underlying) {
        super(SWIGTYPE_p_THGeneratorState.getCPtr(underlying), true);
    }

    protected long cPtr() {
        return SWIGTYPE_p_THGeneratorState.getCPtr(this);
    }

    public boolean isValid() {
        return TH.THGeneratorState_isValid(this) != 0;
    }

    public GeneratorState copy(GeneratorState from) {
        return new GeneratorState(
                TH.THGeneratorState_copy(this, from)
        );
    }

}
