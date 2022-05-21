package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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

    public TreeNode buildTreeIterative(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        Stack<TreeNode> stack = new Stack<>();
        TreeNode rootPointer = null;
        for (int i = postorder.length - 1; i >= 0; i--) {
            int rootVal = postorder[i];
            TreeNode root = new TreeNode(rootVal);
            if (i == postorder.length - 1)
                rootPointer = root;
            int inorderIndex = map.get(rootVal);
            if (!stack.isEmpty()) {
                TreeNode parent = stack.peek();
                if (map.get(parent.val) < inorderIndex)
                    parent.right = root;
                else {
                    do parent = stack.pop();
                    while (!stack.isEmpty() && map.get(stack.peek().val) > inorderIndex);
                    parent.left = root;
                }
            }
            stack.push(root);
        }
        return rootPointer;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int ip = inorder.length - 1;
        int rootVal = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootVal);

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        for (int pp = postorder.length - 2; pp >= 0; pp--) {
            TreeNode node = new TreeNode(postorder[pp]);
            if (stack.peek().val != inorder[ip]) {
                stack.peek().right = node;
            } else {
                TreeNode parent = stack.peek();
                while (!stack.isEmpty() && stack.peek().val == inorder[ip]) {
                    parent = stack.pop();
                    ip--;
                }
                parent.left = node;
            }
            stack.push(node);
        }
        return root;
    }
}
