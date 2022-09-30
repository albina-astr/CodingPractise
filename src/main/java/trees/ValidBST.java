package trees;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 *
 * @author Albina Gimaletdinova on 27/09/2022
 */
public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        return isBst(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isBst(TreeNode root, long from, long to) {
        if (root == null) return true;
        if (root.val <= from || root.val >= to) return false;

        return isBst(root.left, from, root.val) &&
                isBst(root.right, root.val, to);
    }

    // SOLUTION 2
     public boolean isValidBST2(TreeNode root) {
         if (root == null) {
             return true;
         }

         Deque<NodeData> q = new ArrayDeque<>();
         q.add(new NodeData(root, Long.MIN_VALUE, Long.MAX_VALUE));
         while (!q.isEmpty()) {
             NodeData data = q.poll();
             if (!validate(data)) return false;
             if (data.node.left != null) {
                 q.add(new NodeData(data.node.left, data.from, data.node.val));
             }
             if (data.node.right != null) {
                 q.add(new NodeData(data.node.right, data.node.val, data.to));
             }
         }
         return true;
     }

     private boolean validate(NodeData data) {
         TreeNode node = data.node;
         long from = data.from;
         long to = data.to;
         return node.val > from && node.val < to;
     }

    // SOLUTION 3
     public boolean isValidBST3(TreeNode root) {
         return inorder(root);
     }

     private Integer prev = null;
     private boolean inorder(TreeNode root) {
         if (root == null) return true;

         if (!inorder(root.left)) {
             return false;
         }
         if (prev != null && root.val <= prev) {
             return false;
         }

         prev = root.val;

         return inorder(root.right);
     }
}

class NodeData {
    TreeNode node;
    long from;
    long to;

    public NodeData(TreeNode node, long from, long to) {
        this.node = node;
        this.from = from;
        this.to = to;
    }
}
