package com.samoylov.yandex.practice.algorithms1.prac6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

/**
 * J. Медиана объединения
 */
public class Task9 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var input = stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            var n = input[0];
            var l = input[1];
            List<List<Integer>> sequences = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                var seq = stream(reader.readLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                sequences.add(seq);
            }
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++){
                    var seq1 = sequences.get(i);
                    var seq2 = sequences.get(j);
                    var seq = new ArrayList<Integer>(l * 2);
                    seq.addAll(seq1);
                    seq.addAll(seq2);
                    seq.sort(Comparator.comparingInt(Integer::intValue));
                    System.out.println(seq.get(l - 1));
                }
            }
        }
    }
}
