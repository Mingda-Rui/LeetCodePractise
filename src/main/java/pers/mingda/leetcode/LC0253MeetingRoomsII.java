package pers.mingda.leetcode;

import java.util.Arrays;

public class LC0253MeetingRoomsII {

}

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int[] startTime = new int[intervals.length];
        int[] endTime = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            startTime[i] = intervals[i][0];
            endTime[i] = intervals[i][1];
        }
        Arrays.sort(startTime);
        Arrays.sort(endTime);

        int maxOverlap = 0;
        int overlap = 0;
        int start = 0;
        int end = 0;
        while (start < intervals.length) {
            if (startTime[start] < endTime[end]) {
                overlap++;
                start++;
            } else {
                overlap--;
                end++;
            }
            maxOverlap = Math.max(maxOverlap, overlap);
        }
        return maxOverlap;
    }
}
