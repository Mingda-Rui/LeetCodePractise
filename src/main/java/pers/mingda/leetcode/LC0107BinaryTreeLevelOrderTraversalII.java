package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC0107BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottomRecursive(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        return bottomUp(root, 1, result);
    }

    private List<List<Integer>> bottomUp(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null)
            return result;

        if (result.size() < level)
            result.add(0, new LinkedList<>());

        int levelIndex = result.size() - level;
        List<Integer> currentLevel = result.get(levelIndex);
        currentLevel.add(root.val);
        bottomUp(root.left, level + 1, result);
        bottomUp(root.right, level + 1, result);
        return result;
    }

    public List<List<Integer>> levelOrderBottomIterative(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currentLevel = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode next = queue.remove();
                currentLevel.add(next.val);
                if (next.left != null)
                    queue.add(next.left);
                if (next.right != null)
                    queue.add(next.right);
            }
            result.add(0, currentLevel);
        }
        return result;
    }
}
