package array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array/
 *
 * @author Albina Gimaletdinova on 12/06/2022
 */
public class NumberIsMajorityElement {
    //solution 1 with HashMap
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

    //solution 2 with Binary Search
    public boolean isMajorityElement2(int[] arr, int target) {
        int first = binSearch(arr, target);
        int last = binSearch(arr, target + 1);
        return last - first > arr.length / 2;
    }

    private int binSearch(int[] arr, int key) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (key > arr[mid]) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}
