package pers.mingda.leetcode;

import java.util.Arrays;

public class LC0518CoinChangeII {
    public int change(int amount, int[] coins) {
        int[][] changeRecord = new int[coins.length][amount + 1];
        for (int[] col: changeRecord) {
            Arrays.fill(col, -1);
        }
        return findChange(amount, coins, 0, changeRecord);
    }

    private int findChange(int amount, int[] coins, int coinIndex, int[][] changeRecord) {
        if (amount == 0) {
            return 1;
        }
        if (amount < 0 || coinIndex == coins.length) {
            return 0;
        }
        if (changeRecord[coinIndex][amount] != -1) {
            return changeRecord[coinIndex][amount];
        }
        int count = 0;
        int coin = coins[coinIndex];
        count += findChange(amount - coin, coins, coinIndex, changeRecord);
        count += findChange(amount, coins, coinIndex + 1, changeRecord);
        changeRecord[coinIndex][amount] = count;
        return count;
    }
}
