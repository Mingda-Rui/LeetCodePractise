package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC0103BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> currentLayer = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode next = queue.remove();
                if (next.left != null)
                    queue.add(next.left);
                if (next.right != null)
                    queue.add(next.right);
                if (leftToRight)
                    currentLayer.add(next.val);
                else
                    currentLayer.addFirst(next.val);
            }
            leftToRight = !leftToRight;
            result.add(currentLayer);
        }
        return result;
    }
}
