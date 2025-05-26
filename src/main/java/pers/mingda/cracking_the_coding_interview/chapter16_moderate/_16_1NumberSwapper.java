package pers.mingda.cracking_the_coding_interview.chapter16_moderate;

public class _16_1NumberSwapper {
  public void swap(int a, int b) {
    a = a - b; // a is now diff
    b += a; // b becomes a0
    a = b - a; // a becomes b0
  }

  public void swapBinary(int a, int b) {
    a = a ^ b;
    b = a ^ b;
    a = a ^ b;
  }
}
