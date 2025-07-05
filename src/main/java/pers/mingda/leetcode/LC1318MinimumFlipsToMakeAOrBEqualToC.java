package pers.mingda.leetcode;

public class LC1318MinimumFlipsToMakeAOrBEqualToC {}

class LC1318Solution {

  public int minFlips(int a, int b, int c) {
    int result = 0;
    while (a != 0 || b != 0 || c != 0) {
      int aBit = a & 1;
      int bBit = b & 1;
      int cBit = c & 1;
      result += flip(aBit, bBit, cBit);
      a >>= 1;
      b >>= 1;
      c >>= 1;
    }
    return result;
  }

  private int flip(int aBit, int bBit, int cBit) {
    if (cBit == 0) {
      return aBit + bBit;
    } else if (aBit == 1 || bBit == 1) {
      return 0;
    } else {
      return 1;
    }
  }
}

class LC1318PopCountSolution {

  public int minFlips(int a, int b, int c) {
    int bitDiff = (a | b) ^ c;
    return Integer.bitCount(bitDiff) + Integer.bitCount(a & b & bitDiff);
  }
}
