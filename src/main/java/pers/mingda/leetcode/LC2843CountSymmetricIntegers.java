package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC2843CountSymmetricIntegers {

  public int countSymmetricIntegers(int low, int high) {
    int count = 0;
    Map<Integer, Integer> sumRecord = new HashMap<>();
    for (int num = low; num <= high; num++) {
      if (checkSymmetric(num, sumRecord)) {
        count++;
      }
    }
    return count;
  }

  private boolean checkSymmetric(int num, Map<Integer, Integer> sumRecord) {
    int digits = countDigits(num);
    if (digits % 2 != 0) {
      return false;
    }
    int divider = getDivider(digits / 2);
    return (
      getDigitSum(num % divider, sumRecord) ==
      getDigitSum(num / divider, sumRecord)
    );
  }

  private int countDigits(int num) {
    int count = 0;
    while (num != 0) {
      num /= 10;
      count++;
    }
    return count;
  }

  private int getDigitSum(int num, Map<Integer, Integer> sumRecord) {
    if (sumRecord.containsKey(num)) {
      return sumRecord.get(num);
    }
    int sum = 0;
    while (num != 0) {
      sum += num % 10;
      num /= 10;
    }
    sumRecord.put(num, sum);
    return sum;
  }

  private int getDivider(int digit) {
    int divider = 1;
    for (int i = 0; i < digit; i++) {
      divider *= 10;
    }
    return divider;
  }

  public int countSymmetricIntegersNoBrainer(int low, int high) {
    int count = 0;
    int divider = 100;
    for (int num = low; num <= high; num++) {
      if ((num >= 10 && num <= 99 && num % 11 == 0)) {
        count++;
      } else if (num >= 1000 && equalByDigitSum(num / divider, num % divider)) {
        count++;
      }
    }
    return count;
  }

  private boolean equalByDigitSum(int num1, int num2) {
    return sumByDigit(num1) == sumByDigit(num2);
  }

  private int sumByDigit(int num) {
    return num / 10 + (num % 10);
  }
}
