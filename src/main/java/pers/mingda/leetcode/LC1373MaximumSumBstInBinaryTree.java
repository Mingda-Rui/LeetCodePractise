package pers.mingda.leetcode;

public class LC1373MaximumSumBstInBinaryTree {

}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int max = 0;

    public int maxSumBST(TreeNode root) {
        maxSumBSTHelper(root);
        return max;
    }

    public Result maxSumBSTHelper(TreeNode root) {
        if (root == null)
            return null;
        if (root.left == null && root.right == null) {
            max = Math.max(max, root.val);
            return new Result(root.val, root.val, root.val, true);
        }


        Result lResult = maxSumBSTHelper(root.left);
        Result rResult = maxSumBSTHelper(root.right);

        int small = lResult == null ? root.val : lResult.small;
        int larget = rResult == null ? root.val : rResult.large;

        int leftSum = lResult == null ? 0 : lResult.sum;
        int rightSum = rResult == null ? 0 : rResult.sum;
        int sum = leftSum + rightSum + root.val;

        boolean isLeftBst = lResult == null || (lResult.isBst && lResult.large < root.val);
        boolean isRightBst = rResult == null || (rResult.isBst && rResult.small > root.val);
        boolean isBst = isLeftBst && isRightBst;
        if (isBst)
            max = Math.max(max, sum);
        return new Result(small, larget, sum, isLeftBst && isRightBst);
    }
}

class Result {
    int small;
    int large;
    int sum;
    boolean isBst;

    public Result(int small, int large, int sum, boolean isBst) {
        this.small = small;
        this.large = large;
        this.sum = sum;
        this.isBst = isBst;
    }
}
