package pers.mingda.leetcode;

import java.util.List;

public class LC0422ValidWordSquare {}

class LC0422Solution {

  public boolean validWordSquare(List<String> words) {
    for (int i = 0; i < words.size(); i++) {
      if (!compare(words, i)) {
        return false;
      }
    }

    return true;
  }

  private boolean compare(List<String> words, int index) {
    String rowWord = words.get(index);
    int rowWordLen = rowWord.length();
    if (words.size() > rowWordLen && words.get(rowWordLen).length() > index) {
      return false;
    }
    for (int i = 0; i < rowWord.length(); i++) {
      if (words.size() <= i || words.get(i).length() <= index) {
        return false;
      }
      if (rowWord.charAt(i) != words.get(i).charAt(index)) {
        return false;
      }
    }
    return true;
  }
}
