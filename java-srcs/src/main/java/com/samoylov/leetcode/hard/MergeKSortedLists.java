package com.samoylov.leetcode.hard;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/merge-k-sorted-lists/">task link</a>
 */
public class MergeKSortedLists {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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

    public ListNode mergeKLists(ListNode[] lists) {
        Queue<Integer> pq = new PriorityQueue<>();
        for (var head : lists) {
            while (head != null) {
                pq.offer(head.val);
                head = head.next;
            }
        }
        if (pq.isEmpty()) {
            return null;
        }
        var head = new ListNode(pq.poll());
        var cur = head;
        while (!pq.isEmpty()) {
            var newNode = new ListNode(pq.poll());
            cur.next = newNode;
            cur = cur.next;
        }
        return head;
    }
}
