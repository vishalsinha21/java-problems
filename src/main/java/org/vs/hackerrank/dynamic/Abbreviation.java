package org.vs.hackerrank.dynamic;

public class Abbreviation {

    public static void main(String[] args) {
        String a = "AbcaBcabC";
        String b = "ABC";

        System.out.println(abbreviation(a, b));
    }

    public static String abbreviation(String a, String b) {
        return abbrev(a, b) ? "YES" : "NO";
    }

    public static boolean abbrev(String a, String b) {
        if (b.length() > a.length()) {
            return false;
        }

        if (a.equals(b)) {
            return true;
        }

        int indexOfFirstLowerCaseCharacter = -1;
        for (int i = 0; i < a.length(); i++) {
            if (Character.isLowerCase(a.charAt(i))) {
                indexOfFirstLowerCaseCharacter = i;
                break;
            }
        }

        if (indexOfFirstLowerCaseCharacter < 0) {
            return false;
        }

        String aWithFirstLowerCaseLetterRemoved = a.substring(0, indexOfFirstLowerCaseCharacter) + a.substring(indexOfFirstLowerCaseCharacter + 1);
        String aWithFirstLowerCaseLetterCapitalized = a.substring(0, indexOfFirstLowerCaseCharacter) + Character.toUpperCase(a.charAt(indexOfFirstLowerCaseCharacter)) + a.substring(indexOfFirstLowerCaseCharacter + 1);

        return abbrev(aWithFirstLowerCaseLetterRemoved, b) || abbrev(aWithFirstLowerCaseLetterCapitalized, b);
    }
}
