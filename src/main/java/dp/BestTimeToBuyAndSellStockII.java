package dp;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * @author Albina Gimaletdinova on 27/04/2022
 */
public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }

        return maxProfit;
    }
}
