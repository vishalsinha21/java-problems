package org.vs.hackerrank;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

//https://www.hackerrank.com/challenges/triple-sum/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=search
public class Triplets {

    static long triplets(int[] a, int[] b, int[] c) {
        int[] aa = Arrays.stream(a).distinct().sorted().toArray();
        int[] bb = Arrays.stream(b).distinct().sorted().toArray();
        int[] cc = Arrays.stream(c).distinct().sorted().toArray();

        int alength = aa.length;
        int blength = bb.length;
        int clength = cc.length;

        long countOfGrtThanA = 0;
        long countOfGrtThanC = 0;
        long total = 0;

        for (int i = 0; i < blength; i++) {
            countOfGrtThanA = 0;
            countOfGrtThanC = 0;

            for (int j = 0; j < alength; j++) {
                if (bb[i] >= aa[j]) {
                    countOfGrtThanA++;
                } else {
                    break;
                }
            }

            for (int j = 0; j < clength; j++) {
                if (bb[i] >= cc[j]) {
                    countOfGrtThanC++;
                } else {
                    break;
                }
            }

            total += (countOfGrtThanA * countOfGrtThanC);
        }

        return total;
    }

    private static Set<Integer> getUniqueList(int[] arr) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        return set;
    }

    static long triplets1(int[] a, int[] b, int[] c) {
        int[] aa = Arrays.stream(a).distinct().sorted().toArray();
        int[] bb = Arrays.stream(b).distinct().sorted().toArray();
        int[] cc = Arrays.stream(c).distinct().sorted().toArray();

        int alength = aa.length;
        int blength = bb.length;
        int clength = cc.length;

        long[] countOfGrtThanA = new long[blength];
        long[] countOfGrtThanC = new long[blength];
        long total = 0;

        for (int i = 0; i < blength; i++) {
            long count = 0;

            for (int j = 0; j < alength; j++) {
                if (bb[i] >= aa[j]) {
                    count++;
                } else {
                    break;
                }
            }
            countOfGrtThanA[i] = count;
        }

        for (int i = 0; i < blength; i++) {
            long count = 0;

            for (int j = 0; j < clength; j++) {
                if (bb[i] >= cc[j]) {
                    count++;
                } else {
                    break;
                }
            }
            countOfGrtThanC[i] = count;
        }

        for (int i = 0; i < blength; i++) {
            total += (countOfGrtThanA[i] * countOfGrtThanC[i]);
        }

        return total;
    }

    //best solution
    static long triplets2(int[] a, int[] b, int[] c) {
        //remove duplicate and sort the array in ascending order
        int[] aa = Arrays.stream(a).distinct().sorted().toArray();
        int[] bb = Arrays.stream(b).distinct().sorted().toArray();
        int[] cc = Arrays.stream(c).distinct().sorted().toArray();

        int alength = aa.length;
        int blength = bb.length;
        int clength = cc.length;

        long[] countOfGrtThanA = new long[blength];
        long[] countOfGrtThanC = new long[blength];
        long total = 0;

        //iterate bb in reverse order
        for (int i = blength - 1; i >= 0; i--) {
            long count = 0;

            for (int j = 0; j < alength; j++) {
                if (bb[i] >= aa[j]) {
                    count++;
                } else {
                    break;
                }
            }
            //if count is 0 then count would be 0 for all leftover elements
            if (count == 0) {
                break;
            }
            countOfGrtThanA[i] = count;
        }

        for (int i = blength - 1; i >= 0; i--) {
            long count = 0;

            for (int j = 0; j < clength; j++) {
                if (bb[i] >= cc[j]) {
                    count++;
                } else {
                    break;
                }
            }
            if (count == 0) {
                break;
            }
            countOfGrtThanC[i] = count;
        }

        for (int i = 0; i < blength; i++) {
            total += (countOfGrtThanA[i] * countOfGrtThanC[i]);
        }

        return total;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1, 2, 2, 2, 3, 4, 5, 6, 7};
        int[] aa = Arrays.stream(a).distinct().toArray();

        for (int i = 0; i < aa.length; i++) {
            System.out.print(aa[i] + " ");
        }
    }
}
