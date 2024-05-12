package com.samoylov.leetcode.medium;

/**
 * <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/">task link</a>
 */
public class RemoveNthNodeFromEndOfList {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        var size = 0;
        var cur = head;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        var target = size - n;
        cur = head;
        var prev = head;
        for (var i = 0; i < target; ++i) {
            prev = cur;
            cur = cur.next;
        }
        if (target == 0) {
            head = prev.next;
        }
        prev.next = cur.next;
        return head;
    }
}
