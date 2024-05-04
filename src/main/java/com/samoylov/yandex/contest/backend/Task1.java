package com.samoylov.yandex.contest.backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static java.lang.Math.max;
import static java.util.Arrays.asList;

public class Task1 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var line = reader.readLine();
            var result = formatText(line);
            System.out.println(result);
        }
    }

    public static String formatText(String line) {
        var maxLength = 0;
        var curLength = 0;
        for (int i = 0; i < line.length(); i++) {
            var ch = line.charAt(i);
            if (ch >= 97 && ch <= 122) {
                curLength++;
            } else {
                maxLength = max(maxLength, curLength);
                curLength = 0;
            }
        }
        maxLength = max(maxLength, curLength) * 3;

        var formattedLine = fixWhitespaces(line);

        var words = new ArrayList<>(asList(formattedLine.split(" ")));
        var firstWord = words.remove(0);
        curLength = firstWord.length();
        var result = new StringBuilder(firstWord);
        for (var word : words){
            if (curLength + word.length() + 1 <= maxLength){
                result.append(" ").append(word);
                curLength += word.length() + 1;
            }
            else {
                result.append("\n").append(word);
                curLength = word.length();
            }
        }
        return result.toString();
    }

    private static String fixWhitespaces(String line) {
        var builder = new StringBuilder();
        for (int i = 0; i < line.length() - 1; i++) {
            var curChar = line.charAt(i);
            var nextChar = line.charAt(i + 1);
            if (curChar == ' ' && nextChar == ',') {
                continue;
            }
            builder.append(line.charAt(i));
            if (curChar == ',' && nextChar >= 97 && nextChar <= 122) {
                builder.append(' ');
            }
        }
        builder.append(line.charAt(line.length() - 1));
        return builder.toString();
    }
}
