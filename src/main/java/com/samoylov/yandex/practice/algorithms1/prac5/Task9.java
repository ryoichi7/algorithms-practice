package com.samoylov.yandex.practice.algorithms1.prac5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * I. Робот
 */
public class Task9 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var k = Integer.parseInt(reader.readLine());
            var commands = reader.readLine();
            long prevLength = 0;
            long result = 0;
            for (var i = k; i < commands.length(); ++i) {
                if (commands.charAt(i) == commands.charAt(i - k)) {
                    prevLength++;
                    result += prevLength;
                } else {
                    prevLength = 0;
                }
            }
            System.out.println(result);
        }
    }
}