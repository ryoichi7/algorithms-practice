package com.samoylov.leetcode.easy;

/**
 * <a href="https://leetcode.com/problems/merge-sorted-array/description/">task link</a>
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        var ptr1 = m - 1;
        var ptr2 = n - 1;
        while (ptr1 >= 0 && ptr2 >= 0) {
            if (nums1[ptr1] < nums2[ptr2]) {
                nums1[ptr1 + ptr2 + 1] = nums2[ptr2];
                ptr2--;
            } else {
                nums1[ptr1 + ptr2 + 1] = nums1[ptr1];
                ptr1--;
            }
        }
        while (ptr2 >= 0) {
            nums1[ptr2] = nums2[ptr2];
            ptr2--;
        }
    }
}
