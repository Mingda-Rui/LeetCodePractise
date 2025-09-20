package pers.mingda.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC0012IntegerToRoman {}

class LC0012Solution {

  public String intToRoman(int num) {
    Map<Integer, String> numToRoman = initNumToRomanMap();
    int digits = countDigits(num);

    StringBuilder sb = new StringBuilder();
    for (int place = 1; place <= digits; place++) {
      int digit = num % 10;
      num /= 10;
      int placeUnitVal = (int) Math.pow(10, place - 1);
      int placeValue = digit * placeUnitVal;
      if (numToRoman.containsKey(placeValue)) {
        sb.insert(0, numToRoman.get(placeValue));
        continue;
      }
      int baseDigit = digit < 5 ? 1 : 5;
      int counter = digit;
      while (counter != baseDigit) {
        sb.insert(0, numToRoman.get(placeUnitVal));
        counter--;
      }
      sb.insert(0, numToRoman.get(baseDigit * placeUnitVal));
    }

    return sb.toString();
  }

  private int countDigits(int num) {
    int count = 0;
    while (num > 0) {
      num /= 10;
      count++;
    }
    return count;
  }

  private Map<Integer, String> initNumToRomanMap() {
    Map<Integer, String> numToRoman = new HashMap<>();
    numToRoman.put(0, "");
    numToRoman.put(1, "I");
    numToRoman.put(4, "IV");
    numToRoman.put(5, "V");
    numToRoman.put(9, "IX");
    numToRoman.put(10, "X");
    numToRoman.put(40, "XL");
    numToRoman.put(50, "L");
    numToRoman.put(90, "XC");
    numToRoman.put(100, "C");
    numToRoman.put(400, "CD");
    numToRoman.put(500, "D");
    numToRoman.put(900, "CM");
    numToRoman.put(1000, "M");
    return numToRoman;
  }
}

class LC0012SimplifiedSolution {

  public String intToRoman(int num) {
    Map<Integer, String> numToRoman = initNumToRomanMap();

    List<Integer> nums = numToRoman.keySet().stream().sorted(Comparator.reverseOrder()).toList();
    StringBuilder sb = new StringBuilder();

    for (int romanNum : nums) {
      while (num > 0 && romanNum <= num) {
        num -= romanNum;
        sb.append(numToRoman.get(romanNum));
      }
    }

    return sb.toString();
  }

  private Map<Integer, String> initNumToRomanMap() {
    Map<Integer, String> numToRoman = new HashMap<>();
    numToRoman.put(0, "");
    numToRoman.put(1, "I");
    numToRoman.put(4, "IV");
    numToRoman.put(5, "V");
    numToRoman.put(9, "IX");
    numToRoman.put(10, "X");
    numToRoman.put(40, "XL");
    numToRoman.put(50, "L");
    numToRoman.put(90, "XC");
    numToRoman.put(100, "C");
    numToRoman.put(400, "CD");
    numToRoman.put(500, "D");
    numToRoman.put(900, "CM");
    numToRoman.put(1000, "M");
    return numToRoman;
  }
}
