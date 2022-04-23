package linked_list;

/**
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 *
 * @author Albina Gimaletdinova on 23/04/2022
 */
public class DeleteNode {
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}
