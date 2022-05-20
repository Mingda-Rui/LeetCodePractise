package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.List;

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
}
