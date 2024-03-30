package com.samoylov.yandex.interview;


import java.util.HashMap;
import java.util.Objects;

/**
 * Дана строка S (длинной N) и дана подстрока T (длинной K).
 * Определить, сколько раз в строке встречается анаграмма подстроки.
 */

public class AlgPrac5 {
    public static int Solution(String s, String t){
        var result = 0;
        var k = t.length(); //subseq length
        var subseq = new HashMap<Character, Integer>();
        for (char c : t.toCharArray()){ // fill subseq map to compare with
            subseq.put(c, subseq.getOrDefault(c, 0) + 1);
        }

        var curSubseq = new HashMap<Character, Integer>();
        var wrongAmount = 0;
        for (int i = 0; i < k; ++i){ // fill curSubseq with first K elements
            var element = s.charAt(i);
            if (subseq.containsKey(element)) {
                curSubseq.put(element, curSubseq.getOrDefault(element, 0) + 1);
            }
        }

        for (char key : subseq.keySet()){ // count amount of mismatched elements
            if (!Objects.equals(subseq.get(key), curSubseq.get(key))){
                wrongAmount++;
            }
        }

        if (wrongAmount == 0){ // check if first "window is a required subsequence
            result++;
        }

        int ptr = k; // pointer on the K-th element because previous are already processed
        while (ptr < s.length()){ // loop through the [K, len(s)) elements of the string s
            var elementOut = s.charAt(ptr - k); // element to remove from current "window"
            if (subseq.containsKey(elementOut)){
                curSubseq.put(elementOut, curSubseq.get(elementOut) - 1);
                if ((curSubseq.get(elementOut) + 1) == (subseq.get(elementOut))){
                    wrongAmount--;
                } if (curSubseq.get(elementOut).equals(subseq.get(elementOut))) {
                    wrongAmount++;
                }
            }

            var elementIn = s.charAt(ptr); // element to put in current "window"
            if (subseq.containsKey(elementIn)){
                curSubseq.put(elementIn, curSubseq.getOrDefault((elementIn), 0) + 1);
                if ((curSubseq.get(elementIn) - 1) == (subseq.get(elementIn))){
                    wrongAmount--;
                } if (curSubseq.get(elementIn).equals(subseq.get(elementIn))) {
                    wrongAmount++;
                }
            }
            if (wrongAmount == 0){
                result++;
            }
            ptr++;
        }
        return result;
    }
}
