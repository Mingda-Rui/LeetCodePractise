package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.Queue;

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
        if (index >= vals.length)
            return node;
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
        if (index >= vals.length)
            return null;
        String val = vals[index];
        if (val.equals("null"))
            return null;
        int intVal = Integer.parseInt(val);
        return new TreeNode(intVal);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
