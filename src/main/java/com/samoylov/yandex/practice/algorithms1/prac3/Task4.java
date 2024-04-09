package com.samoylov.yandex.practice.algorithms1.prac3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
public class Task4 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var dictionary = new HashSet<String>();
            reader.lines()
                    .forEach(line -> dictionary.addAll(Arrays.asList(line.split("( +)"))));
            System.out.println(dictionary.size());
        }
    }
}
