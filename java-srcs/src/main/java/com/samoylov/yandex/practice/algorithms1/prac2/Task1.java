package com.samoylov.yandex.practice.algorithms1.prac2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static java.util.Arrays.stream;

public class Task1 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            List<Integer> nums = stream(reader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .toList();
            for (int i = 0; i < nums.size() - 1; ++i) {
                if (nums.get(i) >= nums.get(i + 1)){
                    System.out.println("NO");
                    return;
                }
            }
            System.out.println("YES");
        }
    }
}