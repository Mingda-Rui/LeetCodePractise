package pers.mingda.leetcode;

public class LC0266PalindromePermutation {}

class LC0266Solution {

  public boolean canPermutePalindrome(String s) {
    int[] letterCount = new int[26];
    for (char l : s.toCharArray()) {
      letterCount[l - 'a']++;
    }
    int numberOfOddLetter = 0;
    for (int count : letterCount) {
      if (count % 2 != 0) {
        numberOfOddLetter++;
      }
      if ((numberOfOddLetter != 0 && s.length() % 2 == 0) || numberOfOddLetter > 1) {
        return false;
      }
    }
    return true;
  }
}
