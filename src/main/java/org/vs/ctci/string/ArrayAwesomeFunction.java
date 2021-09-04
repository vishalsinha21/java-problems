package org.vs.ctci.string;

public class ArrayAwesomeFunction {

    public static boolean isArrayRotation(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }

        int offset = -1;

        int length = a.length;
        for (int i = 0; i < length; i++) {
            if (a[0] == b[i]) {
                offset = i;
            }
        }

        if (offset < 0) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            int j = (i + offset) % length;
            if (a[i] != b[j]) {
                return false;
            }
        }

        return true;
    }

}
