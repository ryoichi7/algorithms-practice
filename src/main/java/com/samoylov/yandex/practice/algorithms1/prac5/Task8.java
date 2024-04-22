package com.samoylov.yandex.practice.algorithms1.prac5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.stream;

/**
 * H. Подстрока
 */
public class Task8 {
    public static void main(String[] args) throws IOException {
        try (var reader = new BufferedReader(new InputStreamReader(System.in))) {
            var input = stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            var n = input[0];
            var k = input[1];
            var string = reader.readLine();
            var result = findMaxSubsequence(string, k);
            System.out.println(result[0] + " " + result[1]);
        }
    }

    public static int[] findMaxSubsequence(String seq, int k) {
        var map = new HashMap<Character, LinkedList<Integer>>(); // 'char' -> [i, j] where (i <= j) are indexes in init seq
        var left = 0;
        var right = 0;
        var maxLength = 0;
        var seqInception = 0;
        while (right < seq.length()){
            var ch = seq.charAt(right);
            if (map.containsKey(ch)){
                map.get(ch).add(right);
            } else {
                map.put(ch, new LinkedList<>(List.of(right)));
            }
            if (map.get(ch).size() > k){
                if (right - left > maxLength){
                    maxLength = right - left;
                    seqInception = left;
                }
                var newLeft = map.get(ch).getFirst() + 1;
                while (left < newLeft){
                    var charToRemove = seq.charAt(left);
                    var indexes = map.get(charToRemove);
                    if (indexes.size() == 1){
                        map.remove(charToRemove);
                    } else {
                        indexes.removeFirst();
                    }
                    left++;
                }
            }
            right++;
        }
        if (right - left > maxLength){
            maxLength = right - left;
            seqInception = left;
        }
        return new int[] {maxLength, seqInception + 1};
    }
}
