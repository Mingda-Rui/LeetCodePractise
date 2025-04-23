package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC0662MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> min = new ArrayList<>();
        return widthOfBinaryTree(root, 1, 0, min);
    }

    private int widthOfBinaryTree(TreeNode root, int num, int level, List<Integer> min) {
        if (root == null) return 0;
        if (level == min.size()) min.add(num);

        int leftWidth = widthOfBinaryTree(root.left, num * 2, level + 1, min);
        int rightWidth = widthOfBinaryTree(root.right, num * 2 + 1, level + 1, min);
        int childWidth = Math.max(leftWidth, rightWidth);
        int currentWidth = num - min.get(level) + 1;
        return Math.max(currentWidth, childWidth);
    }

    public int widthOfBinaryTreeIterative(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> num = new LinkedList<>();
        queue.add(root);
        num.add(1);
        int maxWidth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int start = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                int n = num.remove();
                if (i == 0) start = n;
                maxWidth = Math.max(maxWidth, node.val - start + 1);
                if (node.left != null) {
                    queue.add(node.left);
                    num.add(n * 2);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    num.add(n * 2 + 1);
                }
            }
        }
        return maxWidth;
    }
}
