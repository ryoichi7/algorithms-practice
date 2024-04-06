package com.samoylov.yandex.practice.algorithms1.prac2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Task8 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var nums = stream(reader.readLine().split(" "))
                    .map(Long::parseLong)
                    .collect(Collectors.toList());
            var maxPositive = new ArrayList<Long>(List.of(Long.MIN_VALUE, Long.MIN_VALUE, Long.MIN_VALUE));
            var minNegative = new ArrayList<Long>(List.of(0L, 0L));
            if (nums.size() == 3) {
                System.out.println(nums.stream()
                        .sorted()
                        .map(a -> Long.toString(a))
                        .collect(Collectors.joining(" ")));
                return;
            }
            for (int i = 0; i < nums.size(); ++i) {
                var num = nums.get(i);
                if (num < 0) {
                    setMinNegative(num, minNegative);
                } else {
                    setMaxPositive(num, maxPositive);
                }
            }
            var positiveProduct = maxPositive.get(0) * maxPositive.get(1) * maxPositive.get(2);
            var negativeWithPositiveProduct = maxPositive.get(0) * minNegative.get(0) * minNegative.get(1);

            var hasEnoughPositives = maxPositive.stream()
                                             .filter(a -> a >= 0)
                                             .count() == maxPositive.size();

            if (positiveProduct >= negativeWithPositiveProduct && hasEnoughPositives) {
                System.out.println(maxPositive.get(2) + " " + maxPositive.get(1) + " " + maxPositive.get(0));
            } else {
                System.out.println(minNegative.get(0) + " " + minNegative.get(1) + " " + maxPositive.get(0));
            }
        }
    }
    private static void setMinNegative(Long num, ArrayList<Long> maxNegative) {
        if (num < maxNegative.get(0)) {
            maxNegative.set(1, maxNegative.get(0));
            maxNegative.set(0, num);
        } else if (num < maxNegative.get(1)) {
            maxNegative.set(1, num);
        }
    }

    private static void setMaxPositive(Long num, ArrayList<Long> maxPositive) {
        if (num > maxPositive.get(0)) {
            maxPositive.set(2, maxPositive.get(1));
            maxPositive.set(1, maxPositive.get(0));
            maxPositive.set(0, num);
        } else if (num > maxPositive.get(1)) {
            maxPositive.set(2, maxPositive.get(1));
            maxPositive.set(1, num);
        } else if (num > maxPositive.get(2)) {
            maxPositive.set(2, num);
        }
    }
}