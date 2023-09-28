package leetCodeSolutions.linkedList;

import leetCodeSolutions.common.ListNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

// https://leetcode.com/problems/merge-two-sorted-lists/
class MergeTwoSortedListsTest {
    ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (list1 != null || list2 != null) {
            if (list1 == null || (list2 != null && list1.val >= list2.val)) {
                current.next = list2;
                current = list2;
                list2 = list2.next;
            } else {
                current.next = list1;
                current = list1;
                list1 = list1.next;
            }
        }
        return dummy.next;
    }

    @Test
    void test() {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        ListNode.printList(list1);
        ListNode.printList(list2);
        ListNode mergedList = mergeTwoLists(list1, list2);
        ListNode.printList(mergedList);
        List<Integer> mergedValues = ListNode.toList(mergedList);
        assertArrayEquals(List.of(1, 1, 2, 3, 4, 4).toArray(), mergedValues.toArray());
    }

    @Test
    void testEmptyLists() {
        ListNode mergedList = mergeTwoLists(null, null);
        ListNode.printList(mergedList);
        List<Integer> mergedValues = ListNode.toList(mergedList);
        assertArrayEquals(List.of().toArray(), mergedValues.toArray());
    }

    @Test
    void testSingleNode() {
        ListNode mergedList = mergeTwoLists(null, new ListNode(0));
        ListNode.printList(mergedList);
        List<Integer> mergedValues = ListNode.toList(mergedList);
        assertArrayEquals(List.of(0).toArray(), mergedValues.toArray());
    }
}
