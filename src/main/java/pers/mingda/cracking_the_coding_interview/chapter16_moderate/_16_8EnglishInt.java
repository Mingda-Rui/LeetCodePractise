package pers.mingda.cracking_the_coding_interview.chapter16_moderate;

import java.util.ArrayList;
import java.util.List;

public class _16_8EnglishInt {

  // 2,147,483,647
  // 1 digit: one two three four five six seven eight nine ten
  // 2 digits: ten eleven twelve thirteen fourteen fifteen sixteen seventeen eighteen nineteen
  //           twenty thirty forty fifty sixty seventy eighty ninety
  // 3 digits: hundred
  // thousand million billion
  String[] smallNumbers = {
    "Zero",
    "One",
    "Two",
    "Three",
    "Four",
    "Five",
    "Six",
    "Seven",
    "Eight",
    "Nine",
    "Ten",
    "Eleven",
    "Twelve",
    "Thirteen",
    "Fourteen",
    "Fifteen",
    "Sixteen",
    "Seventeen",
    "Eighteen",
    "Nineteen",
  };
  String[] tens = {
    "",
    "",
    "Twenty",
    "Thirty",
    "Forty",
    "Fifty",
    "Sixty",
    "Seventy",
    "Eighty",
    "Ninety",
  };
  String[] bigNumbers = { "", "Thousand", "Million", "Billion" };
  static final String SPACE = " ";
  static final String HUNDRED = "Hundred";
  static final String NEGATIVE = "Negative";

  String convert(int num) {
    if (num == 0) return smallNumbers[0];
    List<String> chunks = new ArrayList<>();
    boolean negative = num < 0;
    num = Math.abs(num);
    int chunk = 0;
    while (num / 1000 != 0) {
      num /= 1000;
      chunk++;
    }
    for (int i = 0; i <= chunk; i++) {
      if (i != 0) {
        chunks.addFirst(bigNumbers[i]);
      }
      chunks.addFirst(convertHundreds(num % 1000));
      num /= 1000;
    }
    if (negative) {
      chunks.addFirst(NEGATIVE);
    }
    return String.join(SPACE, chunks);
  }

  String convertHundreds(int num) {
    if (num > 999) {
      throw new ArithmeticException(
        "This method can not convert a number greater than 999"
      );
    }
    StringBuilder sb = new StringBuilder();
    if (num > 99) {
      sb.append(smallNumbers[num / 100]).append(SPACE).append(HUNDRED);
    }
    num %= 100;
    if (num == 0) {
      return sb.toString();
    }
    if (num > 19) {
      sb.append(tens[num / 10]).append(SPACE).append(smallNumbers[num % 10]);
    } else {
      sb.append(smallNumbers[num]);
    }
    return sb.toString();
  }
}
