package pers.mingda.leetcode;

public class LC0106ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTreeRecursive(int[] inorder, int[] postorder) {
        int[] postIndexHolder = {postorder.length - 1};
        return buildTree(inorder, 0, inorder.length, postorder, postIndexHolder);
    }

    private TreeNode buildTree(int[] inorder, int start, int end, int[] postorder, int[] postIndexHolder) {
        if (start + 1 > end)
            return null;
        else if (start + 1 == end) {
            int val = inorder[start];
            postIndexHolder[0]--;
            return new TreeNode(val);
        }

        int postIndex = postIndexHolder[0];
        int rootVal = postorder[postIndex];
        int inorderIndex = 0;
        for (int i = start; i < end; i++) {
            if (inorder[i] == rootVal)
                inorderIndex = i;
        }
        postIndexHolder[0]--;
        TreeNode right = buildTree(inorder, inorderIndex + 1, end, postorder, postIndexHolder);
        TreeNode left = buildTree(inorder, start, inorderIndex, postorder, postIndexHolder);
        TreeNode root = new TreeNode(rootVal, left, right);
        return root;
    }
}
