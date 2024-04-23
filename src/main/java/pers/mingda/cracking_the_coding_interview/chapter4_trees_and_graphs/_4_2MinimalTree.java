package pers.mingda.cracking_the_coding_interview.chapter4_trees_and_graphs;

/**
 *  4.2 Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an
 *  algorithm to create a binary search tree with minimal height.
 */

public class _4_2MinimalTree {
    public static TreeNode createMinimalBST(int[] array) {
        if (array.length == 0)
            return null;
        return createMinimalBST(array, 0, array.length);
    }

    // start is inclusive
    // end is exclusive
    private static TreeNode createMinimalBST(int[] array, int start, int end) {
        if (start == end)
            return null;

        int midIndex = getMidIndex(start, end);
        TreeNode mid = new TreeNode(array[midIndex]);
        mid.left = createMinimalBST(array, start, midIndex);
        mid.right = createMinimalBST(array, midIndex + 1, end);
        return mid;
    }

    private static int getMidIndex(int start, int end) {
        return (start + end) / 2;
    }

    public static TreeNode createMinimalBstInsertNode(int[] array) {
        if (array == null || array.length == 0)
            return null;
        int midIndex = getMidIndex(0, array.length);
        TreeNode root = new TreeNode(array[midIndex]);
        createMinimalBstInsertNode(root, array, 0, midIndex);
        createMinimalBstInsertNode(root, array, midIndex + 1, array.length);
        return root;
    }

    private static TreeNode createMinimalBstInsertNode(TreeNode root, int[] array, int start, int end) {
        if (start >= end)
            return root;

        int midIndex = getMidIndex(start, end);
        root.insertInOrder(array[midIndex]);
        createMinimalBstInsertNode(root, array, start, midIndex);
        createMinimalBstInsertNode(root, array, midIndex + 1, end);
        return root;
    }
}
