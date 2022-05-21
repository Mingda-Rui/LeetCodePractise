package pers.mingda.leetcode;

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
}
