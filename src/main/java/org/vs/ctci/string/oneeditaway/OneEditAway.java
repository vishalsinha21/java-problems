package org.vs.ctci.string.oneeditaway;

public class OneEditAway {

    public static void main(String[] args) {
        System.out.println(isOneEditAway("pale", "ple"));
        System.out.println(isOneEditAway("pales", "pale"));
        System.out.println(isOneEditAway("pale", "bale"));
        System.out.println(isOneEditAway("pale", "bake"));
    }

    public static boolean isOneEditAway(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();

        //more than one character difference
        if (Math.abs(length1 - length2) > 1) {
            return false;
        }

        if (length1 == length2) {
            return checkForSameLength(str1, str2);
        }

        if (length1 > length2) {
            return checkForDifferentLength(str1, str2);
        } else {
            return checkForDifferentLength(str2, str1);
        }
    }

    private static boolean checkForDifferentLength(String bigString, String smallString) {
        int diffCount = 0;
        int smallStringLen = smallString.length();

        for (int i = 0, j = 0; i < bigString.length(); ) {
            if (i >= smallStringLen) {
                break;
            }

            if (bigString.charAt(i) != smallString.charAt(j)) {
                diffCount++;
                i++;

                if (diffCount > 1) {
                    return false;
                }

            } else {
                i++;
                j++;
            }

        }

        return true;
    }

    private static boolean checkForSameLength(String str1, String str2) {
        int diffCount = 0;

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                diffCount++;

                if (diffCount > 1) {
                    return false;
                }
            }
        }
        return true;
    }


}
