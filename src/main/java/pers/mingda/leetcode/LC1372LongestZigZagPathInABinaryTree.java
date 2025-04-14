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
public class LC1372LongestZigZagPathInABinaryTree {
    int max = 0;

    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftZigZag = longestZigZag(root.left, true);
        int rightZigZag = longestZigZag(root.right, false);
        int currentMax = Math.max(leftZigZag, rightZigZag);
        max = Math.max(currentMax, max);
        return max;
    }

    private int longestZigZag(TreeNode root, boolean fromLeft) {
        if (root == null) {
            return 0;
        }

        TreeNode continueNode = fromLeft ? root.right : root.left;
        int continueZigZag = longestZigZag(continueNode, !fromLeft) + 1;
        TreeNode newHead = fromLeft ? root.left : root.right;
        int newZigZag = longestZigZag(newHead, fromLeft);
        max = Math.max(max, newZigZag);
        return continueZigZag;
    }
}
