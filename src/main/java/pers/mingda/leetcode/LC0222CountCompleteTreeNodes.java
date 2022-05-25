package pers.mingda.leetcode;

public class LC0222CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        int depth = 0;
        TreeNode pointer = root;
        while (pointer != null) {
            pointer = pointer.left;
            depth++;
        }

        int[] pow = new int[depth];
        pow[0] = 1;

        for (int i = 1; i < pow.length; i++)
            pow[i] = pow[i - 1] * 2;
        int currentCount = 1;
        for (int i = 0; i < depth - 1; i++)
            currentCount += pow[i];

        return countNodes(root, depth, 0, currentCount, pow);
    }

    private int countNodes(TreeNode root, int depth, int currentD, int currentCount, int[] pow) {
        if (root == null)
            return 0;
        if (depth == currentD + 1)
            return currentCount;

        int offset = pow[depth - currentD - 2];
        int rightCount = countNodes(root.right, depth, currentD + 1, currentCount + offset, pow);
        if (rightCount != 0)
            return rightCount;
        int leftCount = countNodes(root.left, depth, currentD + 1, currentCount, pow);
        if (leftCount != 0)
            return leftCount;
        return 0;
    }

    public int countNodesShortest(TreeNode root) {
        if (root == null)
            return 0;
        boolean GO_LEFT = true;
        int leftDepth = nodeDepth(root.left, GO_LEFT);
        int rightDepth = nodeDepth(root.right, !GO_LEFT);
        if (leftDepth == rightDepth)
            return (1 << leftDepth + 1) - 1;
        else
            return countNodesShortest(root.left) + countNodesShortest(root.right) + 1;
    }

    private int nodeDepth(TreeNode root, boolean goLeft) {
        int count = 0;
        while (root != null) {
            count++;
            root = goLeft ? root.left : root.right;
        }
        return count;
    }
}
