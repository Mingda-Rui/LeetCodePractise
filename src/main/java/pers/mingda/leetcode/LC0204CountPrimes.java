package pers.mingda.leetcode;

public class LC0204CountPrimes {

  public int countPrimes(int n) {
    if (n < 3) return 0;

    boolean[] record = new boolean[n];
    int counter = 1;
    for (int i = 3; i < n; i += 2) {
      if (!record[i]) {
        counter++;
        boolean boundary = i <= Math.sqrt(n);
        for (int j = i * i; boundary && j < n; j += i * 2) record[j] = true;
      }
    }
    return counter;
  }
}
