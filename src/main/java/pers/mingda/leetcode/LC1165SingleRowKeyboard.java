package pers.mingda.leetcode;

public class LC1165SingleRowKeyboard {}

class Solution {

  public int calculateTime(String keyboard, String word) {
    int[] letterIndexMap = new int[26];
    for (int i = 0; i < keyboard.length(); i++) {
      char l = keyboard.charAt(i);
      letterIndexMap[l - 'a'] = i;
    }
    int currentIndex = 0;
    int time = 0;
    for (char l : word.toCharArray()) {
      int letterIndex = letterIndexMap[l - 'a'];
      time += Math.abs(letterIndex - currentIndex);
      currentIndex = letterIndex;
    }
    return time;
  }
}
