package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC0662MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> min = new ArrayList<>();
        return widthOfBinaryTree(root, 1, 0, min);
    }

    private int widthOfBinaryTree(TreeNode root, int num, int level, List<Integer> min) {
        if (root == null)
            return 0;
        if (level == min.size())
            min.add(num);

        int leftWidth = widthOfBinaryTree(root.left, num * 2, level + 1, min);
        int rightWidth = widthOfBinaryTree(root.right, num * 2 + 1, level + 1, min);
        int childWidth = Math.max(leftWidth, rightWidth);
        int currentWidth = num - min.get(level) + 1;
        return Math.max(currentWidth, childWidth);
    }
}
