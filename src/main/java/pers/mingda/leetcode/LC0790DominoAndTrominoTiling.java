package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC0790DominoAndTrominoTiling {}

class LC0790Solution {

  private Map<Integer, Long> fullRecord;
  private Map<Integer, Long> partialRecord;

  public int numTilings(int n) {
    fullRecord = new HashMap<>();
    partialRecord = new HashMap<>();
    return (int) (numTilingsFull(n));
  }

  private long numTilingsFull(int n) {
    if (n < 3) {
      return n;
    }
    if (fullRecord.containsKey(n)) {
      return fullRecord.get(n);
    }
    long num = numTilingsFull(n - 1) + numTilingsFull(n - 2) + numTilingsPartial(n - 1);
    fullRecord.put(n, num % 1_000_000_007);
    return fullRecord.get(n);
  }

  private long numTilingsPartial(int n) {
    if (n == 2) {
      return n;
    }
    if (partialRecord.containsKey(n)) {
      return partialRecord.get(n);
    }

    long num = 2 * numTilingsFull(n - 2) + numTilingsPartial(n - 1);
    partialRecord.put(n, num % 1_000_000_007);
    return partialRecord.get(n);
  }
}
