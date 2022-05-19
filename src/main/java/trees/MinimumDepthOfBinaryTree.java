package trees;

/**
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 *
 * @author Albina Gimaletdinova on 19/05/2022
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }
}
