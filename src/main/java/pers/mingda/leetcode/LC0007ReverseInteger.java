package pers.mingda.leetcode;

public class LC0007ReverseInteger {}

class Solution_String {

  int lowerBoundary = -2147483648;
  int upperBoundary = 2147483647;

  public int reverse(int x) {
    if (x < lowerBoundary || x > upperBoundary || x == 0) {
      return 0;
    }

    String numInString = String.valueOf(x);
    int lengthOfString = numInString.length();
    int endIndex = lengthOfString - 1;
    char negativeSign = '-';

    if (numInString.charAt(0) == negativeSign) {
      String unsignedReversedNum = new StringBuilder(
        numInString.substring(1, lengthOfString)
      )
        .reverse()
        .toString();
      return reverseNum(negativeSign + unsignedReversedNum);
    } else if (numInString.charAt(endIndex) == '0') {
      String reversedNum = new StringBuilder(numInString.substring(0, endIndex))
        .reverse()
        .toString();
      return reverseNum(reversedNum);
    } else {
      String reversedNum = new StringBuilder(numInString).reverse().toString();
      return reverseNum(reversedNum);
    }
  }

  private int reverseNum(String num) {
    long reversedNumInLong = Long.parseLong(num);
    return (
        lowerBoundary <= reversedNumInLong && reversedNumInLong <= upperBoundary
      )
      ? (int) reversedNumInLong
      : 0;
  }
}

class Solution_Int {

  public int reverse(int x) {
    if (x == 0) return 0;
    long res = 0;
    while (x != 0) {
      res = res * 10 + (x % 10);
      x /= 10;
    }
    if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
    return (int) res;
  }
}
