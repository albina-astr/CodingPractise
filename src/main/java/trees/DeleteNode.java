package trees;

/**
 * https://leetcode.com/problems/delete-node-in-a-bst/
 *
 * @author Albina Gimaletdinova on 08/06/2022
 */
public class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            if (root.left == null) root = root.right;
            else if (root.right == null) root = root.left;
            else {
                TreeNode min = findMin(root.right);
                root.val = min.val;
                root.right = deleteNode(root.right, min.val);
            }
        }
        return root;
    }

    private TreeNode findMin(TreeNode root) {
        while (root != null && root.left != null) {
            root = root.left;
        }
        return root;
    }
}
