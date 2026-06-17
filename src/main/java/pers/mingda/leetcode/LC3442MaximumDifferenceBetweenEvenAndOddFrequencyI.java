package pers.mingda.leetcode;

public class LC3442MaximumDifferenceBetweenEvenAndOddFrequencyI {}

class LC3442Solution {
  public int maxDifference(String s) {
    int[] letterCounter = new int[26];
    for (char c : s.toCharArray()) {
      int index = c - 'a';
      letterCounter[index]++;
    }
    int maxOdd = Integer.MIN_VALUE;
    int minEven = Integer.MAX_VALUE;
    for (int count : letterCounter) {
      if (count == 0) {
        continue;
      }
      if (count % 2 == 0) {
        minEven = Math.min(minEven, count);
      } else {
        maxOdd = Math.max(maxOdd, count);
      }
    }
    return maxOdd - minEven;
  }
}
