package com.samoylov.yandex.practice.algorithms1.prac7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;

/**
 * B. Точки и отрезки
 */
public class Task2 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var input = stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            var segmentsCnt = input[0];
            var dotsCnt = input[1];
            var tips = new ArrayList<Dot>();
            for (int i = 0; i < segmentsCnt; i++) {
                var segment = stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                tips.add(new Dot(segment[0], 0));
                tips.add(new Dot(segment[1], 1));
            }
            tips.sort((a, b) -> {
                if (a.val != b.val) {
                    return a.val - b.val;
                }
                return a.type - b.type;
            });
            var dots = stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (var dot : dots) {
                System.out.print(countSegments(tips, dot) + " ");
            }
        }
    }

    private static int countSegments(List<Dot> dots, int dot) {
        var curSegments = 0;
        int i = 0;
        while (i < dots.size() && dots.get(i).val < dot) {
            if (dots.get(i).type == 0) {
                curSegments++;
            } else {
                curSegments--;
            }
            i++;
        }

        while (i < dots.size() && dots.get(i).val == dot) {
            if (dots.get(i).type == 0) {
                curSegments++;
            }
            i++;
        }

        return curSegments;
    }

    public static class Dot {
        public int val;
        public int type;

        public Dot(int val, int type) {
            this.val = val;
            this.type = type;
        }
    }
}
