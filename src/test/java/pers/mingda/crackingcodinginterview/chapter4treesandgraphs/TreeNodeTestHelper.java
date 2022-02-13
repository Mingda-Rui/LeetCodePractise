package pers.mingda.crackingcodinginterview.chapter4treesandgraphs;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeTestHelper {

    private static final String NULL = "null";

    public boolean compare(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return true;

        boolean isEqual = false;
        try {
            isEqual = node1.data == node2.data;
        } catch (NullPointerException ex) {
            return false;
        }
        isEqual = isEqual && compare(node1.left, node2.left);
        isEqual = isEqual && compare(node1.right, node2.right);
        return isEqual;
    }

    public String treeNodeSerialize(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        String serial = treeNodeSerializer(queue, new StringBuilder());
        serial = removeTailingNull(serial);
        return "[" + serial + "]";
    }

    protected String treeNodeSerializer(Queue<TreeNode> queue, StringBuilder strBuilder) {
        if (queue.isEmpty()) {
            return strBuilder.toString();
        }
        String serial = null;
        TreeNode node = queue.remove();
        if (node == null)
            serial = NULL;
        else {
            serial = String.valueOf(node.data);
            queue.add(node.left);
            queue.add(node.right);
        }
        strBuilder.append(serial).append(", ");
        return treeNodeSerializer(queue, strBuilder);
    }

    protected String removeTailingNull(String str) {
        for (int i = str.length() - 1; i >= 0; i--) {
            if (Character.isDigit(str.charAt(i))) {
                return str.substring(0, i + 1);
            }
        }
        return "";
    }

    public TreeNode createTreeNode(int head, int left, int right) {
        TreeNode leftNode = new TreeNode(left);
        TreeNode rightNode = new TreeNode(right);
        return createTreeNode(head, leftNode, rightNode);
    }

    public TreeNode createTreeNode(int head, TreeNode left, TreeNode right) {
        TreeNode root = new TreeNode(head);
        root.setLeftChild(left);
        root.setRightChild(right);
        return root;
    }
}
