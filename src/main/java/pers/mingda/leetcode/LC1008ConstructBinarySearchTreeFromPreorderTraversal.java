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

    public TreeNode bstFromPreorderRecursive(int[] preorder, int[] indexHolder, int min, int max) {
        int index = indexHolder[0] + 1;
        if (index >= preorder.length)
            return null;
        int val = preorder[index];
        if (val < min || val > max)
            return null;
        TreeNode node = new TreeNode(preorder[index]);
        indexHolder[0]++;
        TreeNode left = bstFromPreorderRecursive(preorder, indexHolder, min, val);
        TreeNode right = bstFromPreorderRecursive(preorder, indexHolder, val, max);
        node.left = left;
        node.right = right;
        return node;
    }
}
