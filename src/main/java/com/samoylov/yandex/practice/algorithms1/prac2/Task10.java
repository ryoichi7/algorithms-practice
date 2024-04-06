package com.samoylov.yandex.practice.algorithms1.prac2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.max;
import static java.lang.Math.min;

/*
    if (cur < prev && closer || cur > prev && further) {
        right = Math.min((cur + prev) / 2), right)
    }
    if (cur < prev && further || cur > prev && closer){
        left = Math.max((cur + prev) / 2, left)
    }
 */
public class Task10 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var n = Integer.parseInt(reader.readLine());
            var cur = Double.parseDouble(reader.readLine());
            var left = 30.0;
            var right = 4000.0;
            int i = 1;
            while (i < n){
                var input = reader.readLine().split(" ");
                var prev = cur;
                cur = Double.parseDouble(input[0]);
                var distance = input[1];
                if (cur < prev && distance.equals("closer")
                    || cur > prev && distance.equals("further")) {
                    right = min((cur + prev) / 2.0, right);
                }
                if (cur < prev && distance.equals("further")
                    || cur > prev && distance.equals("closer")){
                    left = max((cur + prev) / 2.0, left);
                }
                ++i;
            }
            System.out.printf(left + " " + right);
        }
    }
}
