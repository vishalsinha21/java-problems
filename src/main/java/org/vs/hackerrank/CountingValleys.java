package org.vs.hackerrank;


//Problem link: https://www.hackerrank.com/challenges/counting-valleys/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
public class CountingValleys {

    public static int countingValleys(int steps, String path) {
        char[] chars = path.toCharArray();

        int altitude = 0;
        int numOfValleys = 0;
        boolean negativeAltitude = false;

        for (char ch : chars) {
            negativeAltitude = altitude < 0;

            if (ch == 'U') {
                altitude++;
            }

            if (ch == 'D') {
                altitude--;
            }

            if (negativeAltitude && altitude == 0) {
                numOfValleys++;
            }
        }

        return numOfValleys;
    }

    public static void main(String[] args) {
        System.out.println(countingValleys(8, "UDDDUDUU"));
    }

}
