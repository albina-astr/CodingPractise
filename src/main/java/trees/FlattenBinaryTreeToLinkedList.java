package trees;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 *
 * @author Albina Gimaletdinova on 28/04/2022
 */
public class FlattenBinaryTreeToLinkedList {
    //solution 1
    public void flatten(TreeNode root) {
        flattenRec(root);
    }

    private TreeNode flattenRec(TreeNode root) {
        if (root == null) return null;
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode leftTail = flattenRec(root.left);
        TreeNode rightTail = flattenRec(root.right);

        if (leftTail != null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        return rightTail == null ? leftTail : rightTail;
    }

    //solution 2
    public void flatten2(TreeNode root) {
        if (root == null) return;

        TreeNode node = root;
        while (node != null) {
            if (node.left != null) {
                TreeNode rightmost = node.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }

                rightmost.right = node.right;
                node.right = node.left;
                node.left = null;
            }
            node = node.right;
        }
    }
}
