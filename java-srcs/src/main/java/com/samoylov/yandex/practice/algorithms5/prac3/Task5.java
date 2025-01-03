package com.samoylov.yandex.practice.algorithms5.prac3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Arrays.stream;

/**
 * Вам даны три списка чисел. Найдите все числа,
 * которые встречаются хотя бы в двух из трёх списков.
 * <p>
 * Формат ввода
 * Во входных данных описывается три списка чисел.
 * Первая строка каждого описания списка состоит из длины списка n (1 ≤ n ≤ 1000).
 * Вторая строка описания содержит список натуральных чисел, записанных через пробел.
 * Числа не превосходят 10^9.
 * <p>
 * Формат вывода
 * Выведите все числа, которые содержатся хотя бы в двух списках из трёх, в порядке возрастания.
 * Обратите внимание, что каждое число необходимо выводить только один раз.
 */
public class Task5 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var numberOccurrences = new HashMap<Integer, int[]>();
            for (var i = 0; i < 3; i++) {
                reader.readLine();
                var finalI = i;
                Arrays.stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .forEach(num -> numberOccurrences.computeIfAbsent(num, k -> new int[3])[finalI] = 1);
            }
            var result = String.join(" ", numberOccurrences.entrySet()
                    .stream()
                    .filter(entry -> stream(entry.getValue()).sum() > 1)
                    .map(Map.Entry::getKey)
                    .map(Object::toString)
                    .toList());
            System.out.println(result);
        }
    }
}
