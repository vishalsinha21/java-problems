package org.vs.ctci.string.compression;

public class Compression {

    public static void main(String[] args) {
        System.out.println(compressString("ab"));
        System.out.println(compressString("abcde"));
        System.out.println(compressString("aab"));
        System.out.println(compressString("aabb"));
        System.out.println(compressString("aabcccccaaa"));
    }

    public static String compressString(String str) {
        char temp = ' ';
        StringBuilder sb = new StringBuilder(str.length());
        boolean isCompressable = false;
        int charCount = 1;

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) != temp) {
                temp = str.charAt(i);

                if (i > 0) {
                    sb.append(charCount);
                }

                sb.append(temp);

                charCount = 1;

            } else {
                charCount++;
                isCompressable = true;
            }

        }

        sb.append(charCount);
        return isCompressable ? sb.toString() : str;


    }
}
