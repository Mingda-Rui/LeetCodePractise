package pers.mingda.leetcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LC0987VerticalOrderTraversalOfABinaryTree {}

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode() {} TreeNode(int val) { this.val = val; } TreeNode(int val, TreeNode left,
 * TreeNode right) { this.val = val; this.left = left; this.right = right; } }
 */
class LC0987Solution {

  public List<List<Integer>> verticalTraversal(TreeNode root) {
    List<Coord> list = new LinkedList<>();
    generateCoord(root, 0, 0, list);
    Comparator<Coord> comparator = createCoordComparator();
    list.sort(comparator);

    List<List<Integer>> result = new LinkedList<>();

    int prevColumnVal = 1;
    List<Integer> currentColumn = null;
    for (Coord coord : list) {
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
      if (node1.y != node2.y) return node1.y - node2.y;
      else if (node1.x != node2.x) return node1.x - node2.x;
      else return node1.val - node2.val;
    };
  }

  private void generateCoord(TreeNode root, int x, int y, List<Coord> list) {
    Coord coord = new Coord(x, y, root.val);
    list.add(coord);
    if (root.left != null) generateCoord(root.left, x + 1, y - 1, list);
    if (root.right != null) generateCoord(root.right, x + 1, y + 1, list);
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

class IterateByLaySolution {

  public List<List<Integer>> verticalTraversal(TreeNode root) {
    List<List<Integer>> result = new LinkedList<>();
    Queue<CoordNode> queue = new LinkedList<>();
    CoordNode coordRoot = new CoordNode(0, 0, root);
    queue.offer(coordRoot);
    Map<Integer, List<Integer>> map = new HashMap<>();
    int leftMostColumn = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      Map<Integer, List<Integer>> layerMap = new HashMap<>();
      for (int i = 0; i < size; i++) {
        CoordNode coordNode = queue.poll();
        int x = coordNode.x;
        int y = coordNode.y;
        TreeNode node = coordNode.node;
        layerMap.putIfAbsent(y, new LinkedList<>());
        layerMap.get(y).add(node.val);
        if (node.left != null) {
          CoordNode left = new CoordNode(x + 1, y - 1, node.left);
          queue.offer(left);
        }

        if (node.right != null) {
          CoordNode right = new CoordNode(x + 1, y + 1, node.right);
          queue.offer(right);
        }

        leftMostColumn = Math.min(leftMostColumn, y);
      }
      for (int y : layerMap.keySet()) {
        List<Integer> list = layerMap.get(y);
        Collections.sort(list);
        map.putIfAbsent(y, new LinkedList<>());
        map.get(y).addAll(list);
      }
    }

    int pointer = leftMostColumn;
    while (map.containsKey(pointer)) {
      List<Integer> column = map.get(pointer);
      result.add(column);
      pointer++;
    }

    return result;
  }
}

class CoordNode {

  int x;
  int y;
  TreeNode node;

  public CoordNode(int x, int y, TreeNode node) {
    this.x = x;
    this.y = y;
    this.node = node;
  }
}
