package com.samoylov.leetcode.easy;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock">task link</a>
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        var maxProfit = 0;
        var buyPrice = prices[0];
        for (var curPrice : prices) {
            buyPrice = Math.min(buyPrice, curPrice);
            maxProfit = Math.max(maxProfit, curPrice - buyPrice);
        }
        return maxProfit;
    }
}
