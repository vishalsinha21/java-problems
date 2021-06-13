package org.vs.ctci.string.urlify;

public class OnePassUrlify {

    public static void main(String[] args) {
        String str = "Mr John Smith    ";
        int trueLength = 13;
        char[] chars = str.toCharArray();

        replaceSpaces(chars, trueLength);

        System.out.println(chars);
    }

    private static void replaceSpaces(char[] chars, int trueLength) {
        int spaceCount = 0;
        for (int i = 0; i < trueLength; i++) {
            if (chars[i] == ' ') {
                spaceCount++;
            }
        }
        System.out.println(spaceCount);

        int length = trueLength + spaceCount * 2;
        int index = length - 1;

        for (int i = trueLength - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                chars[index] = '0';
                chars[index - 1] = '2';
                chars[index - 2] = '%';
                index = index - 3;
            } else {
                chars[index] = chars[i];
                index = index - 1;
            }
            System.out.println(chars);
        }

    }

}
