package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC0662MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> min = new ArrayList<>();
        List<Integer> width = new ArrayList<>();
        widthOfBinaryTree(root, 1, 0, min, width);
        int maxWid = Integer.MIN_VALUE;
        for (int i = 0; i < min.size(); i++) {
            int currentWid = width.get(i);
            maxWid = Math.max(maxWid, currentWid);
        }
        return maxWid;
    }

    private void widthOfBinaryTree(TreeNode root, int num, int level, List<Integer> min, List<Integer> width) {
        if (root == null)
            return;
        if (level == min.size()) {
            min.add(num);
            width.add(1);
        } else {
            int currentWidth = width.get(level);
            int maxWidth = Math.max(currentWidth, num - min.get(level) + 1);
            width.set(level, maxWidth);
        }
        widthOfBinaryTree(root.left, num * 2, level + 1, min, width);
        widthOfBinaryTree(root.right, num * 2 + 1, level + 1, min, width);
    }
}
