package com.samoylov.yandex.practice.algorithms5.prac2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.Math.max;
import static java.util.Arrays.stream;

public class Task6 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var rouletteLength = parseInt(reader.readLine());
            var roulette = stream(reader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .toList();
            var input = stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            var maxJackpot = getMaxJackpot(input, roulette, rouletteLength);

            System.out.println(maxJackpot);
        }
    }

    public static int getMaxJackpot(int[] input, List<Integer> roulette, int rouletteLength) {
        var entries = new HashSet<Integer>();
        var a = input[0];
        var b = input[1];
        var k = input[2];

        var maxJackpot = 0;

        for (int i = a; i <= b; i += k){
            if (entries.size() == rouletteLength){
                break;
            }
            int clockwiseIndex;
            int counterclockwiseIndex;
            if (i % k == 0){
                clockwiseIndex = ((i / k) - 1) % rouletteLength;
            } else {
                clockwiseIndex = (i / k) % rouletteLength;
            }
            counterclockwiseIndex = clockwiseIndex != 0 ? rouletteLength - clockwiseIndex : 0;
            entries.add(clockwiseIndex);
            entries.add(counterclockwiseIndex);
            maxJackpot = max(roulette.get(clockwiseIndex), maxJackpot);
            maxJackpot = max(roulette.get(counterclockwiseIndex), maxJackpot);
        }
        return maxJackpot;
    }
}
