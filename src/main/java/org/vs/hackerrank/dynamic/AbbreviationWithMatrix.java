package org.vs.hackerrank.dynamic;

//https://www.hackerrank.com/challenges/abbr/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dynamic-programming
public class AbbreviationWithMatrix {

    public static void main(String[] args) {
        String a = "DINVMKSOfsVQByBnCWNKPRFRKMhFRSkNQRBVNTIKNBXRSXdADOSeNDcLWFCERZOLQjEZCEPKXPCYKCVKALNxBADQBFDQUpdqunpelxauyyrwtjpkwoxlrrqbjtxlkvkcajhpqhqeitafcsjxwtttzyhzvh";
        String b = "DINVMKSOVQBBCWNKPRFRKMFRSNQRBVNTIKNBXRSXADOSNDLWFCERZOLQEZCEPKXPCYKCVKALNBADQBFDQU";

        System.out.println(abbreviation(a, b));
    }

    //Explanation: https://www.youtube.com/watch?v=4WzCFTmjKu4
    public static String abbreviation(String modifyString, String matchingString) {
        //Create a matrix with modifyString character at the rows side and matchingString character at the column side
        //Last box in the matrix would be the result
        //First row and column represent double quotes
        int rows = modifyString.length() + 1;
        int cols = matchingString.length() + 1;

        boolean[][] cache = new boolean[rows][cols];
        //Double quotes are equal so mark this position as true
        cache[0][0] = true;

        //Logic to fill the result in first column
        for (int i = 1; i < rows; i++) {
            char ch = modifyString.charAt(i - 1);
            //If character is a lower case then the result is equal to the box above it, else it is false
            if (Character.isLowerCase(ch)) {
                cache[i][0] = true;
            } else {
                cache[i][0] = false;
            }
        }

        //Logic to fill the rest of the matrix
        /*
        * If the character from the modify String is upper case
        *  - If the result before adding either the modify string character or the matching string character is false the the result is false
        *  - Else the result is whether or not the characters match
        * If the character from the modify string is lower case
        * - If capitalizing this matches the matching string
        *   - This has 2 considerations
        *       - The result before adding either the modify string character or the matching string character
        *       - or the result from removing the modify string (above cell) is true then the result is true, false otherwise
        *   - If capitalizing does not matches the matching string
        *       - The result is same as the result from removing the modify string (above cell)
         * */

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                char chA = modifyString.charAt(i - 1);
                char chB = matchingString.charAt(j - 1);

                if (Character.isUpperCase(chA)) {
                    if (!cache[i - 1][j - 1]) {
                        cache[i][j] = false;
                    } else {
                        cache[i][j] = (chB == chA);
                    }
                } else {
                    if (chB == Character.toUpperCase(chA)) {
                        cache[i][j] = cache[i - 1][j - 1] || cache[i - 1][j];
                    } else {
                        cache[i][j] = cache[i - 1][j];
                    }
                }
            }
        }

        return cache[rows - 1][cols - 1] ? "YES" : "NO";
    }

}
