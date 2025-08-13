package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC1056ConfusingNumber {}

class LC1056Solution {

  public boolean confusingNumber(int n) {
    Map<Integer, Integer> confusingNumberMap = new HashMap<>();
    confusingNumberMap.put(0, 0);
    confusingNumberMap.put(1, 1);
    confusingNumberMap.put(6, 9);
    confusingNumberMap.put(8, 8);
    confusingNumberMap.put(9, 6);

    int originalNumber = n;
    int newNumber = 0;
    while (n != 0) {
      int leastSignaficantDigit = n % 10;
      n /= 10;
      if (!confusingNumberMap.containsKey(leastSignaficantDigit)) {
        return false;
      }
      newNumber *= 10;
      newNumber += confusingNumberMap.get(leastSignaficantDigit);
    }
    return originalNumber != newNumber;
  }
}
