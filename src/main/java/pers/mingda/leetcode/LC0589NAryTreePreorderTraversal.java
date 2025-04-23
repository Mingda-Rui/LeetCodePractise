package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LC0589NAryTreePreorderTraversal {
    public List<Integer> preorder(LC0589Node root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;

        Stack<LC0589Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            LC0589Node current = stack.pop();
            result.add(current.val);

            List<LC0589Node> children = current.children;
            for (int i = children.size() - 1; i >= 0; i--) stack.push(children.get(i));
        }
        return result;
    }

    public List<Integer> preorderRecursive(LC0589Node root) {
        List<Integer> result = new LinkedList<>();
        return preorderRecursive(root, result);
    }

    private List<Integer> preorderRecursive(LC0589Node root, List<Integer> result) {
        if (root == null) return result;
        result.add(root.val);

        for (LC0589Node child : root.children) preorderRecursive(child, result);
        return result;
    }
}

class LC0589Node {
    public int val;
    public List<LC0589Node> children;

    public LC0589Node() {}

    public LC0589Node(int _val) {
        val = _val;
    }

    public LC0589Node(int _val, List<LC0589Node> _children) {
        val = _val;
        children = _children;
    }
}
