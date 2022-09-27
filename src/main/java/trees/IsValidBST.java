package trees;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 *
 * @author Albina Gimaletdinova on 27/09/2022
 */
public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return isBst(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isBst(TreeNode root, long from, long to) {
        if (root == null) return true;
        if (root.val <= from || root.val >= to) return false;

        return isBst(root.left, from, root.val) &&
                isBst(root.right, root.val, to);
    }
}
