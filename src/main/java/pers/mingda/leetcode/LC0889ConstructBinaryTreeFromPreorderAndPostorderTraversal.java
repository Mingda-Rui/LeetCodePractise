package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;
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

    public TreeNode constructFromPrePostRecursive(int[] preorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < postorder.length; i++)
            map.put(postorder[i], i);
        return constructFromPrePostRecursive(preorder, new int[]{0}, postorder, postorder.length, map);
    }

    private TreeNode constructFromPrePostRecursive(int[] preorder, int[] preIndexHolder, int[] postorder, int postBoundray, Map<Integer, Integer> map) {
        int preIndex = preIndexHolder[0];
        if (preIndex >= preorder.length)
            return null;
        int val = preorder[preIndex];
        int postIndex = map.get(val);
        if (postIndex > postBoundray)
            return null;
        TreeNode node = new TreeNode(val);
        preIndexHolder[0]++;

        node.left = constructFromPrePostRecursive(preorder, preIndexHolder, postorder, postIndex, map);
        node.right = constructFromPrePostRecursive(preorder, preIndexHolder, postorder, postIndex, map);

        return node;
    }

    public TreeNode constructFromPrePostRecursiveStartEnd(int[] preorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < postorder.length; i++)
            map.put(postorder[i], i);
        return constructFromPrePostRecursiveStartEnd(preorder, new int[]{0}, postorder, 0, postorder.length, map);
    }

    private TreeNode constructFromPrePostRecursiveStartEnd(int[] preorder, int[] preIndexHolder, int[] postorder, int postS, int postE, Map<Integer, Integer> map) {
        int index = preIndexHolder[0];
        if (index >= preorder.length || postS >= postE)
            return null;
        TreeNode node = new TreeNode(preorder[index]);
        preIndexHolder[0]++;
        if (postS + 1 >= postE)
            return node;
        int postIndex = map.get(preorder[preIndexHolder[0]]);
        node.left = constructFromPrePostRecursiveStartEnd(preorder, preIndexHolder, postorder, postS, postIndex + 1, map);
        node.right = constructFromPrePostRecursiveStartEnd(preorder, preIndexHolder, postorder, postIndex + 1, postE - 1, map);
        return node;
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