package pers.mingda.leetcode;

public class LC0606ConstructStringFromBinaryTree {
    public String tree2str(TreeNode root) {
        if (root == null) return "";
        String left = tree2str(root.left);
        String right = tree2str(root.right);

        if (!left.isEmpty() || !right.isEmpty()) left = addParenthesis(left);
        if (!right.isEmpty()) right = addParenthesis(right);
        return root.val + left + right;
    }

    private String addParenthesis(String tree) {
        return "(" + tree + ")";
    }
}
