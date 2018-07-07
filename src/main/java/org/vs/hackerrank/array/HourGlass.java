package org.vs.hackerrank.array;

/*
Solution for https://www.hackerrank.com/challenges/2d-array/problem
 */

public class HourGlass {

    static int hourglassSum(int[][] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                sum = sumHourGlass(arr, i, j);
                if (max < sum) {
                    max = sum;
                }
            }
        }

        return max;
    }

    static int sumHourGlass(int[][] intArr, int i, int j) {
        int sum = 0;
        for (int k = i; k < 3 + i; k++) {
            for (int l = j; l < 3 + j; l++) {
                sum += intArr[k][l];
            }
        }
        return sum - intArr[i + 1][j] - intArr[i + 1][j + 2];
    }

    public static void main(String[] args) {
//        int[][] arr = new int[][]{
//                {1, 1, 1, 0, 0, 0},
//                {0, 1, 0, 0, 0, 0},
//                {1, 1, 1, 0, 0, 0},
//                {0, 0, 2, 4, 4, 0},
//                {0, 0, 0, 2, 0, 0},
//                {0, 0, 1, 2, 4, 0}
//        };

        int[][] arr = new int[][]{
                {-1, -1,  0, -9, -2, -2},
                {-2, -1, -6, -8, -2, -5},
                {-1, -1, -1, -2, -3, -4},
                {-1, -9, -2, -4, -4, -5},
                {-7, -3, -3, -2, -9, -9},
                {-1, -3, -1, -2, -4, -5}
        };

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(hourglassSum(arr));

    }


}
