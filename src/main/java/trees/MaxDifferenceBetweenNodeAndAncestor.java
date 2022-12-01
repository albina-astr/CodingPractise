package trees;

/**
 * https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 *
 * @author Albina Gimaletdinova on 01/12/2022
 */
public class MaxDifferenceBetweenNodeAndAncestor {
    // record the required maximum difference
    int result = 0;

    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        result = 0;
        return dfs(root, root.val, root.val);
        // return result;
    }

    private void helper(TreeNode node, int curMax, int curMin) {
        if (node == null) {
            return;
        }
        int candidate = Math.max(Math.abs(curMax - node.val), Math.abs(curMin - node.val));
        result = Math.max(result, candidate);
        // update the max and min
        curMax = Math.max(curMax, node.val);
        curMin = Math.min(curMin, node.val);
        helper(node.left, curMax, curMin);
        helper(node.right, curMax, curMin);
        return;
    }

    private int dfs(TreeNode node, int aMax, int aMin) {
        if (node == null) {
            return 0;
        }
        int candidate = Math.max(Math.abs(aMax - node.val), Math.abs(aMin - node.val));
        // result = Math.max(result, candidate);
        aMax = Math.max(aMax, node.val);
        aMin = Math.min(aMin, node.val);

        return Math.max(candidate,
                Math.max(dfs(node.left, aMax, aMin), dfs(node.right, aMax, aMin)));
    }
}
