package trees;

/**
 * https://leetcode.com/problems/range-sum-of-bst/
 *
 * @author Albina Gimaletdinova on 02/09/2022
 */
public class RangeSumBST {
    private int left;
    private int right;
    private int sum = 0;

    public int rangeSumBST(TreeNode root, int left, int right) {
        if (root == null) {
            return sum;
        }

        this.left = left;
        this.right = right;
        inorder(root);

        return sum;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;

        if (root.val >= left && root.val <= right) {
            sum += root.val;
        }
        if (root.val > left) inorder(root.left);
        if (root.val < right) inorder(root.right);
    }
}
