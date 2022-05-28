package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.List;

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