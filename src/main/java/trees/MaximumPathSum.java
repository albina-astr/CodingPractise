package trees;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 *
 * @author Albina Gimaletdinova on 01/05/2022
 */
public class MaximumPathSum {
    //solution 1
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        sum(root);
        return maxSum;
    }

    private int sum(TreeNode root) {
        if (root == null) return 0;

        //так отсекаем отрицательные числа
        int leftSum = Math.max(sum(root.left), 0);
        int rightSum = Math.max(sum(root.right), 0);

        int levelSum = leftSum + rightSum + root.val;
        maxSum = Math.max(maxSum, levelSum);

        return root.val + Math.max(leftSum, rightSum);
    }
}
