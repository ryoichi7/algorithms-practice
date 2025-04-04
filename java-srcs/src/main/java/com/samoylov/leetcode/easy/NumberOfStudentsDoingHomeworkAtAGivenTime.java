package com.samoylov.leetcode.easy;

/**
 * <a href="https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time">task link</a>
 */
public class NumberOfStudentsDoingHomeworkAtAGivenTime {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        var studentsCnt = 0;
        for (var i = 0; i < startTime.length; ++i) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                studentsCnt++;
            }
        }
        return studentsCnt;
    }
}
