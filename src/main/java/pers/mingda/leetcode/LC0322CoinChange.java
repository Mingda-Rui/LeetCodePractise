package pers.mingda.leetcode;

public class LC0322CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return amount;
        int[] record = new int[amount + 1];
        for (int i = 0; i < amount + 1; i++) {
            int fewest = Integer.MAX_VALUE;
            boolean found = false;
            for (int coin: coins) {
                if (coin == i) {
                    fewest = 1;
                    found = true;
                } if (i - coin > 0 && record[i - coin] > 0) {
                    fewest = Math.min(fewest, record[i - coin] + 1);
                    found = true;
                }
            }
            record[i] = found ? fewest : -1;
        }
        return record[amount];
    }
}
