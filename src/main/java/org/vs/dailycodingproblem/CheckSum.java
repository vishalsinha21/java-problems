package org.vs.dailycodingproblem;

public class CheckSum {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 6, 8, 12, 10, 7};
        System.out.println(checkSum(arr, 99));
    }

    private static boolean checkSum(int[] arr, int sum) {
        int length = arr.length;
        for (int i = 0; i < length - 2; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                if (arr[i] + arr[j] == sum) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean checkSum1(int[] arr, int sum) {
        int length = arr.length;
        for (int i = 0, j = length - 1; i < length || j >= 0; i++, j--) {
            if (arr[i] + arr[j] == sum) {
                return true;
            }
        }

        return false;
    }

}
