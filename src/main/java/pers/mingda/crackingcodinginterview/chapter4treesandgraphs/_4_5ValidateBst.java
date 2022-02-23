package pers.mingda.crackingcodinginterview.chapter4treesandgraphs;

/**
 *  4.5 Validate BST: Implement a function to check if a binary tree is a binary search tree.
 */

public class _4_5ValidateBst {
    public static boolean checkBst(TreeNode node) {
        ResultRecorder result = new ResultRecorder();
        checkBst(node, new TreeNode(Integer.MIN_VALUE), result);
        return result.isValide;
    }

    public static TreeNode checkBst(TreeNode node, TreeNode previous, ResultRecorder result) {
        if (!result.isValide)
            return node;
        if (node == null)
            return previous;

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

}

class ResultRecorder {
    boolean isValide = true;
}
