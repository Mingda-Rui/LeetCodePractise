package pers.mingda.leetcode;

public class LC0322CoinChange {

  public int coinChange(int[] coins, int amount) {
    int[] record = new int[amount + 1];
    record[0] = 0;
    for (int i = 1; i < amount + 1; i++) {
      record[i] = -1;
      for (int coin : coins) {
        if (i - coin >= 0 && record[i - coin] >= 0) {
          int fewest = record[i] > 0 ? record[i] : Integer.MAX_VALUE;
          record[i] = Math.min(fewest, record[i - coin] + 1);
        }
      }
    }
    return record[amount];
  }
}
