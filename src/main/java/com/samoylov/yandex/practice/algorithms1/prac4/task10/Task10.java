package com.samoylov.yandex.practice.algorithms1.prac4.task10;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

/**
 * J. Дополнительная проверка на списывание
 */
public class Task10 {
    public static void main(String[] args) throws IOException {
//        try (var reader = new BufferedReader(new InputStreamReader(new FileInputStream(Path.of("src/main/java/com/samoylov/yandex/practice/algorithms1/prac4/task10/input.txt").toFile())))) {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var input = reader.readLine().split(" ");
            var keywordsCount = Integer.parseInt(input[0]);
            var caseSensitive = input[1].equals("yes");
            var canStartWithDigit = input[2].equals("yes");
            var keyWords = new HashSet<String>(keywordsCount);
            for (var i = 0; i < keywordsCount; ++i) {
                var keyword = reader.readLine();
                if (caseSensitive) {
                    keyWords.add(keyword);
                } else {
                    keyWords.add(keyword.toLowerCase());
                }
            }
            Pattern pattern;
            if (canStartWithDigit) {
                pattern = Pattern.compile("\\b(?=\\w*\\D)\\w+\\b");
            } else {
                pattern = Pattern.compile("\\b[a-zA-Z_]\\w*\\b");
            }
            var idOccurrences = new LinkedHashMap<String, Integer>();
            reader.lines().forEachOrdered(line -> {
                var matcher = pattern.matcher(line);
                while (matcher.find()) {
                    var group = matcher.group();
                    if (!group.matches("\\d+")) {
                        if (caseSensitive) {
                            if (!keyWords.contains(group)) {
                                idOccurrences.put(group, idOccurrences.getOrDefault(group, 0) + 1);
                            }
                        } else {
                            var groupLowerCase = group.toLowerCase();
                            if (!keyWords.contains(groupLowerCase)) {
                                idOccurrences.put(groupLowerCase, idOccurrences.getOrDefault(groupLowerCase, 0) + 1);
                            }
                        }
                    }
                }
            });

            var max = 0;
            var id = "";
            for (var entry : idOccurrences.entrySet()) {
                if (entry.getValue() > max) {
                    max = entry.getValue();
                    id = entry.getKey();
                }
            }
            System.out.println(id);
        }
    }
}
