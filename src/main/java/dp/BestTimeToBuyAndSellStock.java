package dp;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * @author Albina Gimaletdinova on 25/04/2022
 */
public class BestTimeToBuyAndSellStock {
    //time limit exceeded
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > max) {
                    max = prices[j] - prices[i];
                }
            }
        }
        return max;
    }

    //optimized solution
    public int maxProfitOptimized(int[] prices) {
        int minPrice = prices[0];
        int maxDif = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - minPrice > maxDif) {
                maxDif = prices[i] - minPrice;
            }
            minPrice = Math.min(minPrice, prices[i]);
        }
        return maxDif;
    }
}
