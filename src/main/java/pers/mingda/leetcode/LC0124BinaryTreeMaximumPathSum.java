package pers.mingda.leetcode;

public class LC0124BinaryTreeMaximumPathSum {
    public int maxPathSum(TreeNode root) {
        int[] maxHolder = new int[]{Integer.MIN_VALUE};
        maxPathSumRecursive(root, maxHolder);
        return maxHolder[0];
    }

    private int maxPathSumRecursive(TreeNode root, int[] maxHolder) {
        if (root == null)
            return 0;
        int left = maxPathSumRecursive(root.left, maxHolder);
        left = Math.max(left, 0);
        int right = maxPathSumRecursive(root.right, maxHolder);
        right = Math.max(right, 0);
        int sum = left + root.val + right;
        maxHolder[0] = Math.max(maxHolder[0], sum);
        return Math.max(left, right) + root.val;
    }
}
