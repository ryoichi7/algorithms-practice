package com.samoylov.yandex.practice.algorithms1.prac3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Task1 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var set = stream(reader.readLine().split(" "))
                    .collect(Collectors.toSet());
            System.out.println(set.size());
        }
    }
}
