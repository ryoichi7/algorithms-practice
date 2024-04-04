package com.samoylov.yandex.practice.algorithms5.prac2;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Math.max;
import static java.util.Arrays.stream;

public class Task2 {
    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in)) {
            var input = stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            var prices = stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            var daysAmount = input[0];
            var k = input[1];
            var buff = new ArrayList<Integer>();
            var maxIncome = 0;
            buff.add(prices[0]);
            for (var i = 1; i < daysAmount; ++i) {
                var curPrice = prices[i];
                maxIncome = max(curPrice - buff.stream().min(Integer::compareTo).get(), maxIncome);
                if (buff.size() < k){
                    buff.add(curPrice);
                } else {
                    buff.set(i % k, curPrice);
                }
            }
            System.out.println(maxIncome);
        }
    }
}
