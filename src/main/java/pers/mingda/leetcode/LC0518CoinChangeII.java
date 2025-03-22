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


    public int changeIterative(int amount, int[] coins) {
        int[][] changeRecord = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= coins.length; i++) {
            changeRecord[i][0] = 1;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int a = 1; a <= amount; a++) {
                int coin = coins[i - 1];
                int amountLessCoin = a - coin;
                // same coin case
                int sameCoinCount = amountLessCoin >= 0 ? changeRecord[i][amountLessCoin] : 0;

                //int prevCoinsPlus = amountLessCoin > 0 ? changeRecord[i - 1][amountLessCoin] : 0;
                int prevCoinsWithout = changeRecord[i - 1][a];
                changeRecord[i][a] = sameCoinCount + prevCoinsWithout;
            }
        }
        return changeRecord[coins.length][amount];
    }
}
