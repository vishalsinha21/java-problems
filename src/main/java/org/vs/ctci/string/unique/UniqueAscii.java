package org.vs.ctci.string.unique;

public class UniqueAscii {

    public static void main(String[] args) {
        System.out.println(isUnique("hello"));
        System.out.println(isUnique("helo"));
        System.out.println(isUnique("helLo"));
    }

    public static boolean isUnique(String str) {
        boolean[] arr = new boolean[128];

        if (str.length() > 128) {
            return false;
        }

        for (char c: str.toCharArray()) {
            if (arr[c]) {
                return false;
            }
            arr[c] = true;
        }
        return true;
    }

}
