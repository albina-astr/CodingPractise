package trees;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 *
 * @author Albina Gimaletdinova on 20/09/2022
 */
public class SortedListToBST {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        List<ListNode> nodes = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            nodes.add(cur);
            cur = cur.next;
        }

        return buildTree(nodes, 0, nodes.size() - 1);
    }

    private TreeNode buildTree(List<ListNode> nodes,
                               int from, int to) {
        if (from > to) {
            return null;
        }

        int mid = from + (to - from) / 2;
        TreeNode root = new TreeNode(nodes.get(mid).val);
        root.left = buildTree(nodes, from, mid - 1);
        root.right = buildTree(nodes, mid + 1, to);
        return root;
    }
}
