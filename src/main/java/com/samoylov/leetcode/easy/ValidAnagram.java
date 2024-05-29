package com.samoylov.leetcode.easy;

/**
 * <a href="https://leetcode.com/problems/valid-anagram/description">task link</a>
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] alphabetS = new char[26];
        char[] alphabetT = new char[26];
        for (int i = 0 ; i < 26; ++i){
            alphabetT[i] = 0;
            alphabetS[i] = 0;
        }

        for (int i = 0 ; i < s.length(); ++i){
            alphabetS[s.charAt(i) % 26] += 1;
            alphabetT[t.charAt(i) % 26] += 1;
        }

        for (int i = 0 ; i < 26; ++i)
            if (alphabetS[i] != alphabetT[i]) return false;

        return true;
    }
}
