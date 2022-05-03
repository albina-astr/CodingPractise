package trees;

/**
 * https://leetcode.com/problems/path-sum/
 *
 * @author Albina Gimaletdinova on 01/05/2022
 */
public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return checkSum(root, targetSum);
    }

    private boolean checkSum(TreeNode root, int sum) {
        if (root == null) return false;

        if (root.left == null && root.right == null) {
            return sum - root.val == 0;
        }

        boolean leftRes = checkSum(root.left, sum - root.val);
        boolean rightRes = checkSum(root.right, sum - root.val);

        return leftRes || rightRes;
    }
}
