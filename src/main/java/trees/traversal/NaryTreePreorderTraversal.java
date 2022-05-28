package trees.traversal;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/
 *
 * @author Albina Gimaletdinova on 28/05/2022
 */
public class NaryTreePreorderTraversal {
    //recursive
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return List.of();
        }

        List<Integer> res = new ArrayList<>();
        preorderRec(root, res);
        return res;
    }

    private void preorderRec(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        for (Node child : root.children) {
            //carefully with the method name collision !!!
            preorderRec(child, res);
        }
    }

    //iterative
    public List<Integer> preorderIter(Node root) {
        if (root == null) {
            return List.of();
        }

        List<Integer> res = new ArrayList<>();

        Deque<Node> st = new ArrayDeque<>();
        st.push(root);
        while (!st.isEmpty()) {
            Node cur = st.pop();
            res.add(cur.val);
            for (int i = cur.children.size() - 1; i >= 0; i--) {
                st.push(cur.children.get(i));
            }
        }
        return res;
    }
}
