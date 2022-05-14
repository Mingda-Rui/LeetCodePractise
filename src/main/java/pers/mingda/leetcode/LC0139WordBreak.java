package pers.mingda.leetcode;

public class LC0139WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] record = new boolean[s.length()];
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            for (String word: wordDict) {
                int prevIndex = i - word.length();
                boolean prevFound = prevIndex == - 1 || (prevIndex >= 0 && record[prevIndex]);
                if (!record[i] && prevFound) {
                    if (equals(word, s, prevIndex + 1, i + 1))
                        record[i] = true;
                }
            }
        }
        return record[s.length() - 1];
    }

    private boolean equals(String word, String s, int start, int end) {
        for (int i = start; i < end; i++) {
            if (word.charAt(i - start) != s.charAt(i))
                return false;
        }
        return true;
    }
}
