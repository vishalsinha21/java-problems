package org.vs.geeksforgeeks.arrays.largest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LargestNumber {


    public static void main(String[] args) {
        System.out.println("3".compareTo("3"));

        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            int size = scanner.nextInt();
            int[] arr = new int[size];

            for (int j = 0; j < size; j++) {
                arr[j] = scanner.nextInt();
            }

            System.out.println(getLargestNum(arr));
        }


    }

    private static String getLargestNum(int[] arr) {
        String str = Arrays.stream(arr)
                .mapToObj(i -> String.valueOf(i))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining(""));

        return str;
    }

}
