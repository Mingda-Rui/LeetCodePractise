package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC0973KClosestPointsToOrigin {

  public int[][] kClosest(int[][] points, int k) {
    Comparator<List<Integer>> comparator = (o1, o2) -> {
      int distance1 = o1.get(0) * o1.get(0) + o1.get(1) * o1.get(1);
      int distance2 = o2.get(0) * o2.get(0) + o2.get(1) * o2.get(1);
      return distance2 - distance1;
    };

    Queue<List<Integer>> queue = new PriorityQueue<>(k + 1, comparator);
    for (int[] point : points) {
      List<Integer> node = new ArrayList<>(2);
      node.add(point[0]);
      node.add(point[1]);
      queue.add(node);
      if (queue.size() > k) queue.remove();
    }

    int[][] result = new int[queue.size()][2];
    while (!queue.isEmpty()) {
      int index = queue.size() - 1;
      List<Integer> node = queue.remove();
      result[index][0] = node.get(0);
      result[index][1] = node.get(1);
    }
    return result;
  }
}
