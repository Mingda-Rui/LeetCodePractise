package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC0076MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int resultStart = 0;
        int resultEnd = s.length();
        int start = 0;
        int[] record = new int[128];
        Map<Character, Integer> cur = new HashMap<>();
        for (char c: t.toCharArray()) {
            record[c]++;
            cur.put(c, record[c]);
        }

        int[] current = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            current[c]++;
            Object val = cur.computeIfPresent(c, (k, v) -> v - 1);

            if (val != null && ((int) val) == 0)
                cur.remove(c);
            while(cur.isEmpty()) {
                if (i - start < resultEnd - resultStart) {
                    resultStart = start;
                    resultEnd = i;
                }

                char charAtStart = s.charAt(start);
                current[charAtStart]--;
                start++;
                int offset = record[charAtStart] - current[charAtStart];
                if (offset > 0)
                    cur.put(charAtStart, offset);
            }
        }
        return resultEnd == s.length() ? "" : s.substring(resultStart, resultEnd + 1) ;
    }
}
