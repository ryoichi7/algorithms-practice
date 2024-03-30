package com.samoylov.yandex.practice.algorithms5.prac3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Задано две строки, нужно проверить, является ли одна анаграммой другой. Анаграммой называется строка, полученная из другой перестановкой букв.
 * -------------
 * Формат ввода
 * Строки состоят из строчных латинских букв, их длина не превосходит 100000. Каждая записана в отдельной строке.
 * -------------
 * Формат вывода
 * Выведите "YES" если одна из строк является анаграммой другой и "NO" в противном случае.
 */
public class Task2 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var string1 = reader.readLine();
            var string2 = reader.readLine();
            if (isAnagram(string1, string2)){
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean isAnagram(String str1, String str2){
        var str1CharOccurrences = new HashMap<Character, Integer>();
        var str2CharOccurrences = new HashMap<Character, Integer>();
        if (str1.length() != str2.length())
            return false;
        for (int i = 0; i < str1.length(); ++i){
            var str1Char = str1.charAt(i);
            var str2Char = str2.charAt(i);
            str1CharOccurrences.put(str1Char,
                    str1CharOccurrences.getOrDefault(str1Char, 0) + 1);
            str2CharOccurrences.put(str2Char,
                    str2CharOccurrences.getOrDefault(str2Char, 0) + 1);
        }
        for (var key : str1CharOccurrences.keySet()){
            if (!str1CharOccurrences.get(key).equals(str2CharOccurrences.get(key))){
                return false;
            }
        }
        return true;
    }
}
