package pers.mingda.leetcode;

public class LC0402RemoveKDigits {
  public String removeKdigits(String num, int k) {
    if (k >= num.length()) return "0";

    char[] stack = new char[num.length()];
    int stackIndex = -1;
    int index = 0;
    while (index < num.length()) {
      char c = num.charAt(index);
      if (k > 0 && stackIndex >= 0 && stack[stackIndex] > c) {
        stackIndex--;
        k--;
      } else {
        if (stackIndex == 0 && stack[0] == '0') stackIndex--;
        stackIndex++;
        stack[stackIndex] = c;
        index++;
      }
    }

    if (stackIndex + 1 <= k) return "0";

    return String.valueOf(stack, 0, stackIndex - k + 1);
  }
}
