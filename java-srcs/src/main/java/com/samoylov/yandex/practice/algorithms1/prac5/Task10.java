package com.samoylov.yandex.practice.algorithms1.prac5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import static java.util.Arrays.stream;

/**
 * J. Треугольники
 */
public class Task10 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var n = Integer.parseInt(reader.readLine());
            var dots = new ArrayList<Pair>(n);
            for (var i = 0; i < n; i++) {
                var input = stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                dots.add(new Pair(input[0], input[1]));
            }
            var result = findTriangles(dots);
            System.out.println(result);
        }
    }

    public static long findTriangles(ArrayList<Pair> dots) {
        long result = 0L;
        for (int i = 0; i < dots.size(); i++) {
            var dot = dots.get(i);
            var edges = new ArrayList<Map.Entry<Integer, Pair>>();
            for (int j = 0; j < dots.size(); j++){
                if (i != j){
                    var newDot = dots.get(j);
                    var edge = (newDot.x - dot.x) * (newDot.x - dot.x) + (newDot.y - dot.y) * (newDot.y - dot.y);
                    edges.add(Map.entry(edge, newDot));
                }
            }
            edges.sort(Comparator.comparingInt(Map.Entry::getKey));
            var entries = new ArrayList<>(edges);
            var left = 0;
            var right = 0;
            var leftEntry = entries.get(left);
            var dotsSet = new HashSet<Pair>();
            var badTriangles = 0;
            while (left < entries.size()){
                var edgesCount = 0;
                leftEntry = entries.get(left);
                while (right < entries.size() && leftEntry.getKey().equals(entries.get(right).getKey())){
                    var rightEntry = entries.get(right);
                    var x1y1 = rightEntry.getValue();
                    var x2y2 = new Pair(x1y1.x - (x1y1.x - dot.x) * 2, x1y1.y - (x1y1.y - dot.y) * 2);
                    if (dotsSet.contains(x2y2)){
                        badTriangles++;
                    }
                    edgesCount++;
                    dotsSet.add(x1y1);
                    right++;
                }
                result += (edgesCount * (edgesCount - 1L)) / 2L;
                left = right;
            }
            result -= badTriangles;
        }
        return result;
    }

    public static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
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
}
