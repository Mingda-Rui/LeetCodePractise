package pers.mingda.leetcode;

public class LC4026MaximumGapBetweenStations {}

class LC4026Solution {
  public int maximumGap(String skill, String station) {
    int[] earliest = new int[skill.length()];
    int[] latest = new int[skill.length()];

    int earliestIndex = 0;
    for (int i = 0; i < station.length(); i++) {
      if (earliestIndex < skill.length() && station.charAt(i) == skill.charAt(earliestIndex)) {
        earliest[earliestIndex] = i;
        earliestIndex++;
      }
    }

    int latestIndex = skill.length() - 1;
    for (int j = station.length() - 1; j >= 0; j--) {
      if (latestIndex >= 0 && station.charAt(j) == skill.charAt(latestIndex)) {
        latest[latestIndex] = j;
        latestIndex--;
      }
    }

    int result = 0;
    for (int i = 0; i < earliest.length - 1; i++) {
      int gap = latest[i + 1] - earliest[i];
      result = Math.max(result, gap);
    }
    return result;
  }
}
