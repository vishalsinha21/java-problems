package org.vs.hackerrank;

import java.util.stream.IntStream;

public class CountOfA {

    public static long repeatedString(String s, long n) {
        // Write your code here
        long countOfAInString = getCountOfChar(s, 'a');
        long length = s.length();

        long completedStringRepeatedCount = n / length;
        long partialStringLength = n % length;

        long countOfAInPartialSubstring = partialStringLength > 0l
                ? getCountOfChar(s.substring((int) partialStringLength), 'a')
                : 0l;

        return countOfAInString * completedStringRepeatedCount + countOfAInPartialSubstring;
    }

    public static long getCountOfChar(String str, char ch) {
        char[] chars = str.toCharArray();
        return IntStream.range(0, chars.length)
                .mapToObj(i -> Character.valueOf(chars[i]))
                .filter(c -> c == 'a').count();
    }
}
