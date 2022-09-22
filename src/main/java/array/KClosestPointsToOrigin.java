package array;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 *
 * @author Albina Gimaletdinova on 22/09/2022
 */
public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] arr, int k) {
        if (arr == null || arr.length == 0) {
            return new int[0][];
        }

        Queue<Integer[]> maxHeap = new
                PriorityQueue<>(new PointsComparator());

        for (int i = 0; i < arr.length; i++) {
            double dist = Math.sqrt(Math.pow(arr[i][0], 2) +
                    Math.pow(arr[i][1], 2));
            maxHeap.offer(
                    new Integer[] {arr[i][0], arr[i][1]});
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int n = maxHeap.size();
        int[][] res = new int[n][];
        for (int i = 0; i < n; i++) {
            Integer[] coords = maxHeap.poll();
            res[i] = new int[] {coords[0], coords[1]};
        }
        return res;
    }

    class PointsComparator implements Comparator<Integer[]> {
        @Override
        public int compare(Integer[] pair1, Integer[] pair2) {
            double dist1 = Math.sqrt(
                    Math.pow(pair1[0], 2) + Math.pow(pair1[1], 2)
            );
            double dist2 = Math.sqrt(
                    Math.pow(pair2[0], 2) + Math.pow(pair2[1], 2)
            );
            if (dist1 > dist2) {
                return -1;
            } else if (dist2 > dist1) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
