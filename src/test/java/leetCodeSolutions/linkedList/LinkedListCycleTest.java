package leetCodeSolutions.linkedList;

import leetCodeSolutions.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// https://leetcode.com/problems/linked-list-cycle/
class LinkedListCycleTest {
    boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    @Test
    void test() {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4, head.next);
        assertTrue(hasCycle(head));
    }

    @Test
    void testTwoNodes() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2, head);
        assertTrue(hasCycle(head));
    }

    @Test
    void testSingleNode() {
        assertFalse(hasCycle(new ListNode(1)));
    }
}
