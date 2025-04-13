package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class LC1161MaximumLevelSumOfABinaryTree {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 0;
        int currentLevel = 0;
        queue.add(root);
        while (!queue.isEmpty()) {
            currentLevel++;
            int levelSize = queue.size();
            int currentSum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.remove();
                enqueueChild(node, queue);
                currentSum += node.val;
            }
            if (currentSum > maxSum) {
                maxLevel = currentLevel;
                maxSum = currentSum;
            }
        }
        return maxLevel;
    }

    private void enqueueChild(TreeNode node, Queue<TreeNode> queue) {
        if (node.left != null) {
            queue.add(node.left);
        }
        if (node.right != null) {
            queue.add(node.right);
        }
    }
}
