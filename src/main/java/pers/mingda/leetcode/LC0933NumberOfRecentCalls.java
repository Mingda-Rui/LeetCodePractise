package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
public class LC0933NumberOfRecentCalls {}

class RecentCounter {

    private static final int DURATION_MILLI = 3000;
    private final List<Integer> pingHistory;

    public RecentCounter() {
        this.pingHistory = new ArrayList<>();
    }

    public int ping(int t) {
        pingHistory.add(t);
        int len = pingHistory.size();
        int target = Math.max(0, t - DURATION_MILLI);
        if (target == 0) {
            return len;
        }
        int startIndex = find(target);
        return len - startIndex;
    }

    private int find(int t) {
        return find(t, 0, pingHistory.size());
    }

    private int find(int t, int start, int end) {
        if (start + 1 == end) {
            return pingHistory.get(start) == t || (start == 0 && pingHistory.get(start) > t) ? start : end;
        }

        int mid = (start + end) / 2;
        int val = pingHistory.get(mid);
        if (val < t) {
            return find(t, mid, end);
        } else if (val > t) {
            return find(t, start, mid);
        }
        // val == t
        return mid;
    }
}

class RecentCounterSlideWindow {
    private static final int DURATION_MILLI = 3000;
    private final Queue<Integer> queue;

    public RecentCounterSlideWindow() {
        this.queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.offer(t);

        int startT = t - DURATION_MILLI;
        while (!queue.isEmpty() && queue.peek() < startT) {
            queue.poll();
        }
        return queue.size();
    }
}
