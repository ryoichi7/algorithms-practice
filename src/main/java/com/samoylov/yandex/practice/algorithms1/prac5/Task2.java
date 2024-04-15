package com.samoylov.yandex.practice.algorithms1.prac5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

/**
 * B. Сумма номеров
 */
public class Task2 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var input = stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            var n = input[0];
            var target = input[1];
            var cars = stream(reader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            var result = 0;
            var prefSum = new HashSet<Integer>();
            var curSum = 0;
            for (var car : cars) {
                curSum += car;
                if (curSum == target){
                    result++;
                } else if (prefSum.contains(curSum - target)) {
                    result++;
                }
                prefSum.add(curSum);
            }
            System.out.println(result);
        }
    }
}
