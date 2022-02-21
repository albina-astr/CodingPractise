package linked_list;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Albina Gimaletdinova on 21/02/2022
 */
public class LinkedListHasCycle {
    // FIRST APPROACH
    // O(n) time & space complexity
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        Set<ListNode> visited = new LinkedHashSet<>();
        while (head != null) {
            if (!visited.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * SECOND APPROACH
     * 2 pointers: slow & fast
     *     slow == fast
     * 2(a+b) = a + b + c
     * 2a + 2b = a + b + c
     *     a + b = c
     */
    public boolean hasCycleWithPointers(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // https://leetcode.com/problems/linked-list-cycle-ii/
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head, slow = head, start = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                while (slow != start) {
                    slow = slow.next;
                    start = start.next;
                }
                return slow;
            }
        }
        return null;
    }
}
