package pers.mingda.cracking_the_coding_interview.chapter4_trees_and_graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *  4.9 BST Sequences: A binary search tree was created by traversing through an array from left to right
 *  and inserting each element. Given a binary search tree with distinct elements, print all possible
 *  arrays that could have led to this tree.
 *  EXAMPLE
 *  Input:
 *    2
 *   / \
 *  1   3
 *  Output: {2, 1, 3}, {2, 3, 1}
 */

public class _4_9BstSequences {

    public static List<List<Integer>> allSequences(TreeNode node) {
        Set<TreeNode> activeNodes = new HashSet<>();
        activeNodes.add(node);
        List<List<Integer>> result = new LinkedList<>();
        allSequences(activeNodes, result, new LinkedList<>());
        return result;
    }

    private static List<List<Integer>> allSequences(Set<TreeNode> activeNodes, List<List<Integer>> result, List<Integer> current) {
        if (activeNodes.isEmpty()) {
            List<Integer> currentList = List.copyOf(current);
            result.add(currentList);
            return result;
        }
        List<TreeNode> copyOfActive = List.copyOf(activeNodes);
        for (TreeNode next: copyOfActive) {
            current.add(next.data);
            activeNodes.remove(next);

            Set<TreeNode> withChildNodes = addChildNode(activeNodes, next);
            allSequences(withChildNodes, result, current);
            activeNodes.add(next);
            current.remove(current.size() - 1);
        }
        return result;
    }

    private static Set<TreeNode> addChildNode(Set<TreeNode> activeNodes, TreeNode node) {
        Set<TreeNode> withChildNodes = new HashSet<>(activeNodes);
        if (node == null)
            return withChildNodes;
        if (node.left != null)
            withChildNodes.add(node.left);
        if (node.right != null)
            withChildNodes.add(node.right);
        return withChildNodes;
    }
}
