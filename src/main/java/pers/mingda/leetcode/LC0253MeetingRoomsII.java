package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class LC0253MeetingRoomsII {

}

class LC0253Solution {
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

class TreeMapSolution {
    public int minMeetingRooms(int[][] intervals) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] interval: intervals) {
            int start = interval[0];
            int end = interval[1];
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
        }

        int maxRooms = 0;
        int rooms = 0;
        for (int count: map.values()) {
            rooms += count;
            maxRooms = Math.max(maxRooms, rooms);
        }
        return maxRooms;
    }
}
