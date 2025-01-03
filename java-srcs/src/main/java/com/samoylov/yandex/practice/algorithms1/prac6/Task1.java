package com.samoylov.yandex.practice.algorithms1.prac6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Arrays.stream;

/**
 * A. Двоичный поиск
 */
public class Task1 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            reader.readLine();
            var list = stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();

            var numsToFind = stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            var cache = new HashMap<Integer, Boolean>();
            for (var num : numsToFind) {
                if (cache.getOrDefault(num, false) || containsNum(list, num, cache)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    public static boolean containsNum(int[] list, int num, Map<Integer, Boolean> cache){
        var left = 0;
        var right = list.length - 1;
        while (left <= right){
            var mid = (right + left) / 2;
            if (num < list[mid]){
                right = mid - 1;
            } else if ((num > list[mid])) {
                left = mid + 1;
            } else {
                cache.put(num, true);
                return true;
            }
        }
        cache.put(num, false);
        return false;
    }
}