package org.vs.ctci.string.urlify;

public class Urlify {

    public static void main(String[] args) {
        System.out.println(urlify("Mr John Smith    "));
    }

    public static String urlify(String str) {
        int length = str.length();
        char[] chars = str.toCharArray();

        for (int i = 0; i < length; ) {

            if (chars[i] == ' ') {

                //shift letters by 2 to create space for 20 in %20
                for (int j = length - 1; j > i; j--) {
                    chars[j] = chars[j - 2];
                }

                chars[i] = '%';
                chars[i+1] = '2';
                chars[i+2] = '0';

                i++;
            }

            i++;
        }

        return new String(chars);
    }
}
