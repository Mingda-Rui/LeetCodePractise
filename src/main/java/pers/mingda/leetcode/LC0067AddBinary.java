package pers.mingda.leetcode;

public class LC0067AddBinary {

  public String addBinary(String a, String b) {
    int lenA = a.length();
    int lenB = b.length();
    int maxLen = Math.max(lenA, lenB);
    int carry = 0;
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= maxLen; i++) {
      int intA = i <= lenA ? (int) (a.charAt(lenA - i) - '0') : 0;
      int intB = i <= lenB ? (int) (b.charAt(lenB - i) - '0') : 0;
      int sum = intA + intB + carry;
      carry = sum / 2;
      int digit = sum % 2;
      sb.append(digit);
    }
    if (carry > 0) sb.append(carry);
    return sb.reverse().toString();
  }
}
