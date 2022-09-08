package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC0253MeetingRoomsII {

}

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        List<Integer> startTime = new ArrayList<>(intervals.length);
        List<Integer> endTime = new ArrayList<>(intervals.length);
        for (int i = 0; i < intervals.length; i++) {
            startTime.add(intervals[i][0]);
            endTime.add(intervals[i][1]);
        }
        Collections.sort(startTime);
        Collections.sort(endTime);

        int maxOverlap = 0;
        int overlap = 0;
        int start = 0;
        int end = 0;
        while (start < intervals.length) {
            if (startTime.get(start) < endTime.get(end)) {
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
