package pers.mingda.leetcode;

public class LC0235LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        else if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    public TreeNode lowestCommonAncestorNonBst(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        boolean rootEquals = root == p || root == q;
        TreeNode left = lowestCommonAncestorNonBst(root.left, p, q);
        if (left != null && left != p && left != q)
            return left;
        if (rootEquals && left != null) {
            return root;
        }
        TreeNode right = lowestCommonAncestorNonBst(root.right, p, q);
        if (right != null && right != p && right != q)
            return right;
        if (rootEquals && right != null) {
            return root;
        }
        if (left != null && right != null)
            return root;

        if (p == root || p == left || p == right)
            return p;
        if (q == root || q == left || q == right)
            return q;

        return null;
    }
}
