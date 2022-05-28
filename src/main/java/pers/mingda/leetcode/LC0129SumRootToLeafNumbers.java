package pers.mingda.leetcode;

public class LC0129SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    public int sumNumbers(TreeNode root, int sum) {
        if (root == null)
            return 0;
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null)
            return sum;
        int leftSum = sumNumbers(root.left, sum);
        int rightSum = sumNumbers(root.right, sum);
        return leftSum + rightSum;
    }
}
