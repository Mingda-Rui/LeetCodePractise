package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LC0846HandOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num: hand) {
            int val = map.getOrDefault(num, 0) + 1;
            map.put(num, val);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        for (int key: list) {
            int count = map.getOrDefault(key, 0);
            if (count == 0) {
                continue;
            }
            for (int i = 0; i < groupSize; i++) {
                int currentKey = key + i;
                int val = map.getOrDefault(currentKey, 0) - count;
                if (val < 0) {
                    return false;
                } else if (val == 0) {
                    map.remove(currentKey);
                } else {
                    map.put(currentKey, val);
                }
            }
        }
        return map.isEmpty();
    }
}
