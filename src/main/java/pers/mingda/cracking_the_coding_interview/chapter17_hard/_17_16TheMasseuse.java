package pers.mingda.cracking_the_coding_interview.chapter17_hard;

import java.util.HashMap;
import java.util.Map;

public class _17_16TheMasseuse {
    int maxMinutes(int[] massages) {
        Map<Integer, Integer> record = new HashMap<>();
        return maxMinutes(massages, 0, record);
    }

    int maxMinutes(int[] massages, int next, Map<Integer, Integer> record) {
        if (record.containsKey(next)) {
            return record.get(next);
        }
        if (next == massages.length) {
            return 0;
        }

        int with = massages[next] + maxMinutes(massages, next + 2, record);
        int without = maxMinutes(massages, next + 1, record);
        int max = Math.max(with, without);
        record.put(next, max);
        return max;
    }
}
