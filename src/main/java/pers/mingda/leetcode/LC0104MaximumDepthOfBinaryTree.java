package pers.mingda.leetcode;

public class LC0104MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right);

        return Math.max(lDepth, rDepth) + 1;
    }
}
