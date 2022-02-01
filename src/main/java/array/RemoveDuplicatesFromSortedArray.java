package array;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * @author Albina Gimaletdinova on 01/02/2022
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] arr) {
        int lastUniqueElementIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[lastUniqueElementIndex] != arr[i]) {
                arr[++lastUniqueElementIndex] = arr[i];
            }
        }
        return lastUniqueElementIndex + 1;
    }
}
