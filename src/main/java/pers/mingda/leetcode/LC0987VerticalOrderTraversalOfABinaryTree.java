package pers.mingda.leetcode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class LC0987VerticalOrderTraversalOfABinaryTree {

}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Coord> list = new LinkedList<>();
        generateCoord(root, 0, 0, list);
        Comparator<Coord> comparator = createCoordComparator();
        list.sort(comparator);

        List<List<Integer>> result = new LinkedList<>();

        int prevColumnVal = 1;
        List<Integer> currentColumn = null;
        for (Coord coord: list) {
            if (coord.y != prevColumnVal) {
                currentColumn = new LinkedList<>();
                result.add(currentColumn);
                prevColumnVal = coord.y;
            }
            currentColumn.add(coord.val);
        }

        return result;
    }

    private Comparator<Coord> createCoordComparator() {
        return (node1, node2) -> {
            if (node1.y != node2.y)
                return node1.y - node2.y;
            else if (node1.x != node2.x)
                return node1.x - node2.x;
            else
                return node1.val - node2.val;
        };
    }

    private void generateCoord(TreeNode root, int x, int y, List<Coord> list) {
        Coord coord = new Coord(x, y, root.val);
        list.add(coord);
        if (root.left != null)
            generateCoord(root.left, x + 1, y - 1, list);
        if (root.right != null)
            generateCoord(root.right, x + 1, y + 1, list);
    }
}

class Coord {
    int x;
    int y;
    int val;

    public Coord(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
