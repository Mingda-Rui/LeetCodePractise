package pers.mingda.leetcode;

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
public class LC0437PathSumIII {
    public int pathSum(TreeNode root, int targetSum) {
        return (int)pathSum(root, (long) targetSum, (long) targetSum);
    }

    private long pathSum(TreeNode root, long originalTarget, long remainingTarget) {
        if (root == null) {
            return 0;
        }
        long remains = remainingTarget - ((long) root.val);

        long result = root.val == remainingTarget ? 1 : 0;
        long leftSum = remainingSumPath(root.left, remains);
        long leftSumWithout = pathSum(root.left, originalTarget, originalTarget);
        long rightSum = remainingSumPath(root.right, remains);
        long rightSumWithout = pathSum(root.right, originalTarget, originalTarget);
        return result + leftSum + leftSumWithout + rightSum + rightSumWithout;
    }

    private long remainingSumPath(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }
        long remains = targetSum - (long) root.val;
        long result = root.val == targetSum ? 1 : 0;
        long leftSum = remainingSumPath(root.left, remains);
        long rightSum = remainingSumPath(root.right, remains);
        return result + leftSum + rightSum;
    }
}
