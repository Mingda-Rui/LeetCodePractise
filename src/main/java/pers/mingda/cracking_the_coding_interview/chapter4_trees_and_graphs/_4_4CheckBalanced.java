package pers.mingda.cracking_the_coding_interview.chapter4_trees_and_graphs;

/**
 * 4.4 Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes
 * of this question, a balanced tree is defiend to be a tree such that the heights of the two
 * subtrees of any node never differ by more than one.
 */
public class _4_4CheckBalanced {

  private static final int UNBALANCED_CODE = Integer.MIN_VALUE;

  public static boolean isBalanced(TreeNode node) {
    int height = getMaxHeight(node);
    return height != UNBALANCED_CODE;
  }

  private static int getMaxHeight(TreeNode node) {
    if (node == null) return 0;
    int leftMaxHeight = getMaxHeight(node.left);
    if (leftMaxHeight == UNBALANCED_CODE) return UNBALANCED_CODE;
    int rightMaxHeight = getMaxHeight(node.right);
    if (rightMaxHeight == UNBALANCED_CODE) return UNBALANCED_CODE;

    boolean isUnbalanced = Math.abs(leftMaxHeight - rightMaxHeight) > 1;
    if (isUnbalanced) return UNBALANCED_CODE;

    return Math.max(leftMaxHeight, rightMaxHeight) + 1;
  }
}
