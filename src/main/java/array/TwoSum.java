package array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 *
 * @author Albina Gimaletdinova on 17/03/2022
 */
public class TwoSum {
    public int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> dict = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (dict.containsKey(target - arr[i])) {
                return new int[]{i, dict.get(target - arr[i])};
            } else {
                dict.put(arr[i], i);
            }
        }
        return new int[]{-1, -1};
    }
}
