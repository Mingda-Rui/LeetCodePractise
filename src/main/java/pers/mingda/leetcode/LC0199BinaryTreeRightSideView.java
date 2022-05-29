package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.List;

public class LC0199BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        rightSideView(root, 0, result);
        return result;
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
}
