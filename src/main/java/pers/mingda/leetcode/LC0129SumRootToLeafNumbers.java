package pers.mingda.leetcode;

public class LC0129SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, new StringBuilder(), new int[1]);
    }

    public int sumNumbers(TreeNode root, StringBuilder num, int[] sumHolder) {
        if (root == null)
            return 0;
        num.append(root.val);
        if (root.left == null && root.right == null) {
            String numStr = num.toString();
            sumHolder[0] += Integer.parseInt(numStr);
        } else {
            sumNumbers(root.left, num, sumHolder);
            sumNumbers(root.right, num, sumHolder);
        }
        num.deleteCharAt(num.length() - 1);
        return sumHolder[0];
    }
}
