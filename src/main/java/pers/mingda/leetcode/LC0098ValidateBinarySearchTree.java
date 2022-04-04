package pers.mingda.leetcode;

public class LC0098ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        boolean[] resultHolder = new boolean[]{true};
        preorder(root, null, resultHolder);
        return resultHolder[0];
    }

    private TreeNode preorder(TreeNode root, TreeNode prev, boolean[] resultHolder) {
        if (!resultHolder[0] || root == null)
            return prev;
        TreeNode left = preorder(root.left, prev, resultHolder);
        if (left != null && left.val >= root.val) {
            resultHolder[0] = false;
            return root;
        }
        return preorder(root.right, root, resultHolder);
    }
}
