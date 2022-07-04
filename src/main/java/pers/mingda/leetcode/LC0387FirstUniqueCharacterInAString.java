package pers.mingda.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class LC0387FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int[] record = new int[128];
        for (char c: s.toCharArray())
            record[c]++;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (record[c] == 1)
                return i;
        }
        return -1;
    }

    public int firstUniqCharOnePass(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        boolean[] seen = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!seen[c]) {
                map.put(c, i);
                seen[c] = true;
            } else {
                map.remove(c);
            }
        }
        return map.isEmpty() ? -1 : map.entrySet().iterator().next().getValue();
    }

    public int firstUniqCharTwoPointers(String s) {
        int slow = 0;
        int fast = 1;
        int[] record = new int[128];
        record[s.charAt(slow)]++;
        while (slow < fast) {
            if (fast < s.length()) {
                if (s.charAt(slow) == s.charAt(fast))
                    slow++;
                record[s.charAt(fast)]++;
                fast++;
            } else if (record[s.charAt(slow)] > 1) {
                slow++;
            } else {
                return slow;
            }
        }
        return -1;
    }
}
