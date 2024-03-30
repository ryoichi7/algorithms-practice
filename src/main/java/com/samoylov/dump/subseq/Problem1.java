package com.samoylov.dump.subseq;

import java.util.HashMap;
import java.util.Map;

public class Problem1 {
    public static int findMaxSubstr(String sequence){
        if (sequence == null || sequence.isEmpty()){
            return 0;
        }
        char[] seq = new char[sequence.length()];
        int left = 0;
        int right = 0;
        int result = 0;
        Map<Character, Integer> map = new HashMap<>(); //k - element, v - index
        sequence.getChars(0, sequence.length(), seq, 0);
        while (right < seq.length) {
            if (map.containsKey(seq[right])){
                result = Math.max(result, right - left);
                left = map.get(seq[right]) + 1;
            }
            map.put(seq[right], right);
            right++;
        }
        result = Math.max(result, right - left);
        return result;
    }
}
