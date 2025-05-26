package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LC0889ConstructBinaryTreeFromPreorderAndPostorderTraversal {
  public TreeNode constructFromPrePostRefactored(int[] preorder, int[] postorder) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode root = new TreeNode(preorder[0]);
    stack.push(root);
    int postI = 0;
    for (int i = 1; i < preorder.length; i++) {
      TreeNode node = new TreeNode(preorder[i]);
      while (stack.peek().val == postorder[postI]) {
        stack.pop();
        postI++;
      }
      if (stack.peek().left == null) stack.peek().left = node;
      else stack.peek().right = node;
      stack.push(node);
    }
    return root;
  }

  public TreeNode constructFromPrePostRecursive(int[] preorder, int[] postorder) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < postorder.length; i++) map.put(postorder[i], i);
    return constructFromPrePostRecursive(preorder, new int[] {0}, postorder, postorder.length, map);
  }

  private TreeNode constructFromPrePostRecursive(
      int[] preorder,
      int[] preIndexHolder,
      int[] postorder,
      int postBoundray,
      Map<Integer, Integer> map) {
    int preIndex = preIndexHolder[0];
    if (preIndex >= preorder.length) return null;
    int val = preorder[preIndex];
    int postIndex = map.get(val);
    if (postIndex > postBoundray) return null;
    TreeNode node = new TreeNode(val);
    preIndexHolder[0]++;

    node.left = constructFromPrePostRecursive(preorder, preIndexHolder, postorder, postIndex, map);
    node.right = constructFromPrePostRecursive(preorder, preIndexHolder, postorder, postIndex, map);

    return node;
  }

  public TreeNode constructFromPrePostRecursiveStartEnd(int[] preorder, int[] postorder) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < postorder.length; i++) map.put(postorder[i], i);
    return constructFromPrePostRecursiveStartEnd(
        preorder, new int[] {0}, postorder, 0, postorder.length, map);
  }

  private TreeNode constructFromPrePostRecursiveStartEnd(
      int[] preorder,
      int[] preIndexHolder,
      int[] postorder,
      int postS,
      int postE,
      Map<Integer, Integer> map) {
    int index = preIndexHolder[0];
    if (index >= preorder.length || postS >= postE) return null;
    TreeNode node = new TreeNode(preorder[index]);
    preIndexHolder[0]++;
    if (postS + 1 >= postE) return node;
    int postIndex = map.get(preorder[preIndexHolder[0]]);
    node.left =
        constructFromPrePostRecursiveStartEnd(
            preorder, preIndexHolder, postorder, postS, postIndex + 1, map);
    node.right =
        constructFromPrePostRecursiveStartEnd(
            preorder, preIndexHolder, postorder, postIndex + 1, postE - 1, map);
    return node;
  }

  public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
    return constructFromPrePostRecursiveSimplest(preorder, new int[] {0}, postorder, new int[] {0});
  }

  private TreeNode constructFromPrePostRecursiveSimplest(
      int[] preorder, int[] preIndexHolder, int[] postorder, int[] postIndexHolder) {
    int preIndex = preIndexHolder[0];
    int val = preorder[preIndex];
    TreeNode root = new TreeNode(val);
    preIndexHolder[0]++;

    if (val != postorder[postIndexHolder[0]])
      root.left =
          constructFromPrePostRecursiveSimplest(
              preorder, preIndexHolder, postorder, postIndexHolder);
    if (val != postorder[postIndexHolder[0]])
      root.right =
          constructFromPrePostRecursiveSimplest(
              preorder, preIndexHolder, postorder, postIndexHolder);
    postIndexHolder[0]++;
    return root;
  }
}

// preorder = [1,2,4,5,3,6,7],
// postorder = [4,5,2,6,7,3,1]

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
