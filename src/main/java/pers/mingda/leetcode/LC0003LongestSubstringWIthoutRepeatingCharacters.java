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

    public int lengthOfLongestSubstringPreviousIndex(String s) {
        int[] record = new int[256];
        for (int i = 0; i < record.length; i++)
            record[i] = -1;
        int startIndex = 0;
        int currentLength = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (record[c] < startIndex) {
                record[c] = i;
                currentLength++;
                maxLength = Math.max(currentLength, maxLength);
            } else {
                int previousIndex = record[c];
                currentLength -= previousIndex - startIndex;
                startIndex = previousIndex + 1;
                record[c] = i;
            }
        }
        return maxLength;
    }

    public int lengthOfLongestSubstringHeadIndex(String s) {
        int[] nextHead = new int[256];
        int head = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            head = Math.max(head, nextHead[c]);
            nextHead[c] = i + 1;
            int currentLength = i - head + 1;
            maxLength = Math.max(currentLength, maxLength);
        }
        return maxLength;
    }
}
