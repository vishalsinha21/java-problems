package org.vs.ctci.string.compression;

public class Compress {

    public static String getCompressedString(String str) {
        char[] chars = str.toCharArray();

        StringBuilder sb = new StringBuilder();
        int maxRepeatCount = 0;

        for (int i = 0; i < chars.length; ) {
            char ch = chars[i];
            int j = i + 1;
            int repeatCount = 1;

            //compare to next character, and keep track of repeat count
            while (j < chars.length && chars[i] == chars[j]) {
                repeatCount++;
                j++;
            }

            //if max repeat count is 1 then it means that there are no repetitions, hence same string can be returned
            maxRepeatCount = Math.max(maxRepeatCount, repeatCount);

            i = j;
            //if different character is found then add character and repeat count to string buffer
            sb.append(ch);
            sb.append(repeatCount);
        }

        return maxRepeatCount > 1 ? sb.toString() : str;
    }
}
