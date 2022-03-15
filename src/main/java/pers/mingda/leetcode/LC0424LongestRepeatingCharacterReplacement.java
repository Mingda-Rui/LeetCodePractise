package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.List;

public class LC0424LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int max = 0;
        int start = 0;
        int last = 0;
        int numsOfOps = k;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(start)) {
                if (numsOfOps == k)
                    last = i - 1;
                if (numsOfOps > 0) {
                    numsOfOps--;
                } else if (numsOfOps == 0) {
                    numsOfOps = k;
                    max = Math.max(max, i - start);
                    i = last;
                    start = last + 1;
                }
            }
        }
        int lastLength = s.length() - start + numsOfOps;
        return Math.max(max, Math.min(s.length(), lastLength));
    }

    public int characterReplacementTraverseLetters(String s, int k) {
        int max = 0;
        for (char c = 'A'; c <= 'Z'; c++) {
            int maxForChar = characterReplacementForChar(s, k, c);
            max = Math.max(max, maxForChar);
        }
        return max;
    }

    private int characterReplacementForChar(String s, int k, char c) {
        int max = 0;
        int head = 0;
        List<Integer> replacements = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (c != s.charAt(i)) {
                replacements.add(i);

                if (replacements.size() > k) {
                    int index = replacements.remove(0);
                    while (index + 1 < s.length() && s.charAt(index + 1) != c && replacements.size() > 0)
                        index = replacements.remove(0);
                    head = index + 1;
                }
            }
            max = Math.max(max, i - head + 1);
        }
        return max;
    }

    public int characterReplacementSlidingWindow(String s, int k) {
        int maxLength = 0;
        int maxCount = 0;
        int[] counter = new int[128];
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            counter[c]++;
            maxCount = Math.max(maxCount, counter[c]);
            int currentLength = i - start + 1;
            if (currentLength > maxCount + k) {
                char charAtStart = s.charAt(start);
                counter[charAtStart]--;
                start++;
            } else
                maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }
}
