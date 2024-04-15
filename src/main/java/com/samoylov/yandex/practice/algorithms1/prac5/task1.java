package com.samoylov.yandex.practice.algorithms1.prac5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.abs;
import static java.util.Arrays.stream;

/**
 * A. Стильная одежда
 */
public class task1 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var n = Integer.parseInt(reader.readLine());
            var shirts = stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            var m = Integer.parseInt(reader.readLine());
            var shorts = stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            var leftShirts = 0;
            var rightShirts = n - 1;
            var leftShorts = 0;
            var rightShorts = m - 1;
            var pair = new int[2];
            var minDiff = Integer.MAX_VALUE;
            while (leftShirts <= rightShirts && leftShorts <= rightShorts){
                var curShirt = shirts[leftShirts];
                var curShorts = shorts[leftShorts];
                var curDiff = abs(curShirt - curShorts);
                if (curDiff < minDiff){
                    minDiff = curDiff;
                    pair[0] = curShirt;
                    pair[1] = curShorts;
                }
                if (curShirt < curShorts){
                    leftShirts++;
                } else {
                    leftShorts++;
                }
            }
            System.out.println(pair[0] + " " + pair[1]);
        }
    }
}
