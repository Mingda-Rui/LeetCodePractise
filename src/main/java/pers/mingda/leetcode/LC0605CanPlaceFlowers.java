package pers.mingda.leetcode;

public class LC0605CanPlaceFlowers {
  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    for (int i = 0; i < flowerbed.length; i++) {
      if (n == 0) return true;
      if (flowerbed[i] == 1) continue;
      boolean leftEmpty = i == 0 || flowerbed[i - 1] == 0;
      boolean rightEmpty = i == flowerbed.length - 1 || flowerbed[i + 1] == 0;
      if (leftEmpty && rightEmpty) {
        flowerbed[i] = 1;
        n--;
      }
    }
    return n == 0;
  }
}
