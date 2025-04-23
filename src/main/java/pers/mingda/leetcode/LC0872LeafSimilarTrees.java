package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class LC0872LeafSimilarTrees {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        return Objects.equals(getLeafList(root1), getLeafList(root2));
    }

    private List<Integer> getLeafList(TreeNode node) {
        if (node == null) {
            return List.of();
        }
        if (node.left == null && node.right == null) {
            return List.of(node.val);
        }
        List<Integer> result = new LinkedList<>();
        result.addAll(getLeafList(node.left));
        result.addAll(getLeafList(node.right));
        return result;
    }
}
