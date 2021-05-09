package org.vs.others;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    public static void main(String[] args) {
        List<String> operation = new ArrayList();
        operation.add("push");
        operation.add("push");
        operation.add("push");
        operation.add("pop");

        List<Integer> integers = new ArrayList();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(1);

        List<Long> result = maxMin(operation, integers);

        System.out.println(result);
    }

    public static List<Long> maxMin(List<String> operations, List<Integer> list) {
        List<Long> result = new ArrayList<>();

        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((x, y) -> Integer.compare(y, x));

        for (int i = 0; i < operations.size(); i++) {

            String ops = operations.get(i);
            Integer integer = list.get(i);

            if (ops.equals("push")) {
                minQueue.add(integer);
                maxQueue.add(integer);
            } else {
                minQueue.remove(integer);
                maxQueue.remove(integer);
            }

            Integer min = minQueue.peek();
            Integer max = maxQueue.peek();

            Long product = Long.valueOf(min) * Long.valueOf(max);
            result.add(product);
        }

        return result;
    }


}
