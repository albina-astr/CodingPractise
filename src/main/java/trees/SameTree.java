package trees;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/same-tree/
 *
 * @author Albina Gimaletdinova on 30/09/2022
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        Deque<TreeNode> q1 = new ArrayDeque<>();
        Deque<TreeNode> q2 = new ArrayDeque<>();
        q1.add(p);
        q2.add(q);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode first = q1.poll();
            TreeNode second = q2.poll();
            // check that some node can be null
            // if the check passes: both nodes are null or both nodes are not null
            if (!equalNodes(first, second)) return false;

            if (!equalNodes(first.left, second.left)) return false;
            if (first.left != null) {
                q1.add(first.left);
                q2.add(second.left);
            }

            if (!equalNodes(first.right, second.right)) return false;
            if (first.right != null) {
                q1.add(first.right);
                q2.add(second.right);
            }

        }
        return true;
    }

    private boolean equalNodes(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val;
    }
}
