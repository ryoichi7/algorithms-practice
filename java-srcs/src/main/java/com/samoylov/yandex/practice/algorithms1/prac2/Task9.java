package com.samoylov.yandex.practice.algorithms1.prac2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.stream;

public class Task9 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var input = stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            var rows = input[0];
            var cols = input[1];
            var mines = input[2];

            List<List<Integer>> field = IntStream.range(0, rows)
                    .mapToObj(r -> IntStream.range(0, cols)
                            .mapToObj(c -> 0)
                            .collect(Collectors.toList()))
                    .collect(Collectors.toList());

            for (int i = 0; i < mines; ++i) {
                var coords = stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                var row = coords[0] - 1;
                var col = coords[1] - 1;
                countMine(row - 1, col - 1, field); //topLeft
                countMine(row - 1, col, field); //top
                countMine(row - 1, col + 1, field); //topRight
                countMine(row, col - 1, field); //left
                field.get(row).set(col, Integer.MIN_VALUE);
                countMine(row, col + 1, field); //right
                countMine(row + 1, col - 1, field); //botLeft
                countMine(row + 1, col, field); //bot
                countMine(row + 1, col + 1, field); //botRight
            }
            field.stream()
                    .map(row -> row.stream()
                            .map(el -> {
                                if (el < 0) {
                                    return "*";
                                } else {
                                    return Integer.toString(el);
                                }
                            })
                            .collect(Collectors.toList())
                    )
                    .forEach(row -> System.out.println(String.join(" ", row)));
        }
    }

    private static void countMine(int row, int col, List<List<Integer>> field) {
        if (row >= 0 && row < field.size() && col >= 0 && col < field.get(0).size()) {
            var rowList = field.get(row);
            rowList.set(col, rowList.get(col) + 1);
        }
    }
}
