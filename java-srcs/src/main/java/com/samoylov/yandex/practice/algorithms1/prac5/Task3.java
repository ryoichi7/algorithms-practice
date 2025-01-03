package com.samoylov.yandex.practice.algorithms1.prac5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;

/**
 * C. Туризм
 */
public class Task3 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var n = Integer.parseInt(reader.readLine());
            var points = new ArrayList<Integer>();
            for (int i = 0; i < n; ++i) {
                var input = stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                points.add(input[1]);
            }
            var curSum = 1;
            var curReversedSum = 0;
            var roads = new ArrayList<Integer>(n);
            var reversedRoads = new ArrayList<Integer>(n);
            roads.add(1);
            reversedRoads.add(0);
            for (var i = 0; i < n - 1; ++i) {
                var from = points.get(i);
                var to = points.get(i + 1);
                if (to - from > 0) {
                    curSum += to - from;
                    roads.add(curSum);
                    reversedRoads.add(curReversedSum);
                } else {
                    curReversedSum += Math.abs(to - from);
                    reversedRoads.add(curReversedSum);
                    roads.add(curSum);
                }
            }
            var m = Integer.parseInt(reader.readLine());
            for (var i = 0; i < m; ++i) {
                var input = stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                var sum = getSum(input, roads, reversedRoads);
                System.out.println(sum);
            }
        }
    }

    private static int getSum(int[] input, List<Integer> roads, List<Integer> reversedRoads) {
        var from = input[0] - 1;
        var to = input[1] - 1;
        var sum = 0;
        if (from < to) {
            sum = roads.get(to) - roads.get(from);
        } else if (from > to) {
            sum = reversedRoads.get(from) - reversedRoads.get(to);
        }
        return sum;
    }
}
