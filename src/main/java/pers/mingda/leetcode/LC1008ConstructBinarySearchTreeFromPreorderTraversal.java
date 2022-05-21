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

    public TreeNode bstFromPreorderRecursive(int[] preorder, int[] indexHolder, int max) {
        int index = indexHolder[0] + 1;
        if (index >= preorder.length || preorder[index] > max)
            return null;
        int val = preorder[index];
        TreeNode node = new TreeNode(preorder[index]);
        indexHolder[0]++;
        node.left = bstFromPreorderRecursive(preorder, indexHolder, val);
        node.right = bstFromPreorderRecursive(preorder, indexHolder, max);
        return node;
    }
}
