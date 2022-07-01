package trees;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 *
 * @author Albina Gimaletdinova on 01/07/2022
 */
public class PopulateRightPointers {
    public Node connect(Node root) {
        if (root == null) return root;

        Deque<Node> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                if (i == size - 1) cur.next = null;
                else cur.next = q.peek();

                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
