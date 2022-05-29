package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC0662MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        List<Long> min = new ArrayList<>();
        List<Long> max = new ArrayList<>();
        widthOfBinaryTree(root, 1, 0, min, max);
        long maxWid = Long.MIN_VALUE;
        for (int i = 0; i < min.size(); i++) {
            long currentWid = max.get(i) - min.get(i) + 1;
            maxWid = Math.max(maxWid, currentWid);
        }
        return (int) maxWid;
    }

    private void widthOfBinaryTree(TreeNode root, long num, int level, List<Long> min, List<Long> max) {
        if (root == null)
            return;
        if (level == min.size()) {
            min.add(num);
            max.add(num);
        } else {
            long currentMin = min.get(level);
            long newMin = Math.min(currentMin, num);
            min.set(level, newMin);
            long currentMax = max.get(level);
            long newMax = Math.max(currentMax, num);
            max.set(level, newMax);
        }
        widthOfBinaryTree(root.left, num * 2, level + 1, min, max);
        widthOfBinaryTree(root.right, num * 2 + 1, level + 1, min, max);
    }
}
