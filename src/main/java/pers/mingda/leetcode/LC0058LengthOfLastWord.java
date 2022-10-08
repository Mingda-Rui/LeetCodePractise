package pers.mingda.leetcode;

public class LC0058LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int len = 0;
        s = s.trim();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (!Character.isLetter(c))
                return len;
            len++;
        }
        return len;
    }
}
