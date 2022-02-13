package pers.mingda.crackingcodinginterview.chapter4treesandgraphs;

public class TreeNode {
    public int data;
    public TreeNode left, right, parent;
    private int size = 0;

    public TreeNode(int d) {
        data = d;
        size = 1;
    }

    public void insertInOrder(int d) {

    }

    public int size() {
        return 0;
    }

    public TreeNode find(int d) {
        return null;
    }

    public void setLeftChild(TreeNode left) {
        this.left = left;
    }

    public void setRightChild(TreeNode right) {
        this.right = right;
    }
}
