package org.vs.hackerrank;

import java.util.HashSet;
import java.util.List;

//https://www.hackerrank.com/challenges/pairs/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=search

/*
Given an array of integers and a target value, determine the number of pairs of array elements that have a difference equal to the target value.

STDIN       Function
-----       --------
5 2         arr[] size n = 5, k =2
1 5 3 4 2   arr = [1, 5, 3, 4, 2]

There are 3 pairs of integers in the set with a difference of 2: [5,3], [4,2] and [3,1]. .
*/

public class PairDiff {

    public static int pairs(int k, List<Integer> arr) {
        HashSet<Integer> set = new HashSet();
        int count = 0;

        for (int i = 0; i < arr.size(); i++) {
            int num = arr.get(i);

            //The main catch here is that you have 2 look for 2 numbers which can result in the difference
            int diff1 = num + k;
            int diff2 = num - k;

            if (set.contains(diff1)) {
                count++;
            }
            if (set.contains(diff2)) {
                count++;
            }

            set.add(num);
        }

        return count;
    }
}
