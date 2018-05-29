package jtorch;

import jtorch.jni.*;

/**
 * Wraps around constants and functions in THLogAdd.h.
 * @author Tongfei Chen
 */
public class LogAdd {

    final static double Log2Pi = TH.getTHLog2Pi();
    final static double LogZero = TH.getTHLogZero();
    final static double LogOne = TH.getTHLogOne();

    double logAdd(double log_a, double log_b) {
        return TH.THLogAdd(log_a, log_b);
    }

    double logSub(double log_a, double log_b) {
        return TH.THLogSub(log_a, log_b);
    }

    double expMinusApprox(double x) {
        return TH.THExpMinusApprox(x);
    }

}
