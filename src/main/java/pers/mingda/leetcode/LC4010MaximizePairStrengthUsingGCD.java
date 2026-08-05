package pers.mingda.leetcode;

public class LC4010MaximizePairStrengthUsingGCD {}

class Solution {
  public long maxPairStrength(int[] nums) {
    long maxStrength = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        int a = nums[i];
        int b = nums[j];
        int gcd = gcd(a, b);
        long strength = (long) (a / gcd) * (long) (b / gcd);
        maxStrength = Math.max(maxStrength, strength);
      }
    }
    return maxStrength;
  }

  private int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }
}
