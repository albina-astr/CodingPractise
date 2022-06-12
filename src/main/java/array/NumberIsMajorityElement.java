package array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array/
 *
 * @author Albina Gimaletdinova on 12/06/2022
 */
public class NumberIsMajorityElement {
    public boolean isMajorityElement(int[] arr, int target) {
        Map<Integer, Integer> dict = new HashMap<>();
        for (int n : arr) {
            Integer count = dict.get(n);
            if (count != null) dict.put(n, count + 1);
            else dict.put(n, 1);
        }

        Integer targetCount = dict.get(target);
        if (targetCount == null) return false;
        return targetCount > arr.length / 2;
    }
}
