package array;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/majority-element/
 *
 * @author Albina Gimaletdinova on 02/03/2022
 */
public class MajorityElement {
    // solution 1
    public int majorityElement(int[] arr) {
        Map<Integer, Integer> counts = new HashMap<>();
        int max = Integer.MIN_VALUE;
        int majorityElement = -1;

        for (int i = 0; i < arr.length; i++) {
            Integer occured = counts.get(arr[i]);
            if (occured == null) {
                counts.put(arr[i], 1);
            } else {
                counts.put(arr[i], occured + 1);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (counts.get(arr[i]) > max) {
                max = counts.get(arr[i]);
                majorityElement = arr[i];
            }
        }

        return majorityElement;
    }

    //solution 2 Boyer Moore Voting Algorithm
    public int majorityElement2(int[] arr) {
        int candidate = -1;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (count == 0) {
                candidate = arr[i];
                count = 1;
            } else {
                if (arr[i] != candidate) count--;
                else count++;
            }
        }

        count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == candidate) {
                count++;
                if (count > arr.length / 2) return candidate;
            }
        }

        return candidate;
    }
}
