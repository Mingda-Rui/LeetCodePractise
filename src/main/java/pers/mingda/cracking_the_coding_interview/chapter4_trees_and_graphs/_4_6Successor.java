package pers.mingda.cracking_the_coding_interview.chapter4_trees_and_graphs;

/**
 * 4.6 Succesor: Write an algorithm to find the "next" node (i.e., in-order successor) of a given
 * node in a binary search tree. You may assume that each node has a link to its parent.
 */
public class _4_6Successor {
  public static TreeNode inorderSucc(TreeNode n) {
    if (n == null) return null;
    if (n.right == null) {
      return getNextInorderParent(n);
    }

    return getLeftMostChild(n.right);
  }

  private static TreeNode getLeftMostChild(TreeNode n) {
    if (n == null) return null;
    TreeNode left = getLeftMostChild(n.left);
    return left == null ? n : left;
  }

  private static TreeNode getNextInorderParent(TreeNode n) {
    if (n == null || n.parent == null) return n;
    TreeNode parent = n.parent;
    if (parent.left == n) return parent;

    return getNextInorderParent(parent);
  }
}
