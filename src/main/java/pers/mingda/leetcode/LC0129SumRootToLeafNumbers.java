package pers.mingda.leetcode;

import java.util.Stack;

public class LC0129SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    public int sumNumbers(TreeNode root, int sum) {
        if (root == null) return 0;
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) return sum;
        int leftSum = sumNumbers(root.left, sum);
        int rightSum = sumNumbers(root.right, sum);
        return leftSum + rightSum;
    }

    public int sumNumbersIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        int sum = 0;
        int current = 0;
        TreeNode prev = null;
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                current = current * 10 + root.val;
                root = root.left;
            }
            root = stack.peek();

            if (root.right == null || root.right == prev) {
                if (root.left == null && root.right == null) sum += current;
                current /= 10;
                prev = stack.pop();
                root = null;
            } else {
                root = root.right;
            }
        }
        return sum;
    }
}
