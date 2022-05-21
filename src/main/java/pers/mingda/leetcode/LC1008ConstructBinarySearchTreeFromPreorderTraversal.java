package pers.mingda.leetcode;

import java.util.Stack;

public class LC1008ConstructBinarySearchTreeFromPreorderTraversal {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i]);
            if (node.val < stack.peek().val)
                stack.peek().left = node;
            else {
                TreeNode parent = stack.pop();
                while (!stack.isEmpty() && node.val > stack.peek().val)
                    parent = stack.pop();
                parent.right = node;
            }
            stack.push(node);
        }
        return root;
    }
}
