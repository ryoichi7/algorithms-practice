package com.samoylov.yandex.practice.algorithms5.prac3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import static java.util.Arrays.stream;

/**
 * Вам дана последовательность измерений некоторой величины.
 * Требуется определить, повторялась ли какое-либо число,
 * причём расстояние между повторами не превосходило k.
 * <p>
 * Формат ввода
 * В первой строке задаются два числа n и k (1 ≤ n, k ≤ 105).
 * Во второй строке задаются n чисел, по модулю не превосходящих 109.
 * <p>
 * Формат вывода
 * Выведите YES, если найдется повторяющееся число и расстояние между повторами не превосходит k и NO в противном случае.
 */
public class Task4 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var input = stream(reader.readLine()
                    .split(" "))
                    .map(Integer::parseInt)
                    .mapToInt(Integer::intValue)
                    .toArray();
            var numbersCount = input[0];
            var range = input[1];
            var numbers = new ArrayList<Integer>(
                    stream(reader.readLine().split(" "))
                            .map(Integer::parseInt)
                            .toList());
            if (hasPair(numbers, numbersCount, range)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean hasPair(ArrayList<Integer> numbers, int numbersCount, int range) {
        var numberOccurrence = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbersCount; ++i) {
            var currentNumber = numbers.get(i);
            var mayBePairIndex = numberOccurrence.get(currentNumber);
            if (mayBePairIndex != null && i - mayBePairIndex <= range) {
                return true;
            }
            numberOccurrence.put(currentNumber, i);
        }
        return false;
    }
}
