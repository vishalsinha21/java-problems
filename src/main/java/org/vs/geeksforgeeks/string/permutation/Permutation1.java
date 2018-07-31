package org.vs.geeksforgeeks.string.permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permutation1 {

    public static void main(String[] args) {
        printPermutations("ABCD");
    }

    private static void printPermutations(String str) {
        List<String> list = new ArrayList<>();
        list.add(str.substring(0, 1));

        for (int index = 1; index < str.length(); index++) {
            list = insertAtAllPositions(list, str.substring(index, index + 1));
        }

        Collections.sort(list);
        System.out.println(list);

    }

    private static List<String> insertAtAllPositions(List<String> list, String newChar) {
        List<String> newList = new ArrayList<>();
        for (String str : list) {
            for (int i = 0; i <= str.length(); i++) {
                newList.add(insert(str, newChar, i));
            }
        }
        return newList;
    }

    private static String insert(String str, String newChar, int position) {
        return new StringBuilder((str))
                .insert(position, newChar).toString();
    }


}
