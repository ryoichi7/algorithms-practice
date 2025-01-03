package com.samoylov.leetcode.medium;

import java.util.ArrayList;

/**
 * <a href="https://leetcode.com/problems/interval-list-intersections/description/">task link</a>
 */
public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        var result = new ArrayList<int[]>();
        var first = 0;
        var second = 0;
        while (first < firstList.length && second < secondList.length) {
            var firstStart = firstList[first][0];
            var firstEnd = firstList[first][1];
            var secondStart = secondList[second][0];
            var secondEnd = secondList[second][1];

            if (firstStart <= secondEnd && secondStart <= firstEnd) {
                result.add(new int[]{Math.max(firstStart, secondStart), Math.min(firstEnd, secondEnd)});
            }

            if (firstEnd < secondEnd) {
                first++;
            } else {
                second++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
