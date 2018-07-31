package org.vs.geeksforgeeks.string.permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Permutation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            String str = scanner.next();
            printPermutations(str);
            System.out.println();
        }

    }

    private static void printPermutations(String str) {
        List<String> list = new ArrayList<>();
        list.add(str.substring(0, 1));

        while (true) {
            String s = list.get(0);
            if (s.length() == str.length()) {
                break;
            }
            list.addAll(insertAtAllPositions(s, str.substring(s.length(), s.length() + 1)));
            list.remove(0);
        }

        Collections.sort(list);
        list.stream().forEach(s -> System.out.print(s + " "));
    }

    private static List<String> insertAtAllPositions(String str, String newChar) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i <= str.length(); i++) {
            list.add(insert(str, newChar, i));
        }
        return list;
    }

    private static String insert(String str, String newChar, int position) {
        return new StringBuilder((str))
                .insert(position, newChar).toString();
    }


}
