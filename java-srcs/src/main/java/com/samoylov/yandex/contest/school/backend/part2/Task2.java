package com.samoylov.yandex.contest.school.backend.part2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static java.lang.Math.min;
import static java.util.Arrays.stream;

public class Task2 {
    public static class Pair implements Comparable<Pair> {
        public int day;
        public int price;

        public Pair(int day, int price) {
            this.day = day;
            this.price = price;
        }

        @Override
        public int compareTo(Pair o) {
            if (o.price != this.price) {
                return this.price - o.price;
            } else {
                return this.day - o.day;
            }
        }

        @Override
        public String toString() {
            return Integer.toString(price);
        }
    }

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var input = stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            var daysCount = input[0];
            var expiration = input[1];
            var prices = stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            var result = new ArrayList<>(Collections.nCopies(daysCount, 0));
            var overallSum = 0;

            overallSum = buyFishes(expiration, daysCount, prices, result, overallSum);

            System.out.println(overallSum);
            System.out.println(String.join(" ", result.stream()
                    .map(a -> Integer.toString(a))
                    .collect(Collectors.toList())
            ));
        }
    }

    public static int buyFishes(int expiration, int daysCount, int[] prices, ArrayList<Integer> result, int overallSum) {
        var window = new TreeSet<Pair>();
        for (int i = 0; i < expiration && i < daysCount; ++i) {
            window.add(new Pair(i, prices[i]));
        }
        var currentFishes = 0;
        for (var i = 0; i < daysCount; ++i) {
            var currentPrice = prices[i];
            var currentDay = i;
            window.removeIf(pair -> pair.day <= currentDay - expiration + 1);

            if (window.size() < expiration && currentDay + expiration <= daysCount) {
                window.add(new Pair(currentDay + expiration - 1, prices[currentDay + expiration - 1]));
            }
            var localMin = currentPrice;
            if (!window.isEmpty()) {
                localMin = window.first().price;
            }
            if (currentPrice == localMin && currentFishes < daysCount - i) {
                var fishToBuy = min(expiration - currentFishes, daysCount - i);
                result.set(i, fishToBuy);
                overallSum += currentPrice * fishToBuy;
                currentFishes += fishToBuy;
            } else {
                result.set(i, currentFishes == 0 ? 1 : 0);
                overallSum += currentPrice * (currentFishes == 0 ? 1 : 0);
                currentFishes += currentFishes == 0 ? 1 : 0;
            }
            currentFishes--;
        }
        return overallSum;
    }
}