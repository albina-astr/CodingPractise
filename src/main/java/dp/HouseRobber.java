package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/house-robber/
 *
 * @author Albina Gimaletdinova on 15/08/2022
 */
public class HouseRobber {
    // bottom-up
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    //top-down
    private Map<Integer, Integer> memo = new HashMap<>();

    public int rob2(int[] nums) {
        return rob(nums, nums.length - 1);
    }

    private int rob(int[] nums, int houseIndex) {
        if (houseIndex == 0) {
            return nums[0];
        }
        if (houseIndex == 1) {
            return Math.max(nums[0], nums[1]);
        }

        if (!memo.containsKey(houseIndex)) {
            memo.put(houseIndex,
                    Math.max(rob(nums, houseIndex - 1),
                            rob(nums, houseIndex - 2) + nums[houseIndex]));
        }
        return memo.get(houseIndex);
    }
}
