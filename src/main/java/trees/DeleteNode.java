package trees;

/**
 * https://leetcode.com/problems/delete-node-in-a-bst/
 *
 * @author Albina Gimaletdinova on 08/06/2022
 */
public class DeleteNode {
    // solution 1 with replacing node value
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

    // solution 2 - find min in right subtree and connect it with the left subtree
    public TreeNode deleteNode2(TreeNode root, int key) {
        if (root == null) return root;
        if (root.val < key)
            root.right = deleteNode2(root.right, key);
        else if (root.val > key)
            root.left = deleteNode2(root.left, key);
        else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            TreeNode minRight = findMin(root.right);
            minRight.left = root.left;
            root = root.right;
        }
        return root;
    }
}
