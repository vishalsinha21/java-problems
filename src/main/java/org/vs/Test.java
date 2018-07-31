package org.vs;

public class Test {

    public static void main(String[] args) {
        String str = "00000";

        System.out.println();
    }

    static int Find(int x, int y, int z) {
        if ((x >= y) && (z < y)) return y;
        else if (x >= y) return Find(x, z, y);
        else return Find(y, x, z);
    }
}
