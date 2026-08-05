package pers.mingda.leetcode;

public class LC4011CountSubarraysWithEvenOddRatioI {}

class LC4011Solution {
  public int countRatioSubarrays(int[] nums, int a, int b) {
    int len = nums.length;

    int[] leftToRightEven = new int[len];
    int[] rightToLeftEven = new int[len];

    for (int i = 0; i < len; i++) {
      int num = nums[i];
      boolean isEven = isEven(num);
      leftToRightEven[i] = (i - 1 >= 0 ? leftToRightEven[i - 1] : 0) + (isEven ? 1 : 0);
    }

    for (int i = len - 1; i >= 0; i--) {
      int num = nums[i];
      boolean isEven = num % 2 == 0;
      rightToLeftEven[i] = (i + 1 < len ? rightToLeftEven[i + 1] : 0) + (isEven ? 1 : 0);
    }

    int totalEven = rightToLeftEven[0];
    int totalOdd = len - totalEven;

    int count = 0;
    for (int i = 0; i < len; i++) {
      for (int j = i; j < len; j++) {
        int leftSideEven = i - 1 >= 0 ? leftToRightEven[i - 1] : 0;
        int rightSideEven = j + 1 < len ? rightToLeftEven[j + 1] : 0;

        int evenCount = totalEven - leftSideEven - rightSideEven;
        int oddCount = j - i + 1 - evenCount;
        if (oddCount > 0 && (evenCount * b <= oddCount * a)) {
          count++;
        }
      }
    }
    return count;
  }

  private boolean isEven(int num) {
    return num % 2 == 0;
  }
}
