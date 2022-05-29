package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC0173BinarySearchTreeIterator {

}

class BSTIterator {
    List<TreeNode> list;
    int pointer;
    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        pointer = -1;
        constructList(root, list);
    }

    public int next() {
        pointer++;
        return list.get(pointer).val;
    }

    public boolean hasNext() {
        return pointer < list.size() - 1;
    }

    private void constructList(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            constructList(root.left, list);
            list.add(root);
            constructList(root.right, list);
        }
    }
}

class BSTIteratorSmallInit {
    private Stack<TreeNode> stack;
    public BSTIteratorSmallInit(TreeNode root) {
        this.stack = new Stack<>();
        pushAllLeft(root);
    }

    public int next() {
        TreeNode next = stack.pop();
        pushAllLeft(next.right);
        return next.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAllLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
