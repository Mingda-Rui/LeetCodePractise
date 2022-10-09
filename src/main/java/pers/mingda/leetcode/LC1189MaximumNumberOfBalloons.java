package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LC1189MaximumNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> map = new HashMap<>();
        List<Character> letterList = Arrays.asList('b', 'a', 'l', 'o', 'n');
        Set<Character> set = new HashSet<>(letterList);

        for (char c: set)
            map.put(c, 0);

        for (char c: text.toCharArray()) {
            if (set.contains(c)) {
                int count = map.get(c);
                map.put(c, count + 1);
            }
        }

        int min = Integer.MAX_VALUE;
        for (char c: map.keySet()) {
            int count = map.get(c);
            if (c == 'l' || c == 'o')
                count /= 2;
            min = Math.min(min, count);
        }
        return min;
    }
}
