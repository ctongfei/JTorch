package jtorch;

import jtorch.jni.*;

/**
 * @author Tongfei Chen
 */
public class Test {

    static public void main(String[] args) {

        THFloatTensor a = TH.THFloatTensor_new();
        TH.THFloatTensor_eye(a, 3, 3);

        System.out.print(3);

    }

}
