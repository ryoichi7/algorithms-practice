package com.samoylov.yandex.practice.algorithms1.prac4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Task1 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var n = Integer.parseInt(reader.readLine());
            var synonyms = new HashMap<String, String>(n);
            for (int i = 0; i < n; ++i){
                var input = stream(reader.readLine().split(" "))
                        .collect(Collectors.toList());
                var left = input.get(0);
                var right = input.get(1);
                synonyms.put(left, right);
                synonyms.put(right, left);
            }
            var word = reader.readLine();
            System.out.println(synonyms.get(word));
        }
    }
}
