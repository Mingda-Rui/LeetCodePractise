package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LC0742ClosestLeafInABinaryTree {

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
    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, NodeCloestLeaf> closestLeafMap = new HashMap<>();
        recordShortestDistanceToLeaf(root, closestLeafMap);

        Stack<TreeNode> stack = new Stack<>();
        fillOutStack(root, stack, k);

        TreeNode kNode = stack.pop();
        int size = stack.size();
        int cloest = closestLeafMap.get(kNode).distance;
        TreeNode leafNode = closestLeafMap.get(kNode).cloestLeafNode;
        while (!stack.isEmpty()) {
            int distance = size - stack.size();
            TreeNode node = stack.pop();
            NodeCloestLeaf currentCloest = closestLeafMap.get(node);
            if ((currentCloest.distance + distance) < cloest) {
                cloest = currentCloest.distance + distance;
                leafNode = currentCloest.cloestLeafNode;
            }
            cloest = Math.min(cloest, currentCloest.distance + distance);
        }
        return leafNode.val;
    }

    private NodeCloestLeaf recordShortestDistanceToLeaf(TreeNode root, Map<TreeNode, NodeCloestLeaf> map) {
        // 1. get the closest leaf to the current node
        // 2. build up this cloestlesgMsp ?
        // 3. fill up stack
        if (root == null)
            return null;

        NodeCloestLeaf left = recordShortestDistanceToLeaf(root.left, map);
        NodeCloestLeaf right = recordShortestDistanceToLeaf(root.right, map);

        NodeCloestLeaf shortestPath;
        if (left == null && right == null)
            shortestPath = new NodeCloestLeaf(root, root, 0);
        else if (left != null && right != null) {
            if (left.distance < right.distance) {
                shortestPath = new NodeCloestLeaf(root, map.get(root.left).cloestLeafNode, left.distance + 1);
            } else {
                shortestPath = new NodeCloestLeaf(root, map.get(root.right).cloestLeafNode, right.distance + 1);
            }
        } else if (left != null) {
            shortestPath = new NodeCloestLeaf(root, map.get(root.left).cloestLeafNode, left.distance + 1);
        } else {
            shortestPath = new NodeCloestLeaf(root, map.get(root.right).cloestLeafNode, right.distance + 1);
        }

        map.put(root, shortestPath);
        return shortestPath;
    }

    private boolean fillOutStack(TreeNode root, Stack<TreeNode> stack, int k) {
        if (root == null)
            return false;
        stack.push(root);
        if (root.val == k)
            return true;
        if (fillOutStack(root.left, stack, k) || fillOutStack(root.right, stack, k))
            return true;
        stack.pop();
        return false;
    }
}

class NodeCloestLeaf {
    TreeNode node;
    TreeNode cloestLeafNode;
    int distance;
    public NodeCloestLeaf(TreeNode node, TreeNode cloestLeafNode, int distance) {
        this.node = node;
        this.cloestLeafNode = cloestLeafNode;
        this.distance = distance;
    }
}