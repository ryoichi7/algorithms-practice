package com.samoylov.yandex.practice.algorithms1.prac5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.util.Arrays.stream;

/**
 * D. Город Че
 */
public class Task4 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var input = stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            var n = input[0];
            var r = input[1];

            var ranges = stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            var result = getPair(n, ranges, r);
            System.out.println(result);
        }
    }

    private static long getPair(int n, int[] ranges, int r) {
        long result = 0;

        var left = 0;
        var right = left + 1;
        while(left < n - 1){
            while (right < n - 1 && ranges[left] + r >= ranges[right]){
                ++right;
            }
            if (ranges[left] + r < ranges[right]) {
                result += n - right;
            }
            ++left;
        }
        return result;
    }
}