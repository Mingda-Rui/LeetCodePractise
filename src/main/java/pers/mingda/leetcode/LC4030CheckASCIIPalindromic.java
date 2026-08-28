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
