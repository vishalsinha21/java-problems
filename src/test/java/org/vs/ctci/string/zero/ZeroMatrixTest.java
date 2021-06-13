package org.vs.ctci.string.zero;

import org.junit.jupiter.api.Test;

class ZeroMatrixTest {

    @Test
    void should_not_change_anything_if_no_zero_present() {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printArray(arr);

        int[][] newArr = ZeroMatrix.convertToZeroMatrix(arr);
        printArray(newArr);
    }

    @Test
    void should_convert_to_zero_matrix() {
        int[][] arr = {{1, 0, 3}, {4, 5, 6}, {7, 8, 9}};
        printArray(arr);

        int[][] newArr = ZeroMatrix.convertToZeroMatrix(arr);
        printArray(newArr);
    }

    private void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}