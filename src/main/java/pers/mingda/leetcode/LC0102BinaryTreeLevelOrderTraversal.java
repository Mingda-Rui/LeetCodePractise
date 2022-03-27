package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC0102BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int currentSize = queue.size();
            while (currentSize > 0) {
                TreeNode node = queue.poll();
                if (node != null) {
                    list.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
                currentSize--;
            }
            if (!list.isEmpty())
                result.add(list);

        }
        return result;
    }
}
