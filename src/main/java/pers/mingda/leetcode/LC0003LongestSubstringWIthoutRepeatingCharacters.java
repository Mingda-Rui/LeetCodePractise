package pers.mingda.leetcode;

public class LC0003LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int[] record = new int[256];
        int mark = 1;
        int previousIndex = 0;
        int maxLength = 0;
        int currentLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (record[c] < mark) {
                record[c] = mark;
                currentLength++;
            } else {
                maxLength = Math.max(currentLength, maxLength);
                mark++;
                i = previousIndex;
                previousIndex++;
                currentLength = 0;
            }
        }
        return Math.max(currentLength, maxLength);
    }
}
