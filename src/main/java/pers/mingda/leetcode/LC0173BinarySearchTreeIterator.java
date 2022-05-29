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
    private TreeNode root;
    public BSTIteratorSmallInit(TreeNode root) {
        this.stack = new Stack<>();
        this.root = root;
    }

    public int next() {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        TreeNode next = stack.pop();
        root = next.right;
        return next.val;
    }

    public boolean hasNext() {
        return root != null || !stack.isEmpty();
    }
}
