package com.samoylov.yandex.practice.algorithms1.prac3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Task2 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var set1 = new HashSet<>(
                    stream(reader.readLine().split(" "))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList()));
            var set2 = new HashSet<>(
                    stream(reader.readLine().split(" "))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList()));

            var resultSet = new TreeSet<Integer>();
            for (var el : set1.size() < set2.size() ? set1 : set2) {
                if (set1.contains(el) && set2.contains(el)) {
                    resultSet.add(el);
                }
            }
            System.out.println(String.join(" ", resultSet.stream()
                    .map(a -> Integer.toString(a))
                    .collect(Collectors.toList())));
        }
    }
}
