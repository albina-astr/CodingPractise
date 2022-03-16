package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/3sum/
 *
 * @author Albina Gimaletdinova on 16/03/2022
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] arr) {
        if (arr.length < 3) {
            return List.of();
        }

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            if (i == 0 || arr[i] != arr[i - 1]) {
                foundPair(arr, i, res);
            }
        }

        return res;
    }

    private void foundPair(int[] arr, int currIndex, List<List<Integer>> res) {
        int lo = currIndex + 1;
        int hi = arr.length - 1;
        int target = -arr[currIndex];
        while (lo < hi) {
            long twoSum = arr[lo] + arr[hi];
            if (twoSum > target) {
                hi--;
            } else if (twoSum < target) {
                lo++;
            } else {
                res.add(Arrays.asList(-target, arr[lo], arr[hi]));
                lo++;
                hi--;
                while (lo < hi && arr[lo] == arr[lo - 1]) {
                    lo++;
                }
                while (lo < hi && arr[hi] == arr[hi + 1]) {
                    hi--;
                }
            }
        }
    }
}
