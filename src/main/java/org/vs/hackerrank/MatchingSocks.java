package org.vs.hackerrank;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//Problem link: https://www.hackerrank.com/challenges/sock-merchant/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
public class MatchingSocks {

    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        Map<Integer, Long> map = ar.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return (int) map.values().stream().mapToLong(v -> v / 2).sum();
    }
}
