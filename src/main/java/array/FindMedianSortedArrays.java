package array;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 *
 * @author Albina Gimaletdinova on 25/09/2022
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = 0;
        int n = 0;

        if (nums1 == null && nums2 == null) {
            return 0.0;
        } else if (nums1 == null) {
            m = 0;
        } else if (nums2 == null) {
            n = 0;
        } else {
            m = nums1.length;
            n = nums2.length;
        }

        int k = (m + n) / 2 + 1;
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> a- b);
        int i = 0, j = 0;
        while (i < m || j < n) {
            if (i < m) {
                heap.offer(nums1[i++]);
            }
            if (j < n) {
                heap.offer(nums2[j++]);
            }
            while (heap.size() > k) {
                heap.poll();
            }
        }

        if ((m + n) % 2 == 0) {
            int first = heap.poll();
            int second = heap.poll();
            return (first + second) * 1.0 / 2;
        } else {
            return heap.poll();
        }
    }
}
