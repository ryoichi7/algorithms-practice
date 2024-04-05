package com.samoylov.yandex.practice.algorithms1.prac2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import static java.lang.Math.abs;
import static java.util.Arrays.stream;

public class Task3 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var size = Integer.parseInt(reader.readLine());
            var numbers = stream(reader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            var target = Integer.parseInt(reader.readLine());
            var bestNumber = numbers.get(0);
            for (var i = 1; i < numbers.size(); ++i) {
                var num = numbers.get(i);
                if (abs(target - num) < abs(target - bestNumber)){
                    bestNumber = num;
                }
            }
            System.out.println(bestNumber);
        }
    }
}
