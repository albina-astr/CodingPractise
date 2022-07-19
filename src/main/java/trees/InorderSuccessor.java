package trees;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/inorder-successor-in-bs
 *
 * @author Albina Gimaletdinova on 19/07/2022
 */
public class InorderSuccessor {
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
}
