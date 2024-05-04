package com.samoylov.yandex.contest.backend;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task2 {

    private static int binarySearch(String pref, ArrayList<String> dictionary) {
        var left = 0;
        var right = dictionary.size() - 1;
        while (left <= right) {
            var mid = (left + right) / 2;
            var str = dictionary.get(mid);
            if (!str.startsWith(pref)) {
                if (pref.compareTo(str) >= 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (mid == left) {
                    return mid;
                }
                var prevStr = dictionary.get(mid - 1);
                if (!prevStr.startsWith(pref)) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int autocomplete(int k, String pref, ArrayList<String> dictionary) {
        var start = binarySearch(pref, dictionary);
        if (start != -1) {
            var finish = start + k - 1;
            if (finish < dictionary.size() && dictionary.get(finish).startsWith(pref)) {
                return finish + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var input = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            var n = input[0];
            var q = input[1];

            var dictionary = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                dictionary.add(reader.readLine());
            }

            for (int i = 0; i < q; i++) {
                var request = reader.readLine().split(" ");
                var k = Integer.parseInt(request[0]);
                var pref = request[1];
                var result = autocomplete(k, pref, dictionary);
                System.out.println(result);
            }
        }
    }
}