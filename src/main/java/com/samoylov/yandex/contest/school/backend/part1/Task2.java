package com.samoylov.yandex.contest.school.backend.part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task2 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var origin = reader.readLine();
            var input = reader.readLine();

            var result = isCorrect(input, origin);

            System.out.println(result);
        }
    }

    private static String isCorrect(String input, String origin) {
        var currentString = new StringBuilder();
        var cursor = 0;
        var cmd = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            var ch = input.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                currentString.insert(cursor, ch);
                cursor++;
            } else if (ch == '<') {
                ch = input.charAt(++i);
                while (ch != '>') {
                    cmd.append(ch);
                    ch = input.charAt(++i);
                }
                var command = cmd.toString();
                switch (command) {
                    case "left" -> {
                        if (cursor > 0) cursor--;
                    }
                    case "right" -> {
                        if (cursor < currentString.length()){
                            cursor++;
                        }
                    }
                    case "bspace" -> {
                        if (cursor != 0) {
                            currentString.deleteCharAt(--cursor);
                        }
                    }
                    case "delete" -> {
                        if (cursor < currentString.length()) {
                            currentString.deleteCharAt(cursor);
                        }
                    }
                }
                cmd.delete(0, cmd.length());
            }
        }

        if (origin.contentEquals(currentString)) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
