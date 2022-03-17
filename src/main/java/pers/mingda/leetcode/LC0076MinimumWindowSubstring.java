package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC0076MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int resultStart = 0;
        int resultEnd = s.length();
        int start = 0;
        int[] record = new int[128];
        Map<Character, Integer> map = new HashMap<>();
        for (char c: t.toCharArray()) {
            record[c]++;
            map.put(c, record[c]);
        }

        int[] current = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            current[c]++;
            Object val = map.computeIfPresent(c, (k, v) -> v - 1);

            if (val != null && ((int) val) == 0)
                map.remove(c);
            while(map.isEmpty()) {
                if (i - start < resultEnd - resultStart) {
                    resultStart = start;
                    resultEnd = i;
                }

                char charAtStart = s.charAt(start);
                current[charAtStart]--;
                start++;
                int offset = record[charAtStart] - current[charAtStart];
                if (offset > 0)
                    map.put(charAtStart, offset);
            }
        }
        return resultEnd == s.length() ? "" : s.substring(resultStart, resultEnd + 1) ;
    }

    public String minWindowArraySolution(String s, String t) {
        int minLeft = 0;
        int minRight = Integer.MAX_VALUE;
        int[] record = new int[128];
        boolean[] tArray = new boolean[128];
        for (char c: t.toCharArray()) {
            record[c]++;
            tArray[c] = true;
        }

        int numOfIncludedChar = 0;
        for (int left = 0, right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            if (tArray[rightChar]) {
                record[rightChar]--;
                if (record[rightChar] >= 0)
                    numOfIncludedChar++;
                while (numOfIncludedChar == t.length()) {
                    if (right - left < minRight - minLeft) {
                        minLeft = left;
                        minRight = right;
                    }
                    char leftChar = s.charAt(left);
                    left++;
                    if (tArray[leftChar]) {
                        record[leftChar]++;
                        if (record[leftChar] > 0)
                            numOfIncludedChar--;
                    }
                }
            }
        }

        return minRight > s.length() ? "" : s.substring(minLeft, minRight + 1);
    }
}
