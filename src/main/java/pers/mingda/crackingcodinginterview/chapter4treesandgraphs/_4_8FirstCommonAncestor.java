package pers.mingda.crackingcodinginterview.chapter4treesandgraphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *  4.8 First Common Ancestor: Design an algorithm and write code to find the first common ancestor
 *  of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
 *  necessarily a binary search tree.
 */

public class _4_8FirstCommonAncestor {
    public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> result = new LinkedList<>();
        if (!commonAncestor(root, p, q, result))
            throw new RuntimeException("No common ancestor!");

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

    public static TreeNode commonAncestorReturnNode(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode commonAncestor = commonAncestorReturnNodeRecursive(root, p, q);
        if (commonAncestor == p || commonAncestor == q || commonAncestor == null) {
            throw new RuntimeException("No common ancestor!");
        }
        return commonAncestor;
    }

    private static TreeNode commonAncestorReturnNodeRecursive(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;

        TreeNode left = commonAncestorReturnNodeRecursive(root.left, p, q);
        if (left != null && left != p && left != q)
            return left;
        TreeNode right = commonAncestorReturnNodeRecursive(root.right, p, q);

        if (left != null && right != null)
            return root;

        return left == null ? right : left;

    }

    public static TreeNode commonAncestorLinksToParents(TreeNode p, TreeNode q) {
        if (p == null || q == null)
            return null;
        Set<TreeNode> parents = new HashSet<>();
        while (p.parent != null) {
            parents.add(p.parent);
            p = p.parent;
        }
        while (q.parent != null) {
            if (parents.contains(q.parent))
                return q.parent;
            q = q.parent;
        }
        throw new RuntimeException("No common ancestor!");
    }

    public static TreeNode commonAncestorCheckCoverTheOtherNode(TreeNode p, TreeNode q) {
        if (p == null || q == null)
            return null;
        if (isChild(p, q))
            return p;
        if (isChild(q, p))
            return q;

        while (p.parent != null) {
            TreeNode parent = p.parent;
            TreeNode sibling = parent.left == p ? parent.right : parent.left;
            if (isChild(sibling, q))
                return parent;
            p = p.parent;
        }
        throw new RuntimeException("No common ancestor!");
    }

    private static boolean isChild(TreeNode node, TreeNode child) {
        if (node == null)
            return false;
        if (node == child)
            return true;
        return isChild(node.left, child) || isChild(node.right, child);
    }
}
