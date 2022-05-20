package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode.com/problems/average-of-levels-in-binary-tree/
 *
 * @author Albina Gimaletdinova on 20/05/2022
 */
public class AverageOfLevels {
    /**
     * space - O(m), where m is the max value of nodes in the tree (last level, f.e.)
     * time TODO
     */
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return List.of();
        }

        List<Double> res = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            long levelSum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                levelSum += cur.val;

                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            res.add((double) levelSum / size);
        }
        return res;
    }
}
