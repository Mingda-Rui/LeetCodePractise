package pers.mingda.crackingcodinginterview.chapter4treesandgraphs;

/**
 *  4.12 Paths with Sum: You are given a binary tree in which each node contains an integer value (which
 *  might be positive or negative). Design an algorithm to count the number of paths that sum to a
 *  given value. The path does not need to start or end at the root or a leaf, but it must go downwards
 *  (traveling only from parent nodes to child nodes).
 */

public class _4_12PathsWithSum {
    public static int countPathsWithSum(TreeNode node, int targetSum) {
        if (node == null)
            return 0;

        int counter = countPathsWithRemainSum(node, targetSum);
        counter += countPathsWithSum(node.left, targetSum);
        counter += countPathsWithSum(node.right, targetSum);
        return counter;
    }

    private static int countPathsWithRemainSum(TreeNode node, int remainSum) {
        if (node == null)
            return 0;
        int counter = 0;
        if (node.data == remainSum)
            counter++;
        counter += countPathsWithRemainSum(node.left, remainSum - node.data);
        counter += countPathsWithRemainSum(node.right, remainSum - node.data);
        return counter;
    }
}
