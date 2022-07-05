package array;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/solution/
 *
 * @author Albina Gimaletdinova on 05/07/2022
 */
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) return nums;
        // if (k == nums.length) return nums;

        Map<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        Queue<Integer> heap = new PriorityQueue<>(
                (a, b) -> count.get(a) - count.get(b)
        );

        for (int n : count.keySet()) {
            heap.add(n);
            if (heap.size() > k) heap.poll();
        }

        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = heap.poll();
        }
        return res;
    }
}
