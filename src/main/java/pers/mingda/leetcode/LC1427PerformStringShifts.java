package pers.mingda.leetcode;

public class LC1427PerformStringShifts {}

class LC1427Solution {

  public String stringShift(String s, int[][] shift) {
    int combinedShift = calculateShifts(shift);
    return shift(s, Math.floorMod(combinedShift, s.length()));
  }

  private int calculateShifts(int[][] shift) {
    int combinedShift = 0;
    for (int[] shiftCommand : shift) {
      int direction = shiftCommand[0] == 0 ? 1 : -1;
      int amount = shiftCommand[1];
      combinedShift += (direction * amount);
    }

    return combinedShift;
  }

  private String shift(String s, int shiftAmount) {
    if (s == null || s.isEmpty() || shiftAmount == 0) {
      return s;
    }
    return s.substring(shiftAmount) + s.substring(0, shiftAmount);
  }
}
