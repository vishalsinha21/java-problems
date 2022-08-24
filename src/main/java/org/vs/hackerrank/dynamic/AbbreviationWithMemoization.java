package org.vs.hackerrank.dynamic;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AbbreviationWithMemoization {

    public static void main(String[] args) {
        String a = "DINVMKSOfsVQByBnCWNKPRFRKMhFRSkNQRBVNTIKNBXRSXdADOSeNDcLWFCERZOLQjEZCEPKXPCYKCVKALNxBADQBFDQUpdqunpelxauyyrwtjpkwoxlrrqbjtxlkvkcajhpqhqeitafcsjxwtttzyhzvh";
        String b = "DINVMKSOVQBBCWNKPRFRKMFRSNQRBVNTIKNBXRSXADOSNDLWFCERZOLQEZCEPKXPCYKCVKALNBADQBFDQU";

        System.out.println(abbreviation(a, b));
    }

    private static Map<Key, Boolean> cache = new HashMap<>();

    public static String abbreviation(String a, String b) {
        return abbrev(a, b) ? "YES" : "NO";
    }

    public static boolean abbrev(String a, String b) {
        System.out.println("a: " + a + " b: " + b);
        if (cache.containsKey(Key.of(a, b))) {
            return cache.get(Key.of(a, b));
        }

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
            cache.put(Key.of(a, b), false);
            return false;
        }

        String aWithFirstLowerCaseLetterRemoved = a.substring(0, indexOfFirstLowerCaseCharacter) + a.substring(indexOfFirstLowerCaseCharacter + 1);
        String aWithFirstLowerCaseLetterCapitalized = a.substring(0, indexOfFirstLowerCaseCharacter) + Character.toUpperCase(a.charAt(indexOfFirstLowerCaseCharacter)) + a.substring(indexOfFirstLowerCaseCharacter + 1);

        boolean res1 = abbrev(aWithFirstLowerCaseLetterRemoved, b);
        boolean res2 = abbrev(aWithFirstLowerCaseLetterCapitalized, b);

        cache.put(Key.of(aWithFirstLowerCaseLetterRemoved, b), res1);
        cache.put(Key.of(aWithFirstLowerCaseLetterCapitalized, b), res2);

        return res1 || res2;
    }

    static class Key {
        String a;
        String b;

        public static Key of(String a, String b) {
            return new Key(a, b);
        }

        public Key(String a, String b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return Objects.equals(a, key.a) && Objects.equals(b, key.b);
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }
}
