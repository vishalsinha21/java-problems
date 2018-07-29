package org.vs.hackerrank.array.dynamicarray;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the dynamicArray function below.
    static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        int lastAnswer = 0;
        List<Integer> answers = new ArrayList<>();
        List<List<Integer>> sequences = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            sequences.add(new ArrayList<>());
        }

        for (int i = 0; i < queries.size(); i++) {
            List<Integer> integers = queries.get(i);
            int query = integers.get(0);
            int x = integers.get(1);
            int y = integers.get(2);
            int sequence = (x ^ lastAnswer) % n;

            if (query == 1) {
                sequences.get(sequence).add(y);
            } else {
                List<Integer> list = sequences.get(sequence);
                lastAnswer = list.get(y % list.size());
                answers.add(lastAnswer);
            }
        }

        return answers;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("temp.txt"));

        String[] nq = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nq[0]);

        int q = Integer.parseInt(nq[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = dynamicArray(n, queries);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

