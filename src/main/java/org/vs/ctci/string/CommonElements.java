package org.vs.ctci.string;

import java.util.ArrayList;
import java.util.List;

public class CommonElements {

    public static List<Integer> getCommonElements(int[] a, int[] b) {
        List<Integer> list = new ArrayList<>();
        int j = 0;

        if (a.length == 0 || b.length == 0) {
            return list;
        }

        for (int i = 0; i < a.length; i++) {
            while (j < b.length && a[i] >= b[j]) {
                if (a[i] == b[j]) {
                    System.out.println("Found common element: " + a[i]);
                    list.add(a[i]);
                }
                j++;
            }

            if (j == b.length) {
                break;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 4, 7, 9, 16, 18, 20};
        int[] b = {3, 7, 8, 10, 15, 16, 17};
        getCommonElements(a, b);
    }
}
