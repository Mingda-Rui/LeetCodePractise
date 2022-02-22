package pers.mingda.crackingcodinginterview.chapter4treesandgraphs;

/**
 *  4.5 Validate BST: Implement a function to check if a binary tree is a binary search tree.
 */

public class _4_5ValidateBst {

    public static boolean checkBst(TreeNode node) {
        if (node == null)
            return true;
        if (node.left != null && node.left.data > node.data)
            return false;
        if (node.right != null && node.right.data <= node.data)
            return false;

        return checkBst(node.left) && checkBst(node.right);
    }
}
