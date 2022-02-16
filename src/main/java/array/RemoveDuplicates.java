package array;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 *
 * @author Albina Gimaletdinova on 16/02/2022
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] arr) {
        int i = 0;
        for (int curr : arr) {
            if (i < 2 || curr > arr[i - 2]) {
                arr[i++] = curr;
            }
        }
        return i;
    }
}
