package leetCodeSolutions.common;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.printf("%s", current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            } else {
                System.out.println();
            }
            current = current.next;
        }
    }

    public static List<Integer> toList(ListNode head) {
        List<Integer> values = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            values.add(current.val);
            current = current.next;
        }
        return values;
    }
}
