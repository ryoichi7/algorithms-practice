package com.samoylov.leetcode.easy;

/**
 * <a href="https://leetcode.com/problems/merge-two-sorted-lists/description/">task link</a>
 */
public class MergeTwoSortedLists {

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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        var cur = new ListNode();
        var result = cur;
        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    cur.next = new ListNode(list1.val);
                    list1 = list1.next;
                } else {
                    cur.next = new ListNode(list2.val);
                    list2 = list2.next;
                }
            } else if (list1 != null) {
                cur.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                cur.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            cur = cur.next;
        }
        return result.next;
    }
}
