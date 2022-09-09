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

        int endIndex = 0;
        int maxRooms = 0;
        for (int startIndex = 0; startIndex < startTime.length; startIndex++) {
            if (startTime[startIndex] < endTime[endIndex])
                maxRooms++;
            else
                endIndex++;
        }

        return maxRooms;
    }
}
