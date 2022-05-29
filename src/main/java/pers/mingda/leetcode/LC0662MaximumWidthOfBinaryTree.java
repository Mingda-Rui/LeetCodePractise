package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC0662MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> min = new ArrayList<>();
        List<Integer> width = new ArrayList<>();
        return widthOfBinaryTree(root, 1, 0, min, width);
    }

    private int widthOfBinaryTree(TreeNode root, int num, int level, List<Integer> min, List<Integer> width) {
        if (root == null)
            return 0;
        if (level == min.size()) {
            min.add(num);
            width.add(1);
        } else {
            int currentWidth = width.get(level);
            int maxWidth = Math.max(currentWidth, num - min.get(level) + 1);
            width.set(level, maxWidth);
        }
        int leftWidth = widthOfBinaryTree(root.left, num * 2, level + 1, min, width);
        int rightWidth = widthOfBinaryTree(root.right, num * 2 + 1, level + 1, min, width);
        int childWidth = Math.max(leftWidth, rightWidth);
        return Math.max(width.get(level), childWidth);
    }
}
