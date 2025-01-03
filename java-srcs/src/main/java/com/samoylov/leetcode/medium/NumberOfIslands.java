package com.samoylov.leetcode.medium;

/**
 * <a href="https://leetcode.com/problems/number-of-islands/description/">task link</a>
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        var islandsCount = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1') {
                    islandsCount++;
                    dfs(grid, i, j);
                }
            }
        }
        return islandsCount;
    }

    public void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j); //left
        dfs(grid, i + 1, j); //right
        dfs(grid, i, j + 1); //up
        dfs(grid, i, j - 1); //down
    }
}
