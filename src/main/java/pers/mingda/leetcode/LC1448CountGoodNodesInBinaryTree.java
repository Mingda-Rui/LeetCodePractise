package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LC1448CountGoodNodesInBinaryTree {
    public int goodNodes(TreeNode root) {
        return goodNodes(root, root.val);
    }

    private int goodNodes(TreeNode root, int max) {
        if (root == null)
            return 0;
        int val = root.val;
        int result = val >= max ? 1 : 0;
        max = Math.max(max, val);
        result += goodNodes(root.left, max);
        result += goodNodes(root.right, max);
        return result;
    }

    public int goodNodesIterative(TreeNode root) {
        int result = 0;
        Map<TreeNode, Integer> maxMap = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        maxMap.put(root, root.val);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int val = node.val;
            int parentMax = maxMap.get(node);
            if (val >= parentMax)
                result++;
            if (node.left != null) {
                TreeNode left = node.left;
                stack.push(left);
                int max = Math.max(left.val, parentMax);
                maxMap.put(left, max);
            }
            if (node.right != null) {
                TreeNode right = node.right;
                stack.push(right);
                int max = Math.max(right.val, parentMax);
                maxMap.put(right, max);
            }
        }
        return result;
    }
}
