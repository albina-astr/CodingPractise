package dp;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 *
 * @author Albina Gimaletdinova on 17/08/2022
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        if (cost.length == 1) {
            return cost[0];
        }

        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = Math.min(cost[0], cost[1]);
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i],
                    dp[i - 2] + cost[i]);
        }
        return dp[cost.length - 1];
    }
}
