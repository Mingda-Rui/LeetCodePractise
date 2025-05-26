package pers.mingda.cracking_the_coding_interview.chapter4_trees_and_graphs;

/** 4.5 Validate BST: Implement a function to check if a binary tree is a binary search tree. */
public class _4_5ValidateBst {
  public static boolean checkBst(TreeNode node) {
    ResultRecorder result = new ResultRecorder();
    checkBst(node, new TreeNode(Integer.MIN_VALUE), result);
    return result.isValide;
  }

  private static TreeNode checkBst(TreeNode node, TreeNode previous, ResultRecorder result) {
    if (!result.isValide) return node;
    if (node == null) return previous;

    if (previous.data >= node.data) {
      result.isValide = false;
      return node;
    }

    previous = checkBst(node.left, previous, result);
    if (previous.data > node.data) {
      result.isValide = false;
      return node;
    }
    return checkBst(node.right, node, result);
  }

  public static boolean checkBstMinMax(TreeNode node) {
    return checkBstMinMax(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  public static boolean checkBstMinMax(TreeNode node, int min, int max) {
    if (node == null) return true;

    if (node.data <= min || node.data > max) return false;

    return checkBstMinMax(node.left, min, node.data) && checkBstMinMax(node.right, node.data, max);
  }
}

class ResultRecorder {
  boolean isValide = true;
}
