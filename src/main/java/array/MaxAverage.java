package array;

/**
 * https://leetcode.com/problems/maximum-average-subarray-i/
 *
 * @author Albina Gimaletdinova on 28/07/2022
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

    //solution 2 - GOOD, BUT SLOWER
    public double findMaxAverage2(int[] arr, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        double res = sum;
        for (int i = k; i < arr.length; i++) {
            sum += arr[i] - arr[i - k];
            res = Math.max(res, sum);
        }
        return (double) res / k;
    }
}
