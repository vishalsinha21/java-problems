package org.vs.hackerrank;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindUnique {

    public static int lonelyinteger(List<Integer> a) {
        Set<Integer> sett = new HashSet();
        for (Integer i: a) {
            if (sett.contains(i)) {
                sett.remove(i);
            } else {
                sett.add(i);
            }
        }

        return sett.stream().findFirst().get();
    }

}
