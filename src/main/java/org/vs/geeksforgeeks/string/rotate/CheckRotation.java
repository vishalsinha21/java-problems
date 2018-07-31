package org.vs.geeksforgeeks.string.rotate;

import java.util.Scanner;

public class CheckRotation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            String originalString = scanner.next();
            String rotatedString = scanner.next();

            System.out.println(checkOriginalStringRotation(originalString, rotatedString, 2));
        }

    }

    private static int checkOriginalStringRotation(String originalString, String rotatedString, int count) {
        return rotatedString.equals(rotateClockWise(originalString, count))
                || rotatedString.equals(rotateAntiClockWise(originalString, count)) ? 1 : 0;
    }

    private static String rotateAntiClockWise(String str, int count) {
        int length = str.length();
        int newCount = count % length;
        return str.substring(newCount, length) + str.substring(0, newCount);
    }

    private static String rotateClockWise(String str, int count) {
        int length = str.length();
        int newCount = count % length;
        return str.substring(length - newCount, length) + str.substring(0, length - newCount);
    }

}
