package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LC0590NAryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new LinkedList<>();
        if (root == null)
            return result;

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            List<Node> children = current.children;
            if (children != null) {
                stack.push(current);
                for (int i = children.size() - 1; i >= 0; i--)
                    stack.push(children.get(i));
                current.children = null;
            } else
                result.add(current.val);
        }
        return result;
    }
}
