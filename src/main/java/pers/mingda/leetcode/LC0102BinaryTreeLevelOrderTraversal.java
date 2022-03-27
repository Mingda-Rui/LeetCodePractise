package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC0102BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> nextQueue = new LinkedList<>();
        queue.offer(root);
        List<Integer> list = new LinkedList<>();
        while (!queue.isEmpty() || !nextQueue.isEmpty()) {
            if (queue.isEmpty()) {
                result.add(list);
                list = new LinkedList<>();
                Queue<TreeNode> tmp = queue;
                queue = nextQueue;
                nextQueue = tmp;
            }
            TreeNode node = queue.poll();
            if (node != null) {
                list.add(node.val);
                nextQueue.add(node.left);
                nextQueue.add(node.right);
            }
        }
        return result;
    }
}
