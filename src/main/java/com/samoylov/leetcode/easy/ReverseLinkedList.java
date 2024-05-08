package com.samoylov.leetcode.easy;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list/description/">task link</a>
 */
public class ReverseLinkedList {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        var cur = head;
        var prev = new ListNode(head.val, null);
        while (cur.next != null) {
            cur = cur.next;
            var next = new ListNode(cur.val, cur.next);
            next.next = prev;
            prev = next;
        }
        return prev;
    }
}
