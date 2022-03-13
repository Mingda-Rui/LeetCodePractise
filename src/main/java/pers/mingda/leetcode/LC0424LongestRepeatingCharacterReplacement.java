package pers.mingda.leetcode;

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
}
