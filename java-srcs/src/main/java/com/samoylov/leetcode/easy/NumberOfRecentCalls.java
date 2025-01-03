package com.samoylov.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/number-of-recent-calls/">task link</a>
 */
public class NumberOfRecentCalls {
    class RecentCounter {

        private final List<Integer> requests = new ArrayList<>();
        private int start;
        private int end;

        public RecentCounter() {

        }

        public int ping(int t) {
            requests.add(t);
            end++;
            while (requests.get(start) < t - 3000) {
                start++;
            }
            return end - start;
        }
    }
}
