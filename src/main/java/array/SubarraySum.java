package array;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/
 *
 * @author Albina Gimaletdinova on 25/08/2022
 */
public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) res++;
            }
        }

        return res;
    }
}
