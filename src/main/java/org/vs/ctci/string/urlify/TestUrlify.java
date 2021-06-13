package org.vs.ctci.string.urlify;

public class TestUrlify {

    public static void main(String[] args) {
        String str = "Mr John Smith    ";
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length;) {
            if (chars[i] == ' ') {
                shiftToRight(chars, i, 2);
                chars[i] = '%';
                chars[i + 1] = '2';
                chars[i + 2] = '0';
                i = i + 2;
            }
            System.out.println(chars);
            i++;
        }

        System.out.println(chars);
    }

    private static void shiftToRight(char[] chars, int startPosition, int count) {
        for (int i = chars.length - 1; i >= startPosition + count; i--) {
            chars[i] = chars[i - count];
        }
    }

}
