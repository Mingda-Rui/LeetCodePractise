package pers.mingda.leetcode;

import java.util.Set;

public class LC1676LowestCommonAncestorOfABinaryTreeIV {
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
class LC1676Solution {

  private TreeNode lca = null;

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
    findNodes(root, Set.of(nodes));
    return lca;
  }

  private int findNodes(TreeNode root, Set<TreeNode> nodes) {
    if (root == null) {
      return 0;
    }
    int count = 0;
    if (nodes.contains(root)) {
      count++;
    }
    count += findNodes(root.left, nodes);
    count += findNodes(root.right, nodes);
    if (count == nodes.size() && lca == null) {
      lca = root;
    }
    return count;
  }
}
