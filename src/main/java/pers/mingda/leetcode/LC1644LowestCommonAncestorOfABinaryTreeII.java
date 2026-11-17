package pers.mingda.leetcode;

public class LC1644LowestCommonAncestorOfABinaryTreeII {
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LC1644Solution {

  boolean foundAncestor = false;

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    TreeNode ancestorCandidate = lowestCommonAncestorHelper(root, p, q);
    return foundAncestor ? ancestorCandidate : null;
  }

  public TreeNode lowestCommonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }
    TreeNode left = lowestCommonAncestorHelper(root.left, p, q);
    TreeNode right = lowestCommonAncestorHelper(root.right, p, q);

    if (left != null && right != null) {
      foundAncestor = true;
      return root;
    }

    if (root == p || root == q) {
      if (left != null || right != null) {
        foundAncestor = true;
      }
      return root;
    }

    return left == null ? right : left;
  }
}
