package pers.mingda.leetcode;

import java.util.List;

public class LC0422ValidWordSquare {}

class LC0422Solution {

  public boolean validWordSquare(List<String> words) {
    int maxRow = words.size();
    int maxCol = getMaxCol(words);
    if (maxRow != maxCol) {
      return false;
    }
    for (int i = 0; i < maxRow; i++) {
      if (!compare(words, i)) {
        return false;
      }
    }

    return true;
  }

  private int getMaxCol(List<String> words) {
    int maxCol = 0;
    for (String word : words) {
      maxCol = Math.max(maxCol, word.length());
    }
    return maxCol;
  }

  private boolean compare(List<String> words, int index) {
    String rowWord = words.get(index);
    for (int i = 0; i < rowWord.length(); i++) {
      if (words.get(i).length() <= index) {
        return false;
      }
      if (rowWord.charAt(i) != words.get(i).charAt(index)) {
        return false;
      }
    }
    return true;
  }
}
