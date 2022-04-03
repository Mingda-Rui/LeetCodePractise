package pers.mingda.leetcode;

public class LC0105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] inorderMap = new int[6001];
        for (int i = 0; i < inorder.length; i++) {
            int val = inorder[i];
            inorderMap[val + 3000] = i;
        }
        return buildTree(preorder, new int[1], 0, inorder.length, inorderMap);
    }

    private TreeNode buildTree(int[] preorder, int[] indexHolder, int inL, int inR, int[] inorderMap) {
        if (inL == inR)
            return null;
        int index = indexHolder[0];
        indexHolder[0]++;
        int parentVal = preorder[index];
        TreeNode parent = new TreeNode(parentVal);

        // int pValInorder = findInorder(inorder, inL, inR, parentVal);
        int pValInorder = inorderMap[parentVal + 3000];
        parent.left = buildTree(preorder, indexHolder, inL, pValInorder, inorderMap);
        parent.right = buildTree(preorder, indexHolder, pValInorder + 1, inR, inorderMap);
        return parent;
    }
}
