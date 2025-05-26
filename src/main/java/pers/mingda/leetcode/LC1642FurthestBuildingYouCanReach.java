package pers.mingda.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class LC1642FurthestBuildingYouCanReach {}

class LC1642Solution {
  public int furthestBuilding(int[] heights, int bricks, int ladders) {
    Queue<Integer> ladderUsed = new PriorityQueue<>();
    for (int i = 0; i < heights.length - 1; i++) {
      int current = heights[i];
      int next = heights[i + 1];
      int heightDiff = next - current;
      if (heightDiff <= 0) {
        continue;
      }

      if (ladderUsed.size() < ladders) {
        ladderUsed.add(heightDiff);
        continue;
      }

      boolean shouldUseLadder =
          ladders != 0 && !ladderUsed.isEmpty() && ladderUsed.peek() < heightDiff;
      if (shouldUseLadder) {
        ladderUsed.add(heightDiff);
      }
      int bricksNeeded = shouldUseLadder ? ladderUsed.remove() : heightDiff;

      bricks -= bricksNeeded;
      if (bricks < 0) {
        return i;
      }
    }
    return heights.length - 1;
  }
}
