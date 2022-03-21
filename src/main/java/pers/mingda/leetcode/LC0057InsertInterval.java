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
            if (next == null || (index < intervals.length && current[0] < next[0]) ) {
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
        if (!result.isEmpty() && last[1] >= interval[0])
            last[1] = Math.max(last[1], interval[1]);
        else
            result.add(interval);
    }
}
