package trees;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. Binary Tree Preorder Traversal
 * https://leetcode.com/problems/binary-tree-preorder-traversal
 *
 * @author Albina Gimaletdinova on 25/02/2022
 */
public class PreOrderTraversal {
    public List<Integer> preorderTraversal(TreeNode node) {
        List<Integer> result = new ArrayList<>();
        helper(node, result);
        return result;
    }

    private void helper(TreeNode node, List<Integer> res) {
        if (node != null) {
            res.add(node.val);
            if (node.left != null) helper(node.left, res);
            if (node.right != null) helper(node.right, res);
        }
    }
}
