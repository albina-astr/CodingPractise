package array;

/**
 * https://leetcode.com/problems/squares-of-a-sorted-array/
 *
 * @author Albina Gimaletdinova on 06/03/2022
 */
public class SortedSquares {
    public int[] sortedSquares(int[] arr) {
        int[] res = new int[arr.length];

        int left = 0, right = arr.length - 1;
        int i = right;
        while (left <= right) {
            //instead of comparing SQUARES we can compare
            //just absolute values
            if (Math.abs(arr[right]) > Math.abs(arr[left])) {
                res[i--] = arr[right] * arr[right];
                right--;
            } else {
                res[i--] = arr[left] * arr[left];
                left++;
            }
        }
        return res;
    }
}
