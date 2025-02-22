package pers.mingda.cracking_the_coding_interview.chapter16_moderate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _16_11DivingBoard {
    Set<Integer> allLengths(int k, int shorter, int longer) {
        Map<Integer, Set<Integer>> memory = new HashMap<>();
        return getLength(k, shorter, longer, 0, memory);
    }

    Set<Integer> getLength(int k, int shorter, int longer, int currentLen, Map<Integer, Set<Integer>> memory) {
        if (memory.containsKey(k)) {
            return memory.get(k);
        }
        if (k == 0) {
            return Set.of(currentLen);
        }
        Set<Integer> set = new HashSet<>();
        set.addAll(getLength(k - 1, shorter, longer, currentLen + shorter, memory));
        set.addAll(getLength(k - 1, shorter, longer, currentLen + longer, memory));
        memory.put(k, set);
        return set;
    }
}
