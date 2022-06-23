package trees;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 * @author Albina Gimaletdinova on 23/06/2022
 */
public class ConstructTree {
    private Map<Integer, Integer> inMap = new HashMap<>();
    private int[] inorder;
    private int[] postorder;
    private int rootIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        this.rootIndex = postorder.length - 1;

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return buildTree(0, rootIndex);
    }

    private TreeNode buildTree(int low, int hi) {
        if (low > hi) return null;

        int rootVal = postorder[rootIndex];
        TreeNode root = new TreeNode(rootVal);

        int index = inMap.get(rootVal);
        rootIndex--;

        root.right = buildTree(index + 1,hi);
        root.left = buildTree(low, index -1);
        return root;
    }
}
