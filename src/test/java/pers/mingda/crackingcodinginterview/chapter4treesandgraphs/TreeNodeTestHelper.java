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
        String serial = treeNodeSerialize(queue, new StringBuilder());
        serial = removeTailingNull(serial);
        return "[" + serial + "]";
    }

    protected String treeNodeSerialize(Queue<TreeNode> queue, StringBuilder strBuilder) {
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
        return treeNodeSerialize(queue, strBuilder);
    }

    public TreeNode treeNodeDeserialize(String treeSerial) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = null;
        int valIndex = getNextIndex(treeSerial, 0);
        String val = getValue(treeSerial, valIndex);
        if (val == null)
            return root;

        root = new TreeNode(Integer.parseInt(val));
        queue.add(root);
        queue.add(root);
        treeNodeDeserialize(treeSerial, queue, valIndex);
        return root;
    }

    private void treeNodeDeserialize(String treeSerial, Queue<TreeNode> queue, int prevIndex) {
        if (queue.isEmpty()) {
            return;
        }

        TreeNode head = queue.remove();
        int nextIndex = getNextIndex(treeSerial, prevIndex);
        String val = getValue(treeSerial, nextIndex);
        if (val != "null") {
            head.left = new TreeNode(Integer.parseInt(val));
            queue.add(head.left);
        }

        nextIndex = getNextIndex(treeSerial, nextIndex);
        val = getValue(treeSerial, nextIndex);
        if (val != "null") {
            head.right = new TreeNode(Integer.parseInt(val));
            queue.add(head.right);
        }
        treeNodeDeserialize(treeSerial, queue, nextIndex);
    }

    protected int getNextIndex(String treeSerial, int currentIndex) {
        int invalidIndex = -1;
        if (currentIndex >= treeSerial.length())
            return invalidIndex;
        for (int i = currentIndex + 1; i < treeSerial.length(); i++) {
            char c = treeSerial.charAt(i);
            if ( Character.isDigit(c) && !Character.isDigit(treeSerial.charAt(i - 1)) ) {
                return i;
            } else if ( c == 'n') {
                char prevC = treeSerial.charAt(i - 1);
                if (prevC == ' ' || prevC == ',')
                    return i;
            }
        }
        return invalidIndex;
    }

    protected String getValue(String treeSerial, int index) {
        StringBuilder sb = new StringBuilder();
        for (int i = index; i < treeSerial.length(); i++) {
            char c = treeSerial.charAt(i);
            if (c != 'n' && c != 'u' && c != 'l' && !Character.isDigit(c))
                return sb.toString();
            sb.append(c);
        }
        return null;
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
