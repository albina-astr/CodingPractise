package trees;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * @author Albina Gimaletdinova on 27/06/2022
 */
public class ConstructTreeFromPreorder {
    private Map<Integer, Integer> inorderMap;
    private int[] inorder;
    private int[] preorder;
    private int rootIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;

        this.inorderMap = new HashMap<>();
        this.inorder = inorder;
        this.preorder = preorder;
        this.rootIndex = 0;

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(rootIndex, preorder.length - 1);
    }

    private TreeNode buildTree(int low, int hi) {
        if (low > hi) return null;

        int rootVal = preorder[rootIndex];
        TreeNode root = new TreeNode(rootVal);
        rootIndex++;

        int pivotInorderIndex = inorderMap.get(rootVal);
        root.left = buildTree(low, pivotInorderIndex - 1);
        root.right = buildTree(pivotInorderIndex + 1, hi);
        return root;
    }
}
