package pers.mingda.cracking_the_coding_interview.chapter4_trees_and_graphs;

import java.util.HashMap;
import java.util.Map;

/**
 * 4.12 Paths with Sum: You are given a binary tree in which each node contains an integer value
 * (which might be positive or negative). Design an algorithm to count the number of paths that sum
 * to a given value. The path does not need to start or end at the root or a leaf, but it must go
 * downwards (traveling only from parent nodes to child nodes).
 */
public class _4_12PathsWithSum {
  public static int countPathsWithSum(TreeNode node, int targetSum) {
    if (node == null) return 0;

    int counter = countPathsWithRemainSum(node, targetSum);
    counter += countPathsWithSum(node.left, targetSum);
    counter += countPathsWithSum(node.right, targetSum);
    return counter;
  }

  private static int countPathsWithRemainSum(TreeNode node, int remainSum) {
    if (node == null) return 0;
    int counter = 0;
    if (node.data == remainSum) counter++;
    counter += countPathsWithRemainSum(node.left, remainSum - node.data);
    counter += countPathsWithRemainSum(node.right, remainSum - node.data);
    return counter;
  }

  public static int countPathsWithSumOptimized(TreeNode node, int targetSum) {
    Map<Integer, Integer> sumRecords = new HashMap<>();
    sumRecords.put(0, 1);
    return countPathsWithSumOptimized(node, targetSum, 0, sumRecords);
  }

  private static int countPathsWithSumOptimized(
      TreeNode node, int targetSum, int previousSum, Map<Integer, Integer> sumRecords) {
    if (node == null) return 0;

    int currentSum = previousSum + node.data;

    int offset = currentSum - targetSum;
    int counter = sumRecords.computeIfAbsent(offset, n -> 0);

    incrementHashTable(sumRecords, currentSum, 1);
    counter += countPathsWithSumOptimized(node.left, targetSum, currentSum, sumRecords);
    counter += countPathsWithSumOptimized(node.right, targetSum, currentSum, sumRecords);
    incrementHashTable(sumRecords, currentSum, -1);

    return counter;
  }

  private static void incrementHashTable(Map<Integer, Integer> sumRecords, int key, int amount) {
    int value = sumRecords.computeIfAbsent(key, n -> 0);
    int newValue = value + amount;
    sumRecords.put(key, newValue);
  }
}
