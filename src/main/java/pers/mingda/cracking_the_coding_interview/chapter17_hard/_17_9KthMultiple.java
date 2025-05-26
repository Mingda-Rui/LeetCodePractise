package pers.mingda.cracking_the_coding_interview.chapter17_hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _17_9KthMultiple {

  int getKthMagicNumber(int k) {
    List<Integer> nums = new ArrayList<>();
    int factorOfThrees = 0;
    int factorOfFives = 0;
    int factorOfSevens = 0;
    nums.add(3);
    nums.add(5);
    nums.add(7);
    while (nums.size() < k) {
      int nextThree = nums.get(factorOfThrees) * 3;
      int nextFive = nums.get(factorOfFives) * 5;
      int nextSeven = nums.get(factorOfSevens) * 7;
      if (nextThree <= nextFive && nextThree <= nextSeven) {
        factorOfThrees++;
        if (nums.getLast() != nextThree) {
          nums.add(nextThree);
        }
      } else if (nextFive <= nextSeven && nextFive <= nextThree) {
        factorOfFives++;
        if (nums.getLast() != nextFive) {
          nums.add(nextFive);
        }
      } else {
        factorOfSevens++;
        if (nums.getLast() != nextSeven) {
          nums.add(nextSeven);
        }
      }
    }
    return nums.get(k - 1);
  }

  int getKthMagicNumberAlternativeSolution(int k) {
    if (k < 0) {
      return 0;
    }
    int val = 0;
    Queue<Integer> queue3 = new LinkedList<>();
    Queue<Integer> queue5 = new LinkedList<>();
    Queue<Integer> queue7 = new LinkedList<>();
    queue3.add(1);

    /* Include 0th through kth iteration */
    for (int i = 0; i <= k; i++) {
      int v3 = queue3.isEmpty() ? Integer.MAX_VALUE : queue3.peek();
      int v5 = queue5.isEmpty() ? Integer.MAX_VALUE : queue5.peek();
      int v7 = queue7.isEmpty() ? Integer.MAX_VALUE : queue7.peek();
      val = Math.min(v3, Math.min(v5, v7));
      if (val == 3) { // enqueue into queue 3, 5, and 7
        queue3.remove();
        queue3.add(3 * val);
        queue5.add(5 * val);
        queue7.add(7 * val);
      } else if (val == 5) { // enqueue into queue 5 and 7
        queue5.remove();
        queue5.add(5 * val);
        queue7.add(7 * val);
      } else if (val == 7) { // enqueue into Q7
        queue7.remove();
        queue7.add(7 * val);
      }
    }
    return val;
  }
}
