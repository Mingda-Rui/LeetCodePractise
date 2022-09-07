package pers.mingda.leetcode;

public class LC0252MeetingRooms {

}

class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        int size = 0;
        for (int[] interval: intervals)
            size = Math.max(size, interval[1]);
        size++;
        boolean[] startTimes = new boolean[size];
        boolean[] endTimes = new boolean[size];
        for (int[] interval: intervals) {
            int start = interval[0];
            int end = interval[1];
            if (startTimes[start] || endTimes[end])
                return false;
            startTimes[start] = true;
            endTimes[end] = true;
        }

        int startCounter = 0;
        for (int i = 0; i < size; i++) {
            if (startTimes[i])
                startCounter++;
            if (endTimes[i])
                startCounter--;
            if (startCounter > 1)
                return false;
        }
        return true;
    }
}
