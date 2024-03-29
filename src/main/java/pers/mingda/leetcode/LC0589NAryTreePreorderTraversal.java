package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LC0589NAryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new LinkedList<>();
        if (root == null)
            return result;

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            result.add(current.val);

            List<Node> children = current.children;
            for (int i = children.size() - 1; i >= 0; i--)
                stack.push(children.get(i));

        }
        return result;
    }

    public List<Integer> preorderRecursive(Node root) {
        List<Integer> result = new LinkedList<>();
        return preorderRecursive(root, result);
    }

    private List<Integer> preorderRecursive(Node root, List<Integer> result) {
        if (root == null)
            return result;
        result.add(root.val);

        for (Node child: root.children)
            preorderRecursive(child, result);
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
