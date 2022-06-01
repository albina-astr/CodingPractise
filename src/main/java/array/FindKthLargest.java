package array;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * @author Albina Gimaletdinova on 01/05/2022
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int e : nums) {
            heap.add(e);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        return heap.peek();
    }
}
