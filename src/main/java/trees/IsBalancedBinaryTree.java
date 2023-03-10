package trees;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 *
 * @author Albina Gimaletdinova on 15/05/2022
 */
public class IsBalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int left = height(root.left);
        int right = height(root.right);

        return Math.abs(left - right) <= 1 &&
                isBalanced(root.left) &&
                isBalanced(root.right);
    }

    private int height(TreeNode root) {
        if (root == null) return -1;

        int l = height(root.left);
        int r = height(root.right);

        return Math.max(l, r) + 1;
    }
}
