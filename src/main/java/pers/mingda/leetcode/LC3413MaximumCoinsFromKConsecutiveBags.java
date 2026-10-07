package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LC3413MaximumCoinsFromKConsecutiveBags {
}

class LC3413Solution {
  public long maximumCoins(int[][] coins, int k) {
    Arrays.sort(coins, Comparator.comparingInt(i -> i[0]));

    long leftMax = maxCoinFromLeft(coins, k);
    long rightMax = maxCoinFromRight(coins, k);

    return Math.max(leftMax, rightMax);
  }

  private long maxCoinFromLeft(int[][] coins, int k) {
    int coinLen = coins.length;

    long maxCoins = 0;
    long coinCount = 0;
    int right = 0;

    for (int[] coin : coins) {
      int windowStart = coin[0];
      int windowEnd = windowStart + k - 1;

      while (right < coinLen && coins[right][1] <= windowEnd) {
        coinCount += countBagGroup(coins[right]);
        right++;
      }

      if (right < coinLen && coins[right][0] <= windowEnd && coins[right][1] > windowEnd) {
        int partialCount = (windowEnd - coins[right][0] + 1) * coins[right][2];
        coinCount += partialCount;

        maxCoins = Math.max(maxCoins, coinCount);
        coinCount -= partialCount;
      } else {
        maxCoins = Math.max(maxCoins, coinCount);
      }

      coinCount -= countBagGroup(coin);
    }
    return maxCoins;
  }

  private long maxCoinFromRight(int[][] coins, int k) {
    int coinLen = coins.length;

    long maxCoins = 0;
    long coinCount = 0;
    int left = coinLen - 1;

    for (int right = coinLen - 1; right >= 0; right--) {
      int windowEnd = coins[right][1];
      int windowStart = windowEnd - k + 1;

      while (left >= 0 && coins[left][0] >= windowStart) {
        coinCount += countBagGroup(coins[left]);
        left--;
      }

      if (left >= 0 && coins[left][0] < windowStart && coins[left][1] >= windowStart) {
        int partialCount = (coins[left][1] - windowStart + 1) * coins[left][2];
        coinCount += partialCount;

        maxCoins = Math.max(maxCoins, coinCount);
        coinCount -= partialCount;
      } else {
        maxCoins = Math.max(maxCoins, coinCount);
      }

      coinCount -= countBagGroup(coins[right]);
    }
    return maxCoins;
  }

  private long countBagGroup(int[] bagGroup) {
    return (bagGroup[1] - bagGroup[0] + 1) * (long)bagGroup[2];
  }
}