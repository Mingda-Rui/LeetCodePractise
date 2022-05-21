package pers.mingda.leetcode;

import java.util.Stack;

public class LC0114FlattenBinaryTreeToLinkedList {
    public TreeNode flattenRecursive(TreeNode root) {
        if (root == null || root.left == null && root.right == null)
            return root;

        TreeNode rootRight = root.right;
        if (root.left != null) {
            TreeNode leftTail = flattenRecursive(root.left);
            leftTail.right = rootRight;
            root.right = root.left;
            root.left = null;
            if (rootRight == null)
                return leftTail;
        }
        return flattenRecursive(rootRight);
    }

    public void flattenIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root != null)
            stack.push(root);
        TreeNode dummyHead = new TreeNode(-1, null, root);
        root = dummyHead;
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            root.right = current;
            if (current.right != null) {
                stack.push(current.right);
                current.right = null;
            }
            if (current.left != null) {
                stack.push(current.left);
                current.left = null;
            }
            root = current;
        }
    }
}
