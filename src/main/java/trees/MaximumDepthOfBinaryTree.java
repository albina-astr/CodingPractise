package trees;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 * @author Albina Gimaletdinova on 19/05/2022
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);

        int depth = 0, nodesOnLevel = 0;
        while (!dq.isEmpty()) {
            depth++;
            nodesOnLevel = dq.size();
            for (int i = 0; i < nodesOnLevel; i++) {
                TreeNode cur = dq.poll();
                if (cur.left != null) dq.offer(cur.left);
                if (cur.right != null) dq.offer(cur.right);
            }
        }
        return depth;
    }
}
