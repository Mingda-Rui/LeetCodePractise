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
        if (nextNode != null) {
            nextNode.insertInOrder(d);
        } else if (d > data) {
            right = new TreeNode(d);
            right.parent = this;
        } else {
            // d <= data
            left = new TreeNode(d);
            left.parent = this;
        }
    }

    public int size() {
        return size;
    }

    public TreeNode find(int data) {
        if (this.data == data) {
            return this;
        } else if (this.data < data && this.right != null) {
            return right.find(data);
        } else if (this.data > data && this.left != null) {
            return left.find(data);
        }
        return null;
    }

    public void setLeftChild(TreeNode left) {
        if (left != null) {
            size += left.size;
        }
        this.left = left;
    }

    public void setRightChild(TreeNode right) {
        if (right != null) {
            size += right.size;
        }
        this.right = right;
    }

    public void delete(int num) {
        if (left != null && getLeftSize() == num + 1) {
            reduceSize(left.size);
            left = null;
        } else if (left != null && getLeftSize() > num + 1) {
            left.delete(num);
        } else if (right != null && getLeftSize() + 1 == num) {
            reduceSize(right.size);
            right = null;
        } else if (right != null && getLeftSize() + 1 < num) {
            right.delete(num);
        } else {
            throw new IllegalArgumentException();
        }
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

    private void reduceSize(int size) {
        if (this.size <= size) {
            throw new IllegalArgumentException("The size of tree node can not be less than or equal to 0");
        }
        this.size -= size;
        if (parent != null) {
            parent.reduceSize(size);
        }
    }

    private int getLeftSize() {
        return left == null ? 0 : left.size;
    }

    private int getRightSize() {
        return right == null ? 0 : right.size;
    }
}
