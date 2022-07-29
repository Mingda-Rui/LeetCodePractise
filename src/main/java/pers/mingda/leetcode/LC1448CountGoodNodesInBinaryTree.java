package pers.mingda.leetcode;

public class LC1448CountGoodNodesInBinaryTree {
    public int goodNodes(TreeNode root) {
        return goodNodes(root, new int[1], root.val);
    }

    private int goodNodes(TreeNode root, int[] resultHolder, int max) {
        if (root == null)
            return resultHolder[0];
        int val = root.val;
        if (val >= max)
            resultHolder[0]++;
        max = Math.max(max, val);
        goodNodes(root.left, resultHolder, max);
        goodNodes(root.right, resultHolder, max);
        return resultHolder[0];
    }
}
