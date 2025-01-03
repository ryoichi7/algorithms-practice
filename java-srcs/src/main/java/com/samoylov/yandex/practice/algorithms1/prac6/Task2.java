package com.samoylov.yandex.practice.algorithms1.prac6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.stream;

/**
 * B. Приближенный двоичный поиск
 */
public class Task2 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var input = stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            var n = input[0];
            var k = input[1];
            var list = new int[n];
            var numsToFind = new int[k];
            var i = 0;
            for (var str : reader.readLine().split(" ")) {
                list[i++] = Integer.parseInt(str);
            }
            i = 0;
            for (var str : reader.readLine().split(" ")) {
                numsToFind[i++] = Integer.parseInt(str);
            }
            var cache = new HashMap<Integer, Integer>();
            for (var num : numsToFind) {
                if (cache.containsKey(num)){
                    System.out.println(cache.get(num));
                } else {
                    System.out.println(getClosestNum(list, num, cache));
                }
            }
        }
    }

    public static int getClosestNum(int[] list, int num, Map<Integer, Integer> cache){
        var left = 0;
        var right = list.length - 1;
        var mid = 0;
        while (left < right){
            mid = (right + left) / 2;
            if (num < list[mid]){
                if (right - left == 1) break;
                right = mid;
            } else if ((num > list[mid])) {
                if (right - left == 1) break;
                left = mid;
            } else {
                cache.put(num, num);
                return num;
            }
        }
        var leftNum = list[left];
        var rightNum = list[right];
        var closestNum = Integer.MAX_VALUE;

        if (num - leftNum <= rightNum - num){
            closestNum = leftNum;
        } else {
            closestNum = rightNum;
        }
        cache.put(num, closestNum);

        return closestNum;
    }
}
