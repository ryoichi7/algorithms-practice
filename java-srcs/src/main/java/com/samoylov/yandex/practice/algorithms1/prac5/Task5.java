package com.samoylov.yandex.practice.algorithms1.prac5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import static java.util.Arrays.stream;

/**
 * E. Красота превыше всего
 */
public class Task5 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var input = stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            var n = input[0];
            var k = input[1];
            var integers = stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            var best = getMinSubSeq(integers, n, k);
            System.out.println(best[0] + " " + best[1]);
        }
    }

    public static int[] getMinSubSeq(int[] integers, int n, int k) {
        if (k == 1 || n == 1) {
            return new int[] {1, 1};
        }
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int bestLeft = 0, bestRight = 0;
        HashMap<Integer, Integer> trees = new HashMap<>();

        while (right < n) {
            while (trees.size() < k && right < n) {
                trees.put(integers[right], trees.getOrDefault(integers[right], 0) + 1);
                right++;
            }
            while (trees.size() == k) {
                int currentLength = right - left;
                if (currentLength < minLength) {
                    minLength = currentLength;
                    bestLeft = left;
                    bestRight = right - 1;
                }
                trees.put(integers[left], trees.get(integers[left]) - 1);
                if (trees.get(integers[left]) == 0) {
                    trees.remove(integers[left]);
                }
                left++;
            }
        }

        return new int[] {bestLeft + 1, bestRight + 1};
    }


//    public static int[] getMinSubSeq(int[] integers, int n, int k) {
//        if (k == 1 || n == 1){
//            return new int[] {1, 1};
//        }
//        var left = 0;
//        var right = 1;
//        var minLength = Integer.MAX_VALUE;
//        var bestLeft = left;
//        var bestRight = right;
//        var trees = new HashMap<Integer, Integer>();
//        trees.put(integers[left], 1);
//        while (left < n - k + 1){
//            var wasRightLooped = false;
//            while (trees.size() != k && right < n){
//                trees.put(integers[right], trees.getOrDefault(integers[right], 0) + 1);
//                right++;
//                wasRightLooped = true;
//            }
//            if (wasRightLooped){
//                right--; // make right point to the current right element (for length calculations before next nested while loop)
//            }
//            if (trees.size() == k){
//                var curLength = right - left + 1;
//                if (curLength < minLength){
//                    minLength = curLength;
//                    bestRight = right;
//                    bestLeft = left;
//                }
//            }
//            var leftTreeCount = trees.get(integers[left]);
//            if (leftTreeCount == 1){
//                trees.remove(integers[left]); // this will cause nested while loop in next iteration
//                right++; // make right point to the element after the current right element (for next while loop)
//            } else {
//                trees.put(integers[left], leftTreeCount - 1);
//            }
//            left++;
//        }
//        return new int[]{bestLeft + 1, bestRight + 1};
//    }
}
