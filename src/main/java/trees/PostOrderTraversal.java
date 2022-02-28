package trees;

import java.util.ArrayList;
import java.util.List;

/**
 * 145. Binary Tree Postorder Traversal.
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 *
 * @author Albina Gimaletdinova on 10/02/2022
 */
class PostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    private void postorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }
}
