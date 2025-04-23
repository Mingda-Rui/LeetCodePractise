package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC0252MeetingRooms {}

class LC0252Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        int size = 0;
        for (int[] interval : intervals) size = Math.max(size, interval[1]);
        size++;
        boolean[] startTimes = new boolean[size];
        boolean[] endTimes = new boolean[size];
        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            if (startTimes[start] || endTimes[end]) return false;
            startTimes[start] = true;
            endTimes[end] = true;
        }

        int startCounter = 0;
        for (int i = 0; i < size; i++) {
            if (startTimes[i]) startCounter++;
            if (endTimes[i]) startCounter--;
            if (startCounter > 1) return false;
        }
        return true;
    }
}

class PriorityQueueSolution {
    public boolean canAttendMeetings(int[][] intervals) {
        Comparator<int[]> comparator = Comparator.comparingInt(arr -> arr[0]);
        Queue<int[]> queue = new PriorityQueue<>(comparator);
        for (int[] interval : intervals) queue.add(interval);
        int lastFinish = 0;
        while (!queue.isEmpty()) {
            int[] interval = queue.poll();
            if (lastFinish > interval[0]) return false;
            lastFinish = interval[1];
        }
        return true;
    }
}

class SortingSolution {
    public boolean canAttendMeetings(int[][] intervals) {
        Comparator<int[]> comparator = Comparator.comparingInt(arr -> arr[0]);
        Arrays.sort(intervals, comparator);
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) return false;
        }
        return true;
    }
}
