package pers.mingda.leetcode;

import java.util.HashSet;
import java.util.Set;

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

class LC0266SetSolution {

  public boolean canPermutePalindrome(String s) {
    Set<Character> set = new HashSet<>();
    for (char c : s.toCharArray()) {
      if (set.contains(c)) {
        set.remove(c);
      } else {
        set.add(c);
      }
    }
    return set.size() <= 1;
  }
}
