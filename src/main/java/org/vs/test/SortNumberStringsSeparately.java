package org.vs.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortNumberStringsSeparately {

    public static void main(String[] args) {
        List<String> list = List.of("Cat", "2", "apple", "5", "3");

        List<Integer> intList = new ArrayList<>();
        List<String> strList = new ArrayList<>();
        List<String> result = new ArrayList<>();

        boolean[] arr = new boolean[list.size()];

        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);

            if (isNumeric(str)) {
                intList.add(Integer.valueOf(str));
                arr[i] = true;
            } else {
                strList.add(str);
                arr[i] = false;
            }
        }

        Collections.sort(intList);
        Collections.sort(strList, Collections.reverseOrder());

        int intIndex = 0;
        int strIndex = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i]) {
                result.add(String.valueOf(intList.get(intIndex)));
                intIndex++;
            } else {
                result.add(strList.get(strIndex));
                strIndex++;
            }
        }

        System.out.println(result);
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.valueOf(str);
        } catch (NumberFormatException ex) {
            return false;
        }

        return true;
    }
}
