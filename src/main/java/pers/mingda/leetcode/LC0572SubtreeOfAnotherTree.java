package pers.mingda.leetcode;

public class LC0572SubtreeOfAnotherTree {
    public boolean isSubtreeDfs(TreeNode root, TreeNode subRoot) {
        if (isSameTree(root, subRoot))
            return true;
        if (root == null || subRoot == null)
            return false;

        return isSubtreeDfs(root.left, subRoot) || isSubtreeDfs(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null)
            return root == subRoot;
        return root.val == subRoot.val
                && isSameTree(root.left, subRoot.left)
                && isSameTree(root.right, subRoot.right);
    }
}
