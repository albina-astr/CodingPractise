package array;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-smaller/
 *
 * @author Albina Gimaletdinova on 26/03/2022
 */
public class ThreeSumSmaller {
    public int threeSumSmaller(int[] arr, int target) {
        Arrays.sort(arr);
        int res = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            if (i == 0 || arr[i] != arr[i - 1]) {
                res += foundPair(arr, i, target);
            }
        }
        return res;
    }

    private int foundPair(int[] arr, int currentIndex, int target) {
        int lo = currentIndex + 1;
        int hi = arr.length - 1;
        int smallTarget = target - arr[currentIndex];

        int res = 0;
        while (lo < hi) {
            int twoSum = arr[lo] + arr[hi];
            if (twoSum >= smallTarget) {
                hi--;
            } else {
                res += hi - lo;
                lo++;
            }
        }
        return res;
    }
}
