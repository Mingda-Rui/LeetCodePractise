package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LC0116PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if (root == null)
            return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.remove();
                if (i == size - 1)
                    node.next = null;
                else
                    node.next = queue.element();
                if (node.right != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    public Node connectIterativeNoStack(Node root) {
        if (root == null)
            return root;
        Node ite = root;
        Node nextLevel = ite.left;
        while (ite != null) {
            if (ite.left != null) {
                ite.left.next = ite.right;
                if (ite.next != null)
                    ite.right.next = ite.next.left;
            }

            ite = ite.next;
            if (ite == null && nextLevel != null) {
                ite = nextLevel;
                nextLevel = ite.left;
            }
        }
        return root;
    }

    public Node connectRecursive(Node root) {
        if (root == null || root.left == null)
            return root;
        root.left.next = root.right;
        if (root.next != null)
            root.right.next = root.next.left;
        connectRecursive(root.left);
        connectRecursive(root.right);
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
