package pers.mingda.leetcode;

public class LC1047RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicateIterative(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            char next = s.charAt(i + 1);
            if (c == next) {
                String head = s.substring(0, i);
                String tail = i + 2 < s.length() ? s.substring(i + 2, s.length()) : "";
                s = head + tail;
                i = Math.max(-1, i - 2);
            }
        }
        return s;
    }
}
