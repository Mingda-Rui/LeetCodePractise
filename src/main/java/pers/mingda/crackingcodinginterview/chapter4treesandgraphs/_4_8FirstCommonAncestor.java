package pers.mingda.crackingcodinginterview.chapter4treesandgraphs;

import java.util.LinkedList;
import java.util.List;

/**
 *  4.8 First Common Ancestor: Design an algorithm and write code to find the first common ancestor
 *  of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
 *  necessarily a binary search tree.
 */

public class _4_8FirstCommonAncestor {
    public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> result = new LinkedList<>();
        if (!commonAncestor(root, p, q, result))
            throw new RuntimeException("No common Ancestor!");

        return result.get(0);
    }

    private static boolean commonAncestor(TreeNode node, TreeNode p, TreeNode q, List<TreeNode> result) {
        if (!result.isEmpty() || node == p || node == q)
            return true;
        if (node == null)
            return false;

        boolean left = commonAncestor(node.left, p, q, result);
        boolean right = commonAncestor(node.right, p, q, result);
        if (left && right)
            result.add(node);

        return left || right;
    }
}
