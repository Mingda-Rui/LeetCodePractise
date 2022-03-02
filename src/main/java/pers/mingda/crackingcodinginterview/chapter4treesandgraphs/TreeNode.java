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
        TreeNode nextNode = d > data ? right : left;
        if (nextNode != null)
            nextNode.insertInOrder(d);
        else if (d > data)
            right = new TreeNode(d);
        else if (d <= data)
            left = new TreeNode(d);
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
