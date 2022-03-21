package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.List;

public class LC0057InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new LinkedList<>();
        boolean newIntervalMerged = false;
        if (intervals.length == 0)
            return new int[][]{newInterval};
        for (int i = 0; i < intervals.length; i++) {
            int[] current = intervals[i];
            if (!newIntervalMerged && newInterval[0] < current[0]) {
                current = newInterval;
                newIntervalMerged = true;
                i--;
            }
            addInterval(result, current);
        }
        if (!newIntervalMerged)
            addInterval(result, newInterval);
        return result.toArray(int[][]::new);
    }

    private void addInterval(List<int[]> result, int[] interval) {
        if (result.isEmpty())
            result.add(interval);
        else {
            int[] last = result.get(result.size() - 1);
            if (last[1] < interval[0])
                result.add(interval);
            else
                last[1] = Math.max(last[1], interval[1]);
        }
    }
}
