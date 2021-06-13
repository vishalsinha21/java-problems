package org.vs.ctci.string.rotate;

import org.junit.jupiter.api.Test;

class RotateTest {

    @Test
    void should_rotate_array_by_90_degrees() {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printArray(arr, 3);

        int[][] newArr = Rotate.rotate(arr, 3);
        printArray(newArr, 3);
    }

    private void printArray(int[][] newArr, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(newArr[i][j] + " ");
            }
            System.out.println();
        }
    }
}