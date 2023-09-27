package leetcode_solutions;

import leetcode_solutions.common.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

// https://leetcode.com/problems/reverse-linked-list/
class ReverseLinkedListTest {
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode nextCurrent = null;
        ListNode current = head;

        while (current != null) {
            nextCurrent = current.next;
            current.next = previous;
            previous = current;
            current = nextCurrent;
        }

        return previous;
    }

    @Test
    void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode.printList(head); // 1 -> 2 -> 3 -> 4 -> 5
        List<Integer> values = ListNode.toList(head);
        ListNode reversed = reverseList(head);
        ListNode.printList(reversed); // 5 -> 4 -> 3 -> 2 -> 1
        List<Integer> reversedValues = ListNode.toList(reversed);
        assertArrayEquals(values.reversed().toArray(), reversedValues.toArray());
    }
}
