package array;

/**
 * https://leetcode.com/problems/first-missing-positive/
 *
 * @author Albina Gimaletdinova on 04/03/2023
 */
public class FirstMissingPositive {
    /**
     [1, 4, 7, 5, 1, -1,4]
     [1, 4, 7, 5, 1, 8, 4]
     [-1,4, 7,-5, -1, 8, -4]

     time O(n)
     space O(1)
     **/
    public int firstMissingPositive(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Input array must not be null!");
        }
        if (arr.length == 0) {
            return 1;
        }

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] < 1 || arr[i] > n) {
                arr[i] = n + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            int index = Math.abs(arr[i]);
            if (index - 1 < n) {
                arr[index - 1] = - Math.abs(arr[index - 1]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }
}
