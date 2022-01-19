package linked_list;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 *
 * @author Albina Gimaletdinova on 19/01/2022
 */
public class MergeTwoSortedLinkedLists {
    /**
     * O(n + m) - time complexity
     * O(1) - space complexity
     */
    public ListNode mergeTwoLists(ListNode p1, ListNode p2) {
        if (p1 == null) return p2;
        if (p2 == null) return p1;

        ListNode prehead = new ListNode(-1);
        ListNode res = prehead;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                res.next = p1;
                p1 = p1.next;
            } else {
                res.next = p2;
                p2 = p2.next;
            }
            res = res.next;
        }

        res.next = p1 == null ? p2 : p1;

        return prehead.next;
    }

    /**
     * RECURSIVE:
     * O(n + m) - time complexity
     * O(n + m) - space complexity
     */
    public ListNode mergeTwoListsRecursive(ListNode p1, ListNode p2) {
        if (p1 == null) return p2;
        else if (p2 == null) return p1;
        else if (p1.val < p2.val) {
            p1.next = mergeTwoListsRecursive(p1.next, p2);
            return p1;
        } else {
            p2.next = mergeTwoListsRecursive(p1, p2.next);
            return p2;
        }
    }
}
