package pers.mingda.leetcode;

import java.util.List;

public class LC0139WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] record = new boolean[length];
        for (int i = 0; i < length; i++) {
            for (String word: wordDict) {
                int prevIndex = i - word.length();
                boolean prevPosFound = prevIndex == -1 || (prevIndex >= 0 && record[prevIndex]);
                if (prevPosFound && word.equals(s.substring(prevIndex + 1, i + 1)))
                    record[i] = true;
            }
        }
        return record[length - 1];
    }
}
