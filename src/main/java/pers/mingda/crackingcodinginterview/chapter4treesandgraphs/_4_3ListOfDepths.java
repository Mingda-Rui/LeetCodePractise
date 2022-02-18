package pers.mingda.crackingcodinginterview.chapter4treesandgraphs;

import java.util.LinkedList;
import java.util.List;


/**
 *  4.3 List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
 *  at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
 */

public class _4_3ListOfDepths {

    public static List<List<TreeNode>> createLevelLinkedList(TreeNode root) {
        List<List<TreeNode>> result = new LinkedList<>();
        if (root == null)
            return result;

        List<TreeNode> current = new LinkedList<>();
        current.add(root);
        while (!current.isEmpty()) {
            List<TreeNode> previous = current;
            current = new LinkedList<>();
            result.add(previous);
            for (TreeNode node: previous) {
                if (node.left != null)
                    current.add(node.left);
                if (node.right != null)
                    current.add(node.right);
            }
        }
        return result;
    }
}
