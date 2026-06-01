package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC0362DesignHitCounter {
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */

class LC0362HitCounter {

  private final List<Integer> hitHistory;

  public LC0362HitCounter() {
    this.hitHistory = new ArrayList<>();
  }

  public void hit(int timestamp) {
    hitHistory.add(timestamp);
  }

  public int getHits(int timestamp) {
    int fiveMinutesAgo = Math.max(0, timestamp - 300);
    return getTotalHits(timestamp) - getTotalHits(fiveMinutesAgo);
  }

  private int getTotalHits(int timestamp) {
    int totalHits = hitHistory.size();
    if (hitHistory.isEmpty() || timestamp < hitHistory.get(0)) {
      return 0;
    } else if (hitHistory.get(totalHits - 1) <= timestamp) {
      return totalHits;
    }
    int start = 0;
    int end = totalHits;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (hitHistory.get(mid) <= timestamp) {
        start = mid;
      } else if (hitHistory.get(mid) > timestamp) {
        end = mid;
      }
    }
    return start + 1;
  }
}
