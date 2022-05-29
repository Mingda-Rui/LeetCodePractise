package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC0199BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        return rightSideView(root, 0, new LinkedList<>());
    }

    private List<Integer> rightSideView(TreeNode root, int level, List<Integer> result) {
        if (root == null)
            return result;
        if (level == result.size())
            result.add(root.val);
        rightSideView(root.right, level + 1, result);
        rightSideView(root.left, level + 1, result);
        return result;
    }

    public List<Integer> rightSideViewIterative(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (level == result.size())
                    result.add(node.val);
                if (node.right != null)
                    queue.add(node.right);
                if (node.left != null)
                    queue.add(node.left);
            }
            level++;
        }
        return result;
    }
}
