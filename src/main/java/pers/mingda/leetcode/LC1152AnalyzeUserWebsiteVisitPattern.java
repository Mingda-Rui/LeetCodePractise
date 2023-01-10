package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class LC1152AnalyzeUserWebsiteVisitPattern {

}

class LC1152Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {

        Map<List<String>, Integer> patterns = new HashMap<>();
        Map<String, List<TimestampWebsite>> history = new HashMap<>();
        for (int i = 0; i < username.length; i++) {
            String user = username[i];
            history.putIfAbsent(user, new LinkedList<>());
            TimestampWebsite tsw = new TimestampWebsite(timestamp[i], website[i]);
            history.get(user).add(tsw);
        }

        for (List<TimestampWebsite> historyForUser: history.values())
            buildPattern(historyForUser, patterns);

        List<String> result = null;
        int maxCount = 0;
        for (List<String> maxPattern: patterns.keySet()) {
            if (maxPattern.size() < 3)
                continue;
            int count = patterns.get(maxPattern);
            if (count > maxCount) {
                maxCount = count;
                result = maxPattern;
            } else if (count == maxCount) {
                result = getSmaller(result, maxPattern);
            }
        }

        return result;
    }

    private void buildPattern(List<TimestampWebsite> tsHistory, Map<List<String>, Integer> patterns) {
        Queue<TimestampWebsite> queue = new PriorityQueue<>(Comparator.comparingInt(tsw -> tsw.timestamp));
        for (TimestampWebsite tsw: tsHistory)
            queue.offer(tsw);
        List<String> history = new ArrayList<>();
        while (!queue.isEmpty())
            history.add(queue.poll().website);
        int len = history.size();
        Set<List<String>> seen = new HashSet<>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                for (int k = j + 1; k < len; k++) {
                    List<String> pattern = Arrays.asList(history.get(i), history.get(j), history.get(k));
                    if (!seen.contains(pattern)) {
                        int count = patterns.getOrDefault(pattern, 0);
                        patterns.put(pattern, count + 1);
                    }
                    seen.add(pattern);
                }
            }
        }
    }

    private List<String> getSmaller(List<String> pattern1, List<String> pattern2) {
        for (int i = 0; i < 3; i++) {
            int result = compareNthItem(pattern1, pattern2, i);
            if (result != 0)
                return result > 0 ? pattern2 : pattern1;
        }
        return pattern1;
    }

    private int compareNthItem(List<String> pattern1, List<String> pattern2, int nth) {
        return pattern1.get(nth).compareTo(pattern2.get(nth));
    }
}

class TimestampWebsite {
    int timestamp;
    String website;
    public TimestampWebsite(int timestamp, String website) {
        this.timestamp = timestamp;
        this.website = website;
    }
}