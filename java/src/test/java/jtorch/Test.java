package jtorch;

import jtorch.jni.*;

/**
 * @author Tongfei Chen
 */
public class Test {

    static public void main(String[] args) {

        FloatTensor a = FloatTensor.eye(3, 3);
        FloatTensor b = a.neg();
        a.neg_();

        FloatTensor c = FloatTensor.ones();


        System.out.print(3);

        for (int i = 0; i < 1000; i += 1) {
            FloatTensor x = FloatTensor.eye(1000, 1000);
        }

    }

}
