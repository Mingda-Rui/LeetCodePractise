package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC1291SequentialDigits {

}

class LC1291Solution {
  public List<Integer> sequentialDigits(int low, int high) {
    List<Integer> result = new ArrayList<>();
    int lowDigitCount = countDigits(low);
    int highDigitCount = countDigits(high);
    for (int dCount = lowDigitCount; dCount <= highDigitCount; dCount++) {
      for (int head = 1; head + dCount <= 10; head++) {
        int seqDigits = getNextDigits(head, dCount);
        if (seqDigits >= low && seqDigits <= high) {
          result.add(seqDigits);
        }
      }
    }
    return result;
  }

  private int countDigits(int num) {
    int count = 0;
    while (num != 0) {
      count++;
      num /= 10;
    }
    return count;
  }

  private int getNextDigits(int head, int digitCount) {
    int result = 0;
    int digit = head;
    while (digitCount != 0) {
      result *= 10;
      result += digit;
      digitCount--;
      digit++;
    }

    return result;
  }
}
