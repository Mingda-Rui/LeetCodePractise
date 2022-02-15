package pers.mingda.crackingcodinginterview.chapter4treesandgraphs;

/**
 *  4.2 Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an
 *  algorithm to create a binary search tree with minimal height.
 */

public class _4_2MinimalTree {
    public static TreeNode createMinimalBST(int array[]) {
        if (array.length == 0)
            return null;
        return createMinimalBST(array, 0, array.length);
    }

    // start is inclusive
    // end is exclusive
    private static TreeNode createMinimalBST(int array[], int start, int end) {
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
}
