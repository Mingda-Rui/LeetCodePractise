package pers.mingda.leetcode;

public class LC0014LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int maxLen = 0;
        while (true) {
            char c = ' ';
            for (String str: strs) {
                if (maxLen >= str.length())
                    return str.substring(0, maxLen);
                char current = str.charAt(maxLen);
                if (c == ' ')
                    c = current;
                else if (c != current)
                    return str.substring(0, maxLen);
            }
            maxLen++;
        }
    }
}
