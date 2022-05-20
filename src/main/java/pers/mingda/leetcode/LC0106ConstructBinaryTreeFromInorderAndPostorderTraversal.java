package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC0106ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTreeRecursive(int[] inorder, int[] postorder) {
        int[] postIndexHolder = {postorder.length - 1};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return buildTree(inorder, 0, inorder.length, postorder, postIndexHolder, map);
    }

    private TreeNode buildTree(int[] inorder, int start, int end, int[] postorder, int[] postIndexHolder, Map<Integer, Integer> map) {
        if (start + 1 > end)
            return null;
        else if (start + 1 == end) {
            int val = inorder[start];
            postIndexHolder[0]--;
            return new TreeNode(val);
        }

        int postIndex = postIndexHolder[0];
        int rootVal = postorder[postIndex];
        int inorderIndex = map.get(rootVal);
        postIndexHolder[0]--;
        TreeNode right = buildTree(inorder, inorderIndex + 1, end, postorder, postIndexHolder, map);
        TreeNode left = buildTree(inorder, start, inorderIndex, postorder, postIndexHolder, map);
        TreeNode root = new TreeNode(rootVal, left, right);
        return root;
    }
}
