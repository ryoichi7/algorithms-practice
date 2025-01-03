package com.samoylov.yandex.practice.algorithms1.prac3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Arrays.stream;

public class Task10 {

    public static class Dot {
        public int x;
        public int y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Dot dot = (Dot) o;
            return x == dot.x && y == dot.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var input = stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            var t = input[0];
            var d = input[1];
            var n = input[2];
            var prevDots = new HashSet<Dot>();
            prevDots.add(new Dot(0, 0));

            Set<Dot> tOffsets = generateOffsets(t);
            Set<Dot> dOffsets = generateOffsets(d);


            for (int i = 0; i < n; ++i) {
                var dotInput = stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
                var radarDot = new Dot(dotInput[0], dotInput[1]);
                var possibleDots = applyOffsets(radarDot, dOffsets);
                var newPossibleDots = new HashSet<Dot>();

                for (var dot : prevDots) {
                    newPossibleDots.addAll(applyOffsets(dot, tOffsets));
                }

                newPossibleDots.retainAll(possibleDots);

                prevDots = new HashSet<>(newPossibleDots);
            }
            System.out.println(prevDots.size());
            prevDots.forEach(System.out::println);
        }
    }
    public static Set<Dot> generateOffsets(int maxDistance) {
        Set<Dot> offsets = new HashSet<>();
        for (int dx = -maxDistance; dx <= maxDistance; dx++) {
            for (int dy = -maxDistance; dy <= maxDistance; dy++) {
                if (Math.abs(dx) + Math.abs(dy) <= maxDistance) {
                    offsets.add(new Dot(dx, dy));
                }
            }
        }
        return offsets;
    }

    public static Set<Dot> applyOffsets(Dot currentDot, Set<Dot> offsets) {
        Set<Dot> resultDots = new HashSet<>();
        for (Dot offset : offsets) {
            resultDots.add(new Dot(currentDot.x + offset.x, currentDot.y + offset.y));
        }
        return resultDots;
    }
}
