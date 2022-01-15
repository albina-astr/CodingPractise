package linked_list;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 *
 * @author Albina Gimaletdinova on 15/01/2022
 */
public class IntersectionOfLinkedLists {
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        ListNode pA = a;
        ListNode pB = b;

        while (pA != pB) {
            pA = pA == null ? b : pA.next;
            pB = pB == null ? a : pB.next;
        }
        return pA;
    }
}
