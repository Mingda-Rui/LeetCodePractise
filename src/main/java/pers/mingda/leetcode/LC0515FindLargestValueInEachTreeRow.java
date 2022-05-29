package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC0515FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                max = Math.max(max, node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            result.add(max);
        }
        return result;
    }

    public List<Integer> largestValuesRecursive(TreeNode root) {
        return largestValuesRecursive(root, 0, new ArrayList<>());
    }

    public List<Integer> largestValuesRecursive(TreeNode root, int level, List<Integer> result) {
        if (root == null)
            return result;
        if (level == result.size()) {
            result.add(root.val);
        } else {
            int currentVal = result.get(level);
            int max = Math.max(currentVal, root.val);
            result.set(level, max);
        }
        largestValuesRecursive(root.left, level + 1, result);
        largestValuesRecursive(root.right, level + 1, result);
        return result;
    }
}
