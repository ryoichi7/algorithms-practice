package com.samoylov.yandex.practice.algorithms5.prac2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task8 {

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var input = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            var rows = input[0];
            var columns = input[1];

            List<List<Integer>> matrix = new ArrayList<>();

            for (int i = 0; i < rows; i++) {
                matrix.add(new ArrayList<>(Arrays.stream(reader.readLine().split(" "))
                        .map(Integer::parseInt)
                        .toList()));
            }

            var maxRowSum = 0;
            var rowToRemove = 0;
            for (int i = 0; i < rows; i++) {
                var sum = matrix.get(i).stream()
                        .reduce(0, Integer::sum);
                if (sum > maxRowSum){
                    maxRowSum = sum;
                    rowToRemove = i;
                }
            }
            matrix.remove(rowToRemove);

            var maxColumnSum = 0;
            var columnToRemove = 0;
            for (int col = 0; col < columns; col++) {
                var sum = 0;
                for (int row = 0; row < rows - 1; row++){
                    sum += matrix.get(row).get(col);
                }
                if (sum > maxColumnSum){
                    maxColumnSum = sum;
                    columnToRemove = col;
                }
            }
            System.out.println((rowToRemove + 1) + " " + (columnToRemove + 1));
        }
    }
}
