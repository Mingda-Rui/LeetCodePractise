package pers.mingda.leetcode;

public class LC0096UniqueBinarySearchTrees {

  public int numTrees(int n) {
    return numTrees(n, 1, n + 1, new int[n + 1]);
  }

  private int numTrees(int n, int start, int end, int[] record) {
    int distance = end - start;
    if (distance <= 1) return 1;
    if (record[distance] != 0) return record[distance];
    int count = 0;
    for (int i = start; i < end; i++) count += (numTrees(n, start, i, record) *
      numTrees(n, i + 1, end, record));
    record[distance] = count;
    return count;
  }

  public int numTreesIterative(int n) {
    int[] record = new int[n + 1];
    record[0] = 1;
    record[1] = 1;

    for (int i = 2; i < record.length; i++) for (
      int j = 1;
      j < i + 1;
      j++
    ) record[i] += record[j - 1] * record[i - j];

    return record[n];
  }
}
