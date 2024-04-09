package com.samoylov.yandex.practice.algorithms1.prac3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.util.Arrays.stream;

public class Task10v2 {

    public static int MAX_X_SUB_Y = 0; //MAX Y'
    public static int MIN_X_SUB_Y = 1; //MIN Y'
    public static int MAX_X_ADD_Y = 2; //MAX X'
    public static int MIN_X_ADD_Y = 3; //MIN X'

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var input = stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            var t = input[0];
            var d = input[1];
            var n = input[2];

            List<Integer> prevRect = new ArrayList<Integer>(List.of(0, 0, 0, 0));
            for (var i = 0; i < n; ++i) {
                extend(prevRect, t);
                var point = stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
                // convert to flat y' = x - y; x' = x + y
                var curRect = extend(new ArrayList<Integer>(List.of(
                                point[0] - point[1],
                                point[0] - point[1],
                                point[0] + point[1],
                                point[0] + point[1])),
                        d);
                prevRect = intersect(prevRect, curRect);
            }

            var result = getPointsList(prevRect);
            System.out.println(result.size());
            result.forEach(System.out::println);
        }
    }

    public static List<String> getPointsList(List<Integer> resultRect) {
        List<String> result = new ArrayList<>();
        var maxYPrime = resultRect.get(0);
        var minYPrime = resultRect.get(1);
        var maxXPrime = resultRect.get(2);
        var minXPrime = resultRect.get(3);

        for (int xPrime = minXPrime; xPrime <= maxXPrime; xPrime++) {
            for (int yPrime = minYPrime; yPrime <= maxYPrime; yPrime++) {
                // convert back to x,y
                if ((xPrime + yPrime) % 2 == 0) {
                    var x = (xPrime + yPrime) / 2;
                    var y = (xPrime - yPrime) / 2;
                    result.add(String.format("%d %d", x, y));
                }
            }
        }
        return result;
    }

    public static List<Integer> extend(List<Integer> rectangle, int t) {
        rectangle.set(MAX_X_SUB_Y, rectangle.get(MAX_X_SUB_Y) + t);
        rectangle.set(MIN_X_SUB_Y, rectangle.get(MIN_X_SUB_Y) - t);
        rectangle.set(MAX_X_ADD_Y, rectangle.get(MAX_X_ADD_Y) + t);
        rectangle.set(MIN_X_ADD_Y, rectangle.get(MIN_X_ADD_Y) - t);
        return rectangle;
    }

    public static List<Integer> intersect(List<Integer> rectangle1, List<Integer> rectangle2) {
        List<Integer> rectangle = new ArrayList<>();
        rectangle.add(min(rectangle1.get(MAX_X_SUB_Y), rectangle2.get(MAX_X_SUB_Y)));
        rectangle.add(max(rectangle1.get(MIN_X_SUB_Y), rectangle2.get(MIN_X_SUB_Y)));
        rectangle.add(min(rectangle1.get(MAX_X_ADD_Y), rectangle2.get(MAX_X_ADD_Y)));
        rectangle.add(max(rectangle1.get(MIN_X_ADD_Y), rectangle2.get(MIN_X_ADD_Y)));
        return rectangle;
    }
}
