package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LC0435NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Comparator<int[]> comparator = Comparator.comparingInt(i -> i[0]);
        Arrays.sort(intervals, comparator);

        int counter = 0;
        int headIndex = 0;
        for (int i = headIndex + 1; i < intervals.length; i++) {
            int[] head = intervals[headIndex];
            int[] next = intervals[i];

            if (next[0] < head[1])
                counter++;
            if (head[1] <= next[0] || next[1] <= head[1])
                headIndex = i;

        }
        return counter;
    }

    public int eraseOverlapIntervalsSortEnd(int[][] intervals) {
        Comparator<int[]> comparator = Comparator.comparingInt(i -> i[1]);
        Arrays.sort(intervals, comparator);

        int counter = 0;
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            if (current[0] < prevEnd)
                counter++;
            else
                prevEnd = current[1];
        }

        return counter;
    }
}
