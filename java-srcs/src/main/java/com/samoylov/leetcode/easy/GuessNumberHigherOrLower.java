package com.samoylov.leetcode.easy;

/**
 * <a href="https://leetcode.com/problems/guess-number-higher-or-lower">task link</a>
 */
public class GuessNumberHigherOrLower {
    /**
     * Forward declaration of guess API.
     * @param  num   your guess
     * @return 	     -1 if num is higher than the picked number
     *			      1 if num is lower than the picked number
     *               otherwise return 0
     * int guess(int num);
     */
    public int guess(int num){
        return 0;
    }
    public int guessNumber(int right) {
        var left = 1;
        while (left <= right) {
            var mid = (int)(((long)left + (long)right) / 2);
            var guess = guess(mid);
            if (guess == 0) {
                return mid;
            } if (guess == 1) {
                left = mid + 1;
            } if (guess == -1) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
