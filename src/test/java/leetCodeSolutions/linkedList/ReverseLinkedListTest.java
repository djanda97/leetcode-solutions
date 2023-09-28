package leetCodeSolutions.linkedList;

import leetCodeSolutions.common.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

// https://leetcode.com/problems/reverse-linked-list/
class ReverseLinkedListTest {
    ListNode reverseList(ListNode head) {
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
        ListNode.printList(head);
        ListNode reversed = reverseList(head);
        ListNode.printList(reversed);
        List<Integer> reversedValues = ListNode.toList(reversed);
        assertArrayEquals(List.of(1, 2, 3, 4, 5).reversed().toArray(), reversedValues.toArray());
    }

    @Test
    void testSingleNode() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode.printList(head);
        ListNode reversed = reverseList(head);
        ListNode.printList(reversed);
        List<Integer> reversedValues = ListNode.toList(reversed);
        assertArrayEquals(List.of(1, 2).reversed().toArray(), reversedValues.toArray());
    }

    @Test
    void testEmptyList() {
        ListNode reversed = reverseList(null);
        ListNode.printList(reversed);
        List<Integer> reversedValues = ListNode.toList(reversed);
        assertArrayEquals(List.of().toArray(), reversedValues.toArray());
    }
}
