package pers.mingda.leetcode;

public class LC0374GuessNumberHigherOrLower {
  public int guessNumber(int n) {
    return guessNumber(1, n);
  }

  private int guessNumber(int h, int t) {
    int mid = h + (t - h) / 2;
    int result = guess(mid);
    if (result == 1) {
      return guessNumber(mid + 1, t);
    } else if (result == -1) {
      return guessNumber(h, mid - 1);
    }
    return mid;
  }

  int guess(int num) {
    return 0;
  }
}
