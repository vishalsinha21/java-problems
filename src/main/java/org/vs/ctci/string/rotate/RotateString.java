package org.vs.ctci.string.rotate;

public class RotateString {

    public static String rotate(String str, int position) {
        int length = str.length();
        position = position % length;
        return str.substring(length - position, length) + str.substring(0, length - position);
    }

}
