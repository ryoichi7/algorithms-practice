package com.samoylov.leetcode.easy;

/**
 * <a href="https://leetcode.com/problems/matrix-diagonal-sum/description">task link</a>
 */
public class MatrixDiagonalSum {
    public int diagonalSum(int[][] mat) {
        var sum = 0;
        for (var row = 0; row < mat.length; ++row) {
            sum += mat[row][row];
            if (row != mat.length - 1 - row) {
                sum += mat[row][mat.length - 1 - row];
            }
        }
        return sum;
    }
}
