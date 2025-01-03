package com.samoylov.yandex.practice.algorithms1.prac3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static java.lang.String.join;
import static java.util.Arrays.stream;

public class Task3 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var input = stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            var n = input[0];
            var m = input[1];
            var anya = new HashSet<Integer>();
            var borya = new HashSet<Integer>();
            var both = new TreeSet<Integer>();
            for (var i = 0; i < n; ++i){
                var num = Integer.parseInt(reader.readLine());
                anya.add(num);
            }
            for (var i = 0; i < m; ++i){
                var num = Integer.parseInt(reader.readLine());
                if (anya.contains(num)){
                    anya.remove(num);
                    both.add(num);
                } else {
                    borya.add(num);
                }
            }
            System.out.println(both.size());
            System.out.println(join(" ", both.stream()
                    .map(a -> Integer.toString(a))
                    .collect(Collectors.toList())));
            System.out.println(anya.size());
            System.out.println(join(" ", anya.stream()
                    .sorted()
                    .map(a -> Integer.toString(a))
                    .collect(Collectors.toList())));
            System.out.println(borya.size());
            System.out.println(join(" ", borya.stream()
                    .sorted()
                    .map(a -> Integer.toString(a))
                    .collect(Collectors.toList())));
        }
    }
}