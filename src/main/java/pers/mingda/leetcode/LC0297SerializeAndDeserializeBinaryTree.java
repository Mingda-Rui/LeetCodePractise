package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LC0297SerializeAndDeserializeBinaryTree {
  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder("[");
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int numOfTailingNull = serializeRecursive(queue, sb, 0);
    int length = sb.length();
    int tail = length - (numOfTailingNull * 5) - 1;
    sb.delete(Math.max(1, tail), length).append("]");
    return sb.toString();
  }

  private int serializeRecursive(Queue<TreeNode> queue, StringBuilder sb, int numOfTailingNull) {
    TreeNode node = queue.poll();
    if (node == null) {
      sb.append("null,");
      numOfTailingNull++;
    } else {
      numOfTailingNull = 0;
      sb.append(node.val).append(",");
      queue.offer(node.left);
      queue.offer(node.right);
    }
    if (!queue.isEmpty()) {
      numOfTailingNull = serializeRecursive(queue, sb, numOfTailingNull);
    }
    return numOfTailingNull;
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    Queue<TreeNode> curr = new LinkedList<>();
    String[] vals = data.substring(1, data.length() - 1).split(",");
    TreeNode root = getNode(vals, 0);
    curr.offer(root);
    return deserializeRecursive(curr, vals, 1);
  }

  private TreeNode deserializeRecursive(Queue<TreeNode> curr, String[] vals, int index) {
    TreeNode node = curr.poll();
    if (index >= vals.length) return node;
    if (node != null) {
      node.left = getNode(vals, index);
      index++;
      node.right = getNode(vals, index);
      index++;
      curr.offer(node.left);
      curr.offer(node.right);
    }
    deserializeRecursive(curr, vals, index);
    return node;
  }

  private TreeNode getNode(String[] vals, int index) {
    if (index >= vals.length) return null;
    String val = vals[index];
    if (val.equals("null")) return null;
    int intVal = Integer.parseInt(val);
    return new TreeNode(intVal);
  }

  public String serializePreorder(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    serializePreorder(root, sb);
    return sb.toString();
  }

  private void serializePreorder(TreeNode root, StringBuilder sb) {
    if (root == null) sb.append("#,");
    else {
      sb.append(root.val).append(",");
      serializePreorder(root.left, sb);
      serializePreorder(root.right, sb);
    }
  }

  public TreeNode deserializePreorder(String data) {
    String[] arr = data.split(",");
    int[] indexHolder = new int[1];
    return deserializePreorder(arr, indexHolder);
  }

  private TreeNode deserializePreorder(String[] arr, int[] indexHolder) {
    int index = indexHolder[0];
    indexHolder[0]++;
    String val = arr[index];
    if (val.equals("#")) return null;
    int num = Integer.parseInt(val);
    TreeNode root = new TreeNode(num);
    root.left = deserializePreorder(arr, indexHolder);
    root.right = deserializePreorder(arr, indexHolder);
    return root;
  }

  public String serializeIterativeBfs(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      root = queue.poll();
      sb.append(root == null ? "#" : root.val).append(",");
      if (root != null) {
        queue.offer(root.left);
        queue.offer(root.right);
      }
    }
    return sb.toString();
  }

  public TreeNode deserializeIterativeBfs(String data) {
    String[] arr = data.split(",");
    Queue<TreeNode> queue = new LinkedList<>();
    TreeNode result = createNode(arr[0]);
    queue.offer(result);
    for (int i = 1; i + 1 < arr.length; i++) {
      TreeNode root = queue.poll();
      root.left = createNode(arr[i]);
      i++;
      root.right = createNode(arr[i]);
      if (root.left != null) queue.offer(root.left);
      if (root.right != null) queue.offer(root.right);
    }
    return result;
  }

  private TreeNode createNode(String val) {
    if (val.equals("#") || val.isEmpty()) return null;
    int intVal = Integer.parseInt(val);
    return new TreeNode(intVal);
  }

  public String serializeIterativePreorder(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    Stack<TreeNode> stack = new Stack<>();
    while (root != null || !stack.isEmpty()) {
      if (root != null) {
        stack.push(root);
        sb.append(root.val).append(",");
        root = root.left;
      } else {
        sb.append("#,");
        root = stack.pop();
        root = root.right;
      }
    }
    return sb.toString();
  }

  public TreeNode deserializeIterativePreorder(String data) {
    String[] arr = data.split(",");
    Stack<TreeNode> stack = new Stack<>();
    TreeNode result = createNode(arr[0]);
    stack.push(result);
    for (int i = 1; i + 1 < arr.length; i++) {
      TreeNode node = createNode(arr[i]);
      if (stack.peek() == null) {
        stack.pop();
        stack.pop().right = node;
      } else stack.peek().left = node;
      stack.push(node);
    }
    return result;
  }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

//        1
//    2       3
//  4   5   6   7
// # # # # # # # #
