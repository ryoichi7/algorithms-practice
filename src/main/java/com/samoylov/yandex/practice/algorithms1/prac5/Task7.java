package com.samoylov.yandex.practice.algorithms1.prac5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Arrays.stream;

/**
 * G. Счет в гипершашках
 */
public class Task7 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var input = stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            var n = input[0];
            var k = input[1];
            var cards = new HashMap<Integer, Integer>();
            stream(reader.readLine().split(" "))
                    .map(Integer::parseInt)
                    .forEach(card -> cards.put(card, cards.getOrDefault(card, 0) + 1));
            var answer = countPermutations(cards, k);
            System.out.println(answer);
        }
    }

    public static long countPermutations(Map<Integer, Integer> cards, int k) {
        long answer = 0;
        var left = 0;
        var right = 0;
        var duplicates = 0;
        var uniqueCards = new ArrayList<>(cards.keySet());
        uniqueCards.sort(Comparator.comparing(Integer::intValue));
        while (left < uniqueCards.size()){
            while (right < uniqueCards.size() &&
                   uniqueCards.get(left) * k >= uniqueCards.get(right)){
                if (cards.get(uniqueCards.get(right)) >= 2){
                    duplicates++;
                }
                right++;
            }
            var range = right - left;
            if (cards.get(uniqueCards.get(left)) >= 2){ // current card has 2 copies, so we can choose the third one in (range - 1) ways. (x * x * 3) where x = current card, 3 = range - 1
                answer += (range - 1) * 3L; // multiplied by 3 because the third chosen card can be in any of 3 positions (x * x * 3) || (x * 3 * x) || (3 * x * x)
            }
            if (cards.get(uniqueCards.get(left)) >= 3){ // current card has 3 copies, so we can choose them all and get +1 permutation (x * x * x)
                answer += 1;
            }
            answer += (range - 1) * (range - 2) * 3L; // current card has 1 copy, so we can choose 2nd card in (range -1) ways and 3rd card in (range -2) ways
                                                    // also multiplied by 3 because current card can be in any of 3 positions (x * 3 * 2) || (3 * x * 2) || (3 * 2 * x)
            if (cards.get(uniqueCards.get(left)) >= 2){
                duplicates--;
            }
            answer += duplicates * 3L; // current card has 1 copy, so we choose cards that has at least 2 copies (x * d * d) where x = current card, d = duplicates amount
            left++;                   // also multiplied by 3 because current card can be in any of 3 positions (x * d * d) || (d * x * d) || (d * d * x)
        }
        return answer;
    }
}
