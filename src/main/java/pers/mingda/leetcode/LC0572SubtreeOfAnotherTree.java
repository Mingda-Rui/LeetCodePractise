package pers.mingda.leetcode;

public class LC0572SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (compareSubtree(root, subRoot))
            return true;
        if (root == null || subRoot == null)
            return false;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean compareSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null)
            return true;
        if (root == null || subRoot == null || root.val != subRoot.val)
            return false;

        return compareSubtree(root.left, subRoot.left) && compareSubtree(root.right, subRoot.right);
    }
}
