package com.samoylov.yandex.practice.algorithms1.prac6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Arrays.stream;

/**
 * I. Субботник
 */
public class Task8 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var input = stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            var peopleAmount = input[0];
            var brigadesAmount = input[1];
            var brigadeSize = input[2];

            var heights = new ArrayList<Integer>();
            for (int i = 0; i < peopleAmount; i++) {
                heights.add(Integer.parseInt(reader.readLine()));
            }
            var maxDiff = getMaxDiff(heights, brigadeSize, peopleAmount, brigadesAmount);
            System.out.println(maxDiff);
        }
    }

    public static int getMaxDiff(ArrayList<Integer> heights, int brigadeSize, int peopleAmount, int brigadesAmount) {
        heights.sort(Comparator.comparingInt(Integer::intValue));

        var left = 0;
        var right = 1_000_000_000;
        var maxDiff = 0;
        while (left <= right){
            var mid = (right + left) / 2;
            var first = 0;
            var last = brigadeSize - 1;
            var brigadesCount = 0;
            while (last < peopleAmount){
                if (heights.get(last) - heights.get(first) <= mid){
                    brigadesCount++;
                    first += brigadeSize;
                    last += brigadeSize;
                } else {
                    first++;
                    last++;
                }
            }
            if (brigadesCount >= brigadesAmount){
                maxDiff = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return maxDiff;
    }
}
