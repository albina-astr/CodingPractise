package trees.traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/
 *
 * @author Albina Gimaletdinova on 28/05/2022
 */
public class NaryTreeLevelOrderTraversal {
    //solution 1
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return List.of();
        }

        List<List<Integer>> res = new ArrayList<>();

        Deque<Node> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                level.add(cur.val);
                //for (Node child : cur.children) {
                //  q.offer(child);
                //}
                q.addAll(cur.children);
            }
            res.add(level);
        }
        return res;
    }

    //solution 2
    public List<List<Integer>> levelOrder2(Node root) {
        if (root == null) {
            return List.of();
        }

        List<List<Integer>> res = new ArrayList<>();

        Deque<Node> prevLayer = new ArrayDeque<>();
        prevLayer.offer(root);
        while (!prevLayer.isEmpty()) {
            Deque<Node> curLayer = new ArrayDeque<>();
            List<Integer> prevVals = new ArrayList<>();
            for (Node node : prevLayer) {
                prevVals.add(node.val);
                curLayer.addAll(node.children);
            }
            res.add(prevVals);
            prevLayer = curLayer;
        }
        return res;
    }
}
