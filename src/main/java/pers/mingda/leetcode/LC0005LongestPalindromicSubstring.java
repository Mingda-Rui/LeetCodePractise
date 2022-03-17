package pers.mingda.leetcode;

public class LC0005LongestPalindromicSubstring {
    public String longestPalindromeBruteForce(String s) {
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            longest = getLongest(s, longest, i - 1, i + 1);
            if (i + 1 < s.length() && isEquals(s, i, i + 1))
                longest = getLongest(s, longest, i, i + 1);
        }
        return longest;
    }

    private String getLongest(String s, String longest, int left, int right) {
        int longestLeft = 0;
        int longestRight = 0;
        while (left >= 0 && right < s.length() && isEquals(s, left, right)) {
            if (right - left > longestRight - longestLeft) {
                longestLeft = left;
                longestRight = right;
            }
            left--;
            right++;
        }
        String currentLongest = s.substring(longestLeft, longestRight + 1);
        return currentLongest.length() > longest.length() ? currentLongest : longest;
    }

    private boolean isEquals(String s, int left, int right) {
        return Character.toLowerCase(s.charAt(left)) == Character.toLowerCase(s.charAt(right));
    }
}
