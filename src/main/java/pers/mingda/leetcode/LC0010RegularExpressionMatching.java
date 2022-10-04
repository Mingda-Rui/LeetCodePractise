package pers.mingda.leetcode;

public class LC0010RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        if (p.isEmpty())
            return s.isEmpty();

        char pattern = p.charAt(0);
        boolean isStarPattern = p.length() > 1 && p.charAt(1) == '*';
        boolean isFirstLetterMatch = !s.isEmpty() && (s.charAt(0) == pattern || pattern == '.');

//        if (isFirstLetterMatch) {
//            if (isStarPattern) {
//                return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
//            } else {
//                return isMatch(s.substring(1), p.substring(1));
//            }
//        } else {
//            return isStarPattern && isMatch(s, p.substring(2));
//        }

        if (isStarPattern) {
            boolean foundSkipPatternMatch = isMatch(s, p.substring(2));
            return foundSkipPatternMatch || (isFirstLetterMatch && isMatch(s.substring(1), p));
        } else {
            return isFirstLetterMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
}
