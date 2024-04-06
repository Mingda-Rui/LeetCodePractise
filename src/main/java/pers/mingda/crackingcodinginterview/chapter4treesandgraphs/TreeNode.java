package pers.mingda.crackingcodinginterview.chapter4treesandgraphs;

import java.util.Random;

public class TreeNode {
    public int data;
    public TreeNode left, right, parent;
    private int size;
    private static final Random randomGenerator = new Random();

    public TreeNode(int d) {
        data = d;
        size = 1;
    }

    public void insertInOrder(int d) {
        size++;
        TreeNode nextNode = d > data ? right : left;
        if (nextNode != null)
            nextNode.insertInOrder(d);
        else if (d > data)
            right = new TreeNode(d);
        else
            // d <= data
            left = new TreeNode(d);
    }

    public int size() {
        return size;
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

    public TreeNode getRandomNode() {
        int randInt = randomGenerator.nextInt(0, size);
        return getNth(randInt);
    }

    public TreeNode getNth(int num) {
        if ((left == null && num == 0) || (getLeftSize() == num)) {
            return this;
        } else if (left != null && left.size > num) { // or getLeftSide() > num
            return left.getNth(num);
        } else if (right != null && size - getRightSize() <= num ) {
            return right.getNth(num - getLeftSize() - 1);
        } else {
            throw new IllegalStateException();
        }
    }

    private int getLeftSize() {
        return left == null ? 0 : left.size;
    }

    private int getRightSize() {
        return right == null ? 0 : right.size;
    }
}
