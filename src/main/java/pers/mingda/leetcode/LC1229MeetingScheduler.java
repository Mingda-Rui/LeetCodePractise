package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LC1229MeetingScheduler {
}

class LC1229TwoPointersSolution {
  public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
    Comparator<int[]> slotComparator = Comparator.comparingInt(a -> a[0]);
    Arrays.sort(slots1, slotComparator);
    Arrays.sort(slots2, slotComparator);
    int index1 = 0;
    int index2 = 0;

    while (index1 < slots1.length && index2 < slots2.length) {
      int[] slot1 = slots1[index1];
      int[] slot2 = slots2[index2];
      // if intersect && greater or equal to duration
      if (isIntersect(slot1, slot2)) {
        int start = Math.max(slot1[0], slot2[0]);
        int end = Math.min(slot1[1], slot2[1]);
        if (end - start >= duration) {
          return List.of(start, start + duration);
        }
      }
      // make progress on one index with eariler end time
      if (slot1[1] < slot2[1]) {
        index1++;
      } else {
        index2++;
      }
    }
    return List.of();
  }

  private boolean isIntersect(int[] slot1, int[] slot2) {
    return slot1[0] < slot2[1] && slot2[0] < slot1[1];
  }
}