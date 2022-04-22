package linked_list;

/**
 * https://leetcode.com/problems/remove-linked-list-elements/
 *
 * @author Albina Gimaletdinova on 22/04/2022
 */
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = head, prev = dummy;
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
