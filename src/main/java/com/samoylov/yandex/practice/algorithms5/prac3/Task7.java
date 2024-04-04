package com.samoylov.yandex.practice.algorithms5.prac3;

import java.util.*;

import static java.util.Arrays.stream;

/**
 * Задано множество, состоящее из N различных точек на плоскости.
 * Координаты всех точек — целые числа.
 * Определите, какое минимальное количество точек нужно добавить во множество,
 * чтобы нашлось четыре точки, лежащие в вершинах квадрата.
 * <p>
 * Формат ввода
 * В первой строке вводится число N (1 ≤ N ≤ 2000) — количество точек.
 * В следующих N строках вводится по два числа xi, yi (-10^8 ≤ xi, yi ≤ 10^8) — координаты точек.
 * <p>
 * Формат вывода
 * В первой строке выведите число K — минимальное количество точек, которые нужно добавить во множество.
 * В следующих K строках выведите координаты добавленных точек xi, yi через пробел.
 * Координаты должны быть целыми и не превышать 10^9 по модулю.
 * Если решений несколько — выведите любое из них.
 */
public class Task7 {
    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in)) {
            var result = new ArrayList<int[]>();
            var dotsSet = new HashSet<int[]>();
            var dotsList = new ArrayList<int[]>();
            var dotsAmount = Integer.parseInt(scanner.nextLine());
            for (var i = 0; i < dotsAmount; ++i) {
                var dot = stream(scanner.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                dotsSet.add(dot);
                dotsList.add(dot);
            }

            var dot = dotsList.get(0);
            result.add(new int[]{dot[0] + 1, dot[1]});
            result.add(new int[]{dot[0] + 1, dot[1] + 1});
            result.add(new int[]{dot[0], dot[1] + 1});

            for (var i = 0; i < dotsAmount; ++i) {
                for (var j = 0; j < dotsAmount; ++j) {
                    if (i != j) {
                        var x1 = dotsList.get(i);
                        var x2 = dotsList.get(j);
                        var dx = x2[0] - x1[0];
                        var dy = x2[1] - x1[1];
                        var x3 = new int[]{x1[0] + dy, x1[1] - dx};
                        var x4 = new int[]{x3[0] + dx, x3[1] + dy};
                        if (dotsSet.contains(x3) && dotsSet.contains(x4)) {
                            result.clear();
                        } if (result.size() > 1 && dotsSet.contains(x4)) {
                            result.clear();
                            result.add(x3);
                        } if (result.size() > 1 && dotsSet.contains(x3)) {
                            result.clear();
                            result.add(x4);
                        } if (result.size() > 2) {
                            result.clear();
                            result.add(x3);
                            result.add(x4);
                        }
                    }
                }
            }

            System.out.println(result.size());
            result.stream()
                    .map(arr -> arr[0] + " " + arr[1])
                    .forEach(System.out::println);
        }
    }
}

