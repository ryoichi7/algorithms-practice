package com.samoylov.yandex.practice.algorithms5.prac2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.Math.min;
import static java.util.Arrays.stream;

public class Task7 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var testsCount = parseInt(reader.readLine());
            for (int i = 0; i < testsCount; i++) {
                var numbersCount = parseInt(reader.readLine());
                var numbers = stream(reader.readLine().split(" "))
                        .map(Integer::parseInt)
                        .toList();
                var sectionLengths = getSectionLengths(numbers, numbersCount);
                System.out.println(sectionLengths.size());
                System.out.println(String.join(" ", sectionLengths));
            }
        }
    }

    public static List<String> getSectionLengths(List<Integer> nums, Integer numsCount){
        var result = new ArrayList<String>();
        var currentMinVal = Integer.MAX_VALUE;
        var currentLength = 0;
        for (int i = 0; i < numsCount; i++) {
            var num = nums.get(i);
            if (num > currentLength){
                currentLength++;
                currentMinVal = min(currentMinVal, num);
            } else {
                result.add(Integer.toString(currentLength));
                currentLength = 1;
                currentMinVal = num;
            }
            if (currentLength == currentMinVal){
                result.add(Integer.toString(currentLength));
                currentLength = 0;
                currentMinVal = Integer.MAX_VALUE;
            }
        }
        if (currentLength != 0){
            result.add(Integer.toString(currentLength));
        }
        return result;
    }
}
