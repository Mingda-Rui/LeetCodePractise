package pers.mingda.leetcode;

import java.util.Stack;

public class LC0889ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
        int postI = 0;
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);
            TreeNode parent = stack.peek();
            if (parent.val != postorder[postI]) {
                parent.left = node;
            } else {
                while (stack.peek().val == postorder[postI]) {
                    parent = stack.pop();
                    postI++;
                }
                stack.peek().right = node;
            }
            stack.push(node);
        }
        return root;
    }
}



//
// 6 <- parent
// 3
// 1
// stack
//
// preorder = [1,2,4,5,3,6,7]
//
// postP 5
// postorder = [4,5,2,6,7,3,1]