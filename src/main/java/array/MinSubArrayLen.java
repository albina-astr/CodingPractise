package array;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum
 *
 * @author Albina Gimaletdinova on 02/08/2022
 */
public class MinSubArrayLen {
    // brute force solution
    public int minSubArrayLen(int target, int[] arr) {
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum >= target) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
