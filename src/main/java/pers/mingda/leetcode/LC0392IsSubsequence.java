package pers.mingda.leetcode;

public class LC0392IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int pointer = 0;
        for (int i = 0; i < t.length(); i++) {
            if (pointer == s.length())
                return true;
            if (s.charAt(pointer) == t.charAt(i))
                pointer++;
        }
        return pointer == s.length();
    }
}
