package pers.mingda.leetcode;

import java.util.Stack;

public class LC0114FlattenBinaryTreeToLinkedList {
    public TreeNode flattenRecursive(TreeNode root) {
        if (root == null || root.left == null && root.right == null)
            return root;

        TreeNode leftTail = flattenRecursive(root.left);
        TreeNode rightTail = flattenRecursive(root.right);

        if (leftTail != null)
            leftTail.right = root.right;
        root.right = root.left != null ? root.left : root.right;
        root.left = null;
        return rightTail == null ? leftTail : rightTail;
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
