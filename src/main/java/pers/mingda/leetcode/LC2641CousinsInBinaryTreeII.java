package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LC2641CousinsInBinaryTreeII {
}

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
class LC2641Solution {
  public TreeNode replaceValueInTree(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    root.val = 0;
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      Map<TreeNode, Integer> childrenValSum = new HashMap<>();
      int nextGenSum = 0;
      for (int i = 0; i < size; i++) {
        TreeNode parent = queue.remove();
        int childrenSum = 0;
        if (parent.left != null) {
          childrenSum += parent.left.val;
        }
        if (parent.right != null) {
          childrenSum += parent.right.val;
        }
        childrenValSum.put(parent, childrenSum);
        nextGenSum += childrenSum;
      }

      for (TreeNode parent : childrenValSum.keySet()) {
        int childrenSum = childrenValSum.get(parent);
        if (parent.left != null) {
          parent.left.val = nextGenSum - childrenSum;
          queue.add(parent.left);
        }
        if (parent.right != null) {
          parent.right.val = nextGenSum - childrenSum;
          queue.add(parent.right);
        }
      }
    }
    return root;
  }
}