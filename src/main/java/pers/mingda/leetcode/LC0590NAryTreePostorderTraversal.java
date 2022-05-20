package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LC0590NAryTreePostorderTraversal {
    public List<Integer> postorderIterative(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null)
            return result;

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            result.addFirst(current.val);
            for (Node child: current.children)
                stack.push(child);
        }
        return result;
    }

    public List<Integer> postorderRecursive(Node root) {
        List<Integer> result = new LinkedList<>();
        return postorderRecursive(root, result);
    }

    private List<Integer> postorderRecursive(Node root, List<Integer> result) {
        if (root == null)
            return result;

        for (Node child: root.children)
            postorderRecursive(child, result);
        result.add(root.val);
        return result;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
