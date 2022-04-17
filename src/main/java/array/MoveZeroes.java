package array;

/**
 * https://leetcode.com/problems/move-zeroes/
 *
 * @author Albina Gimaletdinova on 17/04/2022
 */
public class MoveZeroes {
    //solution 1
    public void moveZeroes(int[] nums) {
        int zeros = 0;
        int actualIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
                continue;
            }
            nums[actualIndex++] = nums[i];
        }
        for (int i = nums.length - 1; i >= nums.length - zeros; i--) {
            nums[i] = 0;
        }
    }

    //solution 2
    public void moveZeroes2(int[] nums) {
        int lastNonZeroElement = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroElement++] = nums[i];
                nums[i] = 0;
            }
        }
    }
}
