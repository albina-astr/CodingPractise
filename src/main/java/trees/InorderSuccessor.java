package trees;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/inorder-successor-in-bs
 *
 * @author Albina Gimaletdinova on 19/07/2022
 */
public class InorderSuccessor {
    //solution 1
    List<TreeNode> all = new ArrayList<>();

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inorder(root);

        for (int i = 0; i < all.size(); i++) {
            if (all.get(i) == p) {
                if (i + 1 < all.size()) {
                    return all.get(i + 1);
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        all.add(root);
        inorder(root.right);
    }

    //solution 2
    private TreeNode prev = null;
    private TreeNode res = null;

    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }

        if (p.right != null) {
            TreeNode leftmost = p.right;
            while (leftmost.left != null) {
                leftmost = leftmost.left;
            }
            return leftmost;
        }
        inorder(root, p);
        return res;
    }

    private void inorder(TreeNode root, TreeNode p) {
        if (root == null) return;

        inorder(root.left, p);
        if (prev == p && res == null) {
            res = root;
            return;
        }
        prev = root;
        inorder(root.right, p);
    }

    //solution 3
    public TreeNode inorderSuccessor3(TreeNode root, TreeNode p) {
        if (root == null) return null;

        TreeNode successor = null;
        while (root != null) {
            if (p.val >= root.val) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }

        return successor;
    }
}
