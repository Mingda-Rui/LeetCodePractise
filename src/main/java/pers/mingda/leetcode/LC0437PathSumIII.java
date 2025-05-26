package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
public class LC0437PathSumIII {
  public int pathSum(TreeNode root, int targetSum) {
    Map<Long, Integer> record = new HashMap<>();
    return pathSum(root, targetSum, 0, record);
  }

  private int pathSum(TreeNode root, long targetSum, long currentSum, Map<Long, Integer> record) {
    if (root == null) {
      return 0;
    }
    int count = 0;
    currentSum += root.val;
    if (currentSum == targetSum) {
      count++;
    }
    long offset = currentSum - targetSum;
    count += record.getOrDefault(offset, 0);

    int seenTimes = record.getOrDefault(currentSum, 0);
    record.put(currentSum, seenTimes + 1);

    count += pathSum(root.left, targetSum, currentSum, record);
    count += pathSum(root.right, targetSum, currentSum, record);

    record.put(currentSum, seenTimes);
    return count;
  }
}
