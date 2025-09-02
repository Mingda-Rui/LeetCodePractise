package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC1134ArmstrongNumber {}

class Solution {

  public boolean isArmstrong(int n) {
    int originalN = n;
    Map<Integer, Integer> powerRecords = new HashMap<>();
    int sum = 0;
    int power = countDigits(n);
    while (n != 0) {
      sum += doPower(n % 10, power);
      n /= 10;
      if (sum > originalN) {
        return false;
      }
    }
    return sum == originalN;
  }

  private int countDigits(int n) {
    int count = 0;
    while (n != 0) {
      n /= 10;
      count++;
    }
    return count;
  }

  private int doPower(int num, int power) {
    int result = 1;
    for (int i = 0; i < power; i++) {
      result *= num;
    }
    return result;
  }
}
