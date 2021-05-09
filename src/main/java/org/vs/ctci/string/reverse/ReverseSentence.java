package org.vs.ctci.string.reverse;

public class ReverseSentence {

    public static void main(String[] args) {
        System.out.println(reverseSentence("how are you doing"));
        System.out.println(reverseSentence1("how are you doing"));
    }

    public static String reverseSentence(String str) {

        String[] arr = str.split("\\s");
        StringBuilder sb = new StringBuilder(str.length());

        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]).append(" ");
        }

        return sb.toString();
    }

    public static String reverseSentence1(String str) {
        StringBuilder sentence = new StringBuilder(str.length());
        int wordEnd = str.length();

        for (int i = str.length() - 1; i >= 0; i--) {

            char ch = str.charAt(i);

            if (ch == ' ') {
                sentence.append(str, i + 1, wordEnd);
                sentence.append(ch);
                wordEnd = i;
            }

            if (i == 0) {
                sentence.append(str, i, wordEnd);
            }
        }


        return sentence.toString();
    }
}
