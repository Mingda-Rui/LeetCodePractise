package pers.mingda.leetcode;

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
public class LC0450DeleteNodeInABST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val == key) {
            return merge(root.left, root.right);
        }
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    private TreeNode merge(TreeNode left, TreeNode right) {
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }
        right.left = merge(left, right.left);
        return right;
    }
}
