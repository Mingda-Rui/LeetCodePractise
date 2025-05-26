package pers.mingda.leetcode;

public class LC0860LemonadeChange {
  public boolean lemonadeChange(int[] bills) {
    int[] change = new int[21];
    for (int bill : bills) {
      if (!changeBill(change, bill)) {
        return false;
      }
      change[bill]++;
    }
    return true;
  }

  private boolean changeBill(int[] change, int bill) {
    if (bill == 5) {
      return true;
    } else if (bill == 10 && change[5] > 0) {
      change[5]--;
      return true;
    } else if (change[10] > 0 && change[5] > 0) {
      change[10]--;
      change[5]--;
      return true;
    } else if (change[5] >= 3) {
      change[5] -= 3;
      return true;
    }
    return false;
  }
}
