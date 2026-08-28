package pers.mingda.leetcode;

public class LC4030CheckASCIIPalindromic {}

class LC4030Solution {
  public boolean isPalindromic(String s) {
    StringBuilder sb = new StringBuilder();
    for (char c : s.toCharArray()) {
      sb.append(toBinaryString(c));
    }
    String binaryString = sb.toString();
    String reversed = new StringBuilder(binaryString).reverse().toString();
    return binaryString.equals(reversed);
  }

  private String toBinaryString(char c) {
    int lastEightBits = (int) c & 0xFF;
    StringBuilder binaryString = new StringBuilder(Integer.toBinaryString(lastEightBits));
    while (binaryString.length() < 8) {
      binaryString.insert(0, "0");
    }
    return binaryString.toString();
  }
}

class LC4030BitManipulationSolution {
  public boolean isPalindromic(String s) {
    int len = s.length();
    for (int i = 0; i <= len / 2; i++) {
      int j = len - i - 1;
      if (!isPartialPalindromic(s.charAt(i), s.charAt(j))) {
        return false;
      }
    }
    return true;
  }

  private boolean isPartialPalindromic(char a, char b) {
    for (int i = 0; i < 8; i++) {
      int j = 8 - i - 1;
      if ((((int) a >> i) & 1) != (((int) b >> j) & 1)) {
        return false;
      }
    }
    return true;
  }
}
