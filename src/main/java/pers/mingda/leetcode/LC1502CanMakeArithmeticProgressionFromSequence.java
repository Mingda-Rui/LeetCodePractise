package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC1502CanMakeArithmeticProgressionFromSequence {
}

class LC1502SortingSolution {
  public boolean canMakeArithmeticProgression(int[] arr) {
    Arrays.sort(arr);
    for (int i = 1; i + 1 < arr.length; i++) {
      if (arr[i] - arr[i - 1] != arr[i + 1] - arr[i]) {
        return false;
      }
    }
    return true;
  }
}

class LC1502SetSolution {
  public boolean canMakeArithmeticProgression(int[] arr) {
    Set<Integer> set = new HashSet<>();

    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    for (int num : arr) {
      set.add(num);

      min = Math.min(min, num);
      max = Math.max(max, num);
    }
    if (set.size() == 1) {
      return true;
    }
    if (set.size() != arr.length) {
      return false;
    }

    if ((max - min) % (arr.length - 1) != 0) {
      return false;
    }
    int diff = (max - min) / (arr.length - 1);
    for (int num : arr) {
      if ((num - min) % diff != 0) {
        return false;
      }
    }
    return true;
  }
}

class LC1502InPlaceSolution {
  public boolean canMakeArithmeticProgression(int[] arr) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    for (int num : arr) {
      min = Math.min(min, num);
      max = Math.max(max, num);
    }
    if (min == max) {
      return true;
    }

    if ((max - min) % (arr.length - 1) != 0) {
      return false;
    }
    int diff = (max - min) / (arr.length - 1);
    int i = 0;
    while (i < arr.length) {
      int correctIndex = getIndex(arr[i], min, diff);
      if (i == correctIndex) {
        i++;
        continue;
      }

      if (correctIndex < 0 || arr[i] == arr[correctIndex]) {
        return false;
      }

      int temp = arr[i];
      arr[i] = arr[correctIndex];
      arr[correctIndex] = temp;
    }
    return true;
  }

  private int getIndex(int num, int min, int diff) {
    if ((num - min) % diff != 0) {
      return -1;
    }
    return (num - min) / diff;
  }
}