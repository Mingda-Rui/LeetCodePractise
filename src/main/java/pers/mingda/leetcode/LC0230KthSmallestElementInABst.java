package pers.mingda.leetcode;

public class LC0230KthSmallestElementInABst {
    public int kthSmallest(TreeNode root, int k) {
        int[] resultHolder = new int[]{-1};
        kthSmallestRecursive(root, k, resultHolder);
        return resultHolder[0];
    }

    private int kthSmallestRecursive(TreeNode root, int k, int[] resultHolder) {
        if (root == null || k == 0)
            return k;
        k = kthSmallestRecursive(root.left, k, resultHolder);
        if (k == 1)
            resultHolder[0] = root.val;
        return kthSmallestRecursive(root.right, k - 1, resultHolder);
    }
}
