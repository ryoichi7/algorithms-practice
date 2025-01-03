package com.samoylov.yandex.practice.algorithms5.prac3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.min;
import static java.util.Arrays.stream;

/**
 * Дан массив a из n чисел.
 * Найдите минимальное количество чисел,
 * после удаления которых попарная разность оставшихся чисел по модулю не будет превышать 1,
 * то есть после удаления ни одно число не должно отличаться от какого-либо другого более чем на 1.
 * <p>
 * <p>
 * Пример 1
 * Ввод:
 * 5
 * 1 2 3 4 5
 * Вывод:
 * 3
 * Пример 2
 * Ввод:
 * 10
 * 1 1 2 3 5 5 2 2 1 5
 * Вывод:
 * 4
 */
public class Task3 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var arrayLength = Integer.parseInt(reader.readLine());
            var array = new ArrayList<Integer>(stream(reader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .toList());

            var result = getResult(array, arrayLength);

            System.out.println(result);
        }
    }

    public static int getResult(List<Integer> array, int arrayLength) {
        var numberOccurrences = new HashMap<Integer, Integer>();
        for (var element : array) {
            numberOccurrences.put(element, numberOccurrences.getOrDefault(element, 0) + 1);
        }
        var sortedEntries = numberOccurrences.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .toList();
        var maxAmount = 0;
        if (sortedEntries.size() > 2) {
            for (int i = 0; i < sortedEntries.size() - 1; ++i) {
                var left = sortedEntries.get(i);
                var right = sortedEntries.get(i + 1);
                if (right.getKey() - left.getKey() == 1) {
                    var curAmount = left.getValue() + right.getValue();
                    maxAmount = Math.max(maxAmount, curAmount);
                }
            }
            if (maxAmount == 0){
                return arrayLength - sortedEntries.stream().max(Map.Entry.comparingByValue()).get().getValue();
            }
            return arrayLength - maxAmount;
        }
        if (sortedEntries.size() == 2) {
            var first = sortedEntries.get(0);
            var last = sortedEntries.get(1);
            if (last.getKey() - first.getKey() == 1) {
                return 0;
            }
            return min(first.getValue(), last.getValue());
        } else {
            return 0;
        }
    }
}
