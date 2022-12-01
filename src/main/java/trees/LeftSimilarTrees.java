package trees;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/leaf-similar-trees/
 *
 * @author Albina Gimaletdinova on 01/12/2022
 */
public class LeftSimilarTrees {
    private List<Integer> leaf1 = new ArrayList<>();
    private List<Integer> leaf2 = new ArrayList<>();

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        inorder(root1, leaf1);
        inorder(root2, leaf2);
        return leaf1.equals(leaf2);
    }

    private void inorder(TreeNode root, List<Integer> leafs) {
        if (root == null) {
            return;
        }

        inorder(root.left, leafs);
        if (root.left == null && root.right == null) {
            leafs.add(root.val);
        }
        inorder(root.right, leafs);
    }
}
