package org.vs.ctci.abcd_cube;

import static java.lang.Math.pow;

public class CubeSums {

    public static void main(String[] args) {


        int loopCount = 100;

        for (int a = 1; a < loopCount; a++) {
            for (int b = a + 1; b < loopCount; b++) {
                for (int c = a + 1; c < loopCount; c++) {
                    for (int d = c + 1; d < loopCount; d++) {

                        if (a != b && a != c && a != d
                                && b != c && b != d && c != d
                                && pow(a, 3) + pow(b, 3) == pow(c, 3) + pow(d, 3)) {
                            System.out.println(String.format("%d, %d, %d, %d", a, b, c, d));
                        }
                    }
                }
            }
        }
    }
}
