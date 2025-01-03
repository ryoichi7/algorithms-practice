package com.samoylov.leetcode.easy;

/**
 * <a href="https://leetcode.com/problems/palindrome-linked-list/description/">task link</a>
 */
public class PalindromeLinkedList {
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

    public boolean isPalindrome(ListNode head) {
        var size = 0;
        var cur = head;
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        cur = head;
        var i = 0;
        while (i < size / 2) {
            cur = cur.next;
            i++;
        }
        if (size % 2 == 1) {
            cur = cur.next;
        }
        cur = reverse(cur);
        while (cur != null) {
            if (cur.val != head.val) {
                return false;
            }
            cur = cur.next;
            head = head.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        var cur = head;
        while (cur != null) {
            var next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
