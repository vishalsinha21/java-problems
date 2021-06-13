package org.vs.ctci.string.rotate;

public class Rotate {

    public static int[][] rotate(int[][] arr, int size) {
        int[][] newArr = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int a = j;
                int b = size - 1 - i;

                newArr[a][b] = arr[i][j];
            }
        }

        return newArr;
    }

}
