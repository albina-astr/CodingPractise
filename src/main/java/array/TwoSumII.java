package array;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * @author Albina Gimaletdinova on 17/03/2022
 */
public class TwoSumII {
    public int[] twoSum(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            //to prevent int overflow !!!
            long sum = arr[left] + arr[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[]{-1, -1};
    }
}
