package org.vs.geeksforgeeks;

public class Test {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int sum = 0;

        int length = arr.length;
        int maxLen = arr.length;

        while (maxLen > 0) {
            sum = 0;
            for (int i = 0; i < length; i++) {
                sum += arr[i];

                if (i >= maxLen - 1) {
                    System.out.println(sum);
                    sum = sum - arr[i - maxLen + 1];
                }
            }

            --maxLen;
        }
    }
}
