package pers.mingda.leetcode;

public class LC1448CountGoodNodesInBinaryTree {
    public int goodNodes(TreeNode root) {
        return goodNodes(root, root.val);
    }

    private int goodNodes(TreeNode root, int max) {
        if (root == null)
            return 0;
        int val = root.val;
        int result = val >= max ? 1 : 0;
        max = Math.max(max, val);
        result += goodNodes(root.left, max);
        result += goodNodes(root.right, max);
        return result;
    }
}
