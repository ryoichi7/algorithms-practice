package com.samoylov.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/top-k-frequent-words">task link</a>
 */
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        var wordToFreq = new HashMap<String, Integer>();
        for (var word : words) {
            wordToFreq.put(word, wordToFreq.getOrDefault(word, 0) + 1);
        }
        var result = new ArrayList<>(wordToFreq.keySet());
        return result.stream()
                .sorted((a, b) -> {
                    var aFreq = wordToFreq.get(a);
                    var bFreq = wordToFreq.get(b);
                    if (!bFreq.equals(aFreq)) {
                        return bFreq - aFreq;
                    }
                    return a.compareTo(b);
                })
                .limit(k)
                .toList();
    }
}
