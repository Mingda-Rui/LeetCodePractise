package pers.mingda.leetcode;

public class LC0105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] inorderMap = new int[6001];
        for (int i = 0; i < inorder.length; i++) {
            int val = inorder[i];
            inorderMap[val + 3000] = i;
        }
        return buildTree(preorder, 0, 0, inorder.length, inorderMap);
    }

    private TreeNode buildTree(int[] preorder, int index, int inL, int inR, int[] inorderMap) {
        if (inL == inR)
            return null;

        int parentVal = preorder[index];
        TreeNode parent = new TreeNode(parentVal);
        int pValInorder = inorderMap[parentVal + 3000];

        parent.left = buildTree(preorder, index + 1, inL, pValInorder, inorderMap);
        index = index + (pValInorder - inL + 1);
        parent.right = buildTree(preorder, index, pValInorder + 1, inR, inorderMap);
        return parent;
    }
}
