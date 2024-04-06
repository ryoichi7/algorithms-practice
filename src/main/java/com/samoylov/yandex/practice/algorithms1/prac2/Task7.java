package com.samoylov.yandex.practice.algorithms1.prac2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Task7 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var nums = stream(reader.readLine().split(" "))
                    .map(Long::parseLong)
                    .collect(Collectors.toList());
            var maxPositive = new ArrayList<Long>(List.of(0L, 0L)); // max[0] > max[1]
            var maxNegative = new ArrayList<Long>(List.of(0L, 0L)); //max[0] < max[1]

            if (nums.size() == 2) {
                System.out.println(nums.stream()
                        .sorted()
                        .map(a -> Long.toString(a))
                        .collect(Collectors.joining(" ")));
                return;
            }
            for (int i = 0; i < nums.size(); ++i) {
                var num = nums.get(i);
                if (num > maxPositive.get(0)) {
                    maxPositive.set(1, maxPositive.get(0));
                    maxPositive.set(0, num);
                } else if (num > maxPositive.get(1)) {
                    maxPositive.set(1, num);
                }
                if (num < maxNegative.get(0)) {
                    maxNegative.set(1, maxNegative.get(0));
                    maxNegative.set(0, num);
                } else if (num < maxNegative.get(1)) {
                    maxNegative.set(1, num);
                }
            }
            if (maxPositive.get(0) * maxPositive.get(1) >
                maxNegative.get(0) * maxNegative.get(1)) {
                System.out.println(maxPositive.get(1) + " " + maxPositive.get(0));
            } else {
                System.out.println(maxNegative.get(0) + " " + maxNegative.get(1));
            }
        }
    }
}
