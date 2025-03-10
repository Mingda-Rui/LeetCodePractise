package pers.mingda.leetcode;

public class LC1851MinimumIntervalToIncludeEachQuery {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = findSmallest(intervals, queries[i]);
        }
        return result;
    }

    private int findSmallest(int[][] intervals, int query) {
        int min = Integer.MAX_VALUE;
        for (int[] interval: intervals) {
            if (isInclude(interval, query)) {
                int size = getSize(interval);
                min = Math.min(size, min);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private boolean isInclude(int[] interval, int query) {
        return interval[0] <= query && interval[1] >= query;
    }

    private int getSize(int[] interval) {
        return interval[1] - interval[0] + 1;
    }
}
