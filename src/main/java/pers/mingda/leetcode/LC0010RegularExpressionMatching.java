package pers.mingda.leetcode;

public class LC0010RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        if (s.isEmpty() && p.isEmpty())
            return true;
        if (p.isEmpty())
            return false;

        char pattern = p.charAt(0);
        boolean isStarPattern = p.length() > 1 && p.charAt(1) == '*';

        if (isStarPattern) {
            p = p.substring(2);
            int index = -1;
            while (index < s.length() && (index < 0 || s.charAt(index) == pattern || pattern == '.') ){
                index++;
                if (isMatch(s.substring(index), p))
                    return true;
            }
        } else {
            p = p.substring(1);
            if ( s.isEmpty() || (pattern != '.' && pattern != s.charAt(0)) )
                return false;
            return isMatch(s.substring(1), p);
        }
        return false;
    }
}
