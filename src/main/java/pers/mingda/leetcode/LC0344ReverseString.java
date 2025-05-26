package pers.mingda.leetcode;

public class LC0344ReverseString {

  public void reverseString(char[] s) {
    int head = 0;
    int tail = s.length - 1;
    while (head < tail) {
      char tmp = s[head];
      s[head] = s[tail];
      s[tail] = tmp;
      head++;
      tail--;
    }
  }
}
