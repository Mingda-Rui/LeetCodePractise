package pers.mingda.crackingcodinginterview.chapter4treesandgraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 *  4.3 List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
 *  at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
 */

public class _4_3ListOfDepths {

    public static List<List<TreeNode>> createLevelLinkedList(TreeNode root) {
        List<List<TreeNode>> result = new ArrayList<>();
        if (root == null)
            return result;

        List<TreeNode> currentList = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int currentLevelSize = queue.size();
        int nextLevelSize = 0;

        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();
            currentList.add(current);
            currentLevelSize--;
            if (current.left != null) {
                queue.add(current.left);
                nextLevelSize++;
            }
            if (current.right != null) {
                queue.add(current.right);
                nextLevelSize++;
            }

            if (currentLevelSize == 0) {
                currentLevelSize = nextLevelSize;
                nextLevelSize = 0;
                result.add(currentList);
                currentList = new LinkedList<>();
            }
        }

        return result;
    }
}
