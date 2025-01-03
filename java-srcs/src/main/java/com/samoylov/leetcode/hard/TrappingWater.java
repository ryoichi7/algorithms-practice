package com.samoylov.leetcode.hard;

/**
 * <a href="https://leetcode.com/problems/trapping-rain-water/description/">task link</a>
 */
public class TrappingWater {
    public int trap(int[] height) {
        var waterAmount = 0;
        var pivot = -1;
        var maxHeight = -1;
        for (int i = 0; i < height.length; i++) {
            var curHeight = height[i];
            if (curHeight > maxHeight){
                pivot = i;
                maxHeight = curHeight;
            }
        }

        var curMax = 0;
        for (int i = 0; i < pivot; i++) {
            var curHeight = height[i];
            if (curHeight > curMax){
                curMax = curHeight;
            }
            waterAmount += curMax - curHeight;
        }

        curMax = 0;
        for (int i = height.length - 1; i > pivot; --i){
            var curHeight = height[i];
            if (curHeight > curMax){
                curMax = curHeight;
            }
            waterAmount += curMax - curHeight;
        }

        return waterAmount;
    }
}
