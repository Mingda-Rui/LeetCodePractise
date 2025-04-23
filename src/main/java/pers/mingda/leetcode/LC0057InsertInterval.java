package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.List;

public class LC0057InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new LinkedList<>();
        int index = 0;
        while (index < intervals.length || newInterval != null) {
            int[] next = newInterval;
            newInterval = null;
            int[] current = index < intervals.length ? intervals[index] : null;
            if (next == null || (index < intervals.length && current[0] < next[0])) {
                newInterval = next;
                next = current;
                index++;
            }
            addInterval(result, next);
        }

        return result.toArray(int[][]::new);
    }

    private void addInterval(List<int[]> result, int[] interval) {
        int[] last = result.isEmpty() ? null : result.get(result.size() - 1);
        if (!result.isEmpty() && last[1] >= interval[0]) last[1] = Math.max(last[1], interval[1]);
        else result.add(interval);
    }

    public int[][] insertRefactored(int[][] intervals, int[] newInterval) {
        List<int[]> result = new LinkedList<>();

        int[] next = newInterval;
        for (int[] interval : intervals) {
            if (interval[1] < next[0]) result.add(interval);
            else if (next[1] < interval[0]) {
                result.add(next);
                next = interval;
            } else {
                next[0] = Math.min(next[0], interval[0]);
                next[1] = Math.max(next[1], interval[1]);
            }
        }
        result.add(next);

        return result.toArray(int[][]::new);
    }

    public int[][] insertFastestSolution(int[][] intervals, int[] newInterval) {
        List<int[]> result = new LinkedList<>();
        int index = 0;
        int length = intervals.length;
        int newStart = newInterval[0];
        int newEnd = newInterval[1];
        while (index < length && intervals[index][1] < newStart) {
            result.add(intervals[index]);
            index++;
        }
        while (index < length && intervals[index][0] <= newEnd) {
            newStart = Math.min(intervals[index][0], newStart);
            newEnd = Math.max(intervals[index][1], newEnd);
            index++;
        }
        newInterval[0] = newStart;
        newInterval[1] = newEnd;
        result.add(newInterval);
        while (index < length) {
            result.add(intervals[index]);
            index++;
        }
        return result.toArray(int[][]::new);
    }
}
