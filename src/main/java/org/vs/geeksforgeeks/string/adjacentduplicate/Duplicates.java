package org.vs.geeksforgeeks.string.adjacentduplicate;

public class Duplicates {

    public static void main(String[] args) {
        removeDuplicates("acaaa");
    }

    private static void removeDuplicates(String str) {
        int length = str.length();
        int count = 1;
        int i = 0;

        for (; i + 1 < length; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                if (count > 1) {
                    break;
                }
            }
        }


        if (count > 1) {
            str = str.substring(0, i - count + 1) + str.substring(count, length);
            System.out.println(str);
            removeDuplicates(str);
        }

        System.out.println("final: " + str);
    }
}
