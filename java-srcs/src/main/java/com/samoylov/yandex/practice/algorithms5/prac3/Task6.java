package com.samoylov.yandex.practice.algorithms5.prac3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Arrays.stream;

/**
 * С целью экономии чернил в картридже принтера было принято решение укоротить некоторые слова
 * в тексте. Для этого был составлен словарь слов, до которых можно сокращать более длинные слова.
 * Слово из текста можно сократить, если в словаре найдется слово, являющееся началом слова из текста.
 * Например, если в списке есть слово "лом", то слова из текста "ломбард", "ломоносов" и другие слова,
 * начинающиеся на "лом", можно сократить до "лом".
 * Если слово из текста можно сократить до нескольких слов из словаря,
 * то следует сокращать его до самого короткого слова.
 */
public class Task6 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var result = new ArrayList<String>();
            var dictionary = new HashSet<String>(Arrays.asList(reader.readLine().split(" ")));
            var words = stream(reader.readLine().split(" ")).toList();
            words.forEach(word -> {
                for (var i = 0; i < word.length() - 1; ++i){
                    var substr = word.substring(0, i + 1);
                    if (dictionary.contains(substr)){
                        result.add(substr);
                        return;
                    }
                }
                result.add(word);
            });
            System.out.println(String.join(" ", result));
        }
    }
}