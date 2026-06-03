package pers.mingda.leetcode;

public class LC2114MaximumNumberOfWordsFoundInSentences {
}

class LC2114Solution {
  public int mostWordsFound(String[] sentences) {
    int maxWords = 0;
    for (String sentence : sentences) {
      maxWords = Math.max(maxWords, countWords(sentence));
    }
    return maxWords;
  }

  private int countWords(String sentence) {
    int spaceCount = 0;
    for (char c : sentence.toCharArray()) {
      if (c == ' ') {
        spaceCount++;
      }
    }
    return spaceCount + 1;
  }
}