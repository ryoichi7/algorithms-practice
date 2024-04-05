package com.samoylov.yandex.practice.algorithms1.prac2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Task4 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var numbers = stream(reader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            var result = 0;
            for (var i = 1; i < numbers.size() - 1; ++i) {
                var left = numbers.get(i - 1);
                var mid = numbers.get(i);
                var right = numbers.get(i + 1);
                if (mid > left && mid > right) {
                    result++;
                }
            }
            System.out.println(result);
        }
    }
}
