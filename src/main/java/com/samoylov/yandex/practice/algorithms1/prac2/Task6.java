package com.samoylov.yandex.practice.algorithms1.prac2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;


public class Task6 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            reader.readLine();
            var numbers = stream(reader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            int i = 0;
            var currentNums = new ArrayList<>(numbers);
            var shift = new LinkedList<Integer>();
            while (i < currentNums.size() / 2) {
                shift.addFirst(currentNums.get(i));
                if (!currentNums.get(i).equals(currentNums.get(currentNums.size() - i - 1))) {
                    currentNums = new ArrayList<>(numbers);
                    currentNums.addAll(shift);
                    shift.clear();
                    i = 0;
                } else {
                    ++i;
                }
            }
            var iterator = currentNums.iterator();
            for (int j = 0; j < numbers.size(); j++) {
                iterator.next();
                iterator.remove();
            }
            System.out.println(currentNums.size());
            System.out.println(String.join(" ", currentNums.stream()
                    .map(a -> Integer.toString(a))
                    .collect(Collectors.toList())));
        }
    }
}
