package pers.mingda.leetcode;

public class LC0387FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int[] record = new int[128];
        for (char c: s.toCharArray())
            record[c]++;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (record[c] == 1)
                return i;
        }
        return -1;
    }
}
