package array;

/**
 * https://leetcode.com/problems/maximum-average-subarray-i/
 *
 * @author Albina Gimaletdinova on 28/02/2023
 */
public class MaxAverage {
    public double findMaxAverage(int[] arr, int k) {
        int max = Integer.MIN_VALUE;
        if (arr == null || arr.length == 0 || k > arr.length) {
            return max;
        }

        int windowSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            if (windowEnd >= k - 1) {
                max = Math.max(max, windowSum);
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return (double) max / k;
    }
}
