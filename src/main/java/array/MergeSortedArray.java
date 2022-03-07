package array;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 *
 * @author Albina Gimaletdinova on 07/03/2022
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - n - 1;
        int j = n - 1;
        for (int k = nums1.length - 1; k >= 0; k--) {
            if (i >= 0 && j >= 0) {
                if (nums1[i] > nums2[j]) {
                    nums1[k] = nums1[i--];
                } else {
                    nums1[k] = nums2[j--];
                }
            } else if (i >= 0) {
                nums1[k] = nums1[i--];
            } else {
                nums1[k] = nums2[j--];
            }
        }
    }

    //optimisation with conditions
    public void mergeOptimized(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1; //p1
        int j = n - 1; //p2
        for (int k = nums1.length - 1; k >= 0; k--) {
            if (j < 0) {
                break;
            }
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i--];
            } else {
                nums1[k] = nums2[j--];
            }
        }
    }
}
