package array;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 *
 * @author Albina Gimaletdinova on 01/06/2022
 */
public class KthLargestInAStream {
    private PriorityQueue<Integer> minHeap;
    private int size;

    public KthLargestInAStream(int k, int[] nums) {
        this.size = k;
        this.minHeap = new PriorityQueue<>((n1, n2) -> n1 - n2);
        for (int n : nums) {
            this.minHeap.offer(n);
        }
        while (minHeap.size() > k) {
            minHeap.poll();
        }
    }

    public int add(int val) {
        minHeap.add(val);
        if (minHeap.size() > size) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
