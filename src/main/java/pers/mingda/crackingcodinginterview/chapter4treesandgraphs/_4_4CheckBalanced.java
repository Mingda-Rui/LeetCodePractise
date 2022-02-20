package pers.mingda.crackingcodinginterview.chapter4treesandgraphs;

/**
 *  4.4 Check Balanced: Implement a function to check if a binary tree is balanced. For the purposes of
 *  this question, a balanced tree is defiend to be a tree such that the heights of the two subtrees of any
 *  node never differ by more than one.
 */

public class _4_4CheckBalanced {

    public static boolean isBalanced(TreeNode node) {
        if (node == null)
            return false;
        int leftHeight = getMaxHeight(node.left);
        int rightHeight = getMaxHeight(node.right);

        return Math.abs(leftHeight - rightHeight) <= 1;
    }

    private static int getMaxHeight(TreeNode node) {
        if (node == null)
            return 0;
        int leftMaxHeight = getMaxHeight(node.left);
        int rightMaxHeight = getMaxHeight(node.right);

        return Math.max(leftMaxHeight, rightMaxHeight) + 1;
    }
}
