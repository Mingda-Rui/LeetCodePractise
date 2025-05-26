package pers.mingda.cracking_the_coding_interview.chapter16_moderate;

import java.util.HashSet;
import java.util.Set;

public class _16_11DivingBoard {
  Set<Integer> allLengths(int k, int shorter, int longer) {
    if (k == 0) {
      return new HashSet<>();
    }

    if (k == 1) {
      Set<Integer> set = new HashSet<>();
      set.add(shorter);
      set.add(longer);
      return set;
    }

    Set<Integer> set = new HashSet<>();
    for (int len : allLengths(k - 1, shorter, longer)) {
      set.add(len + shorter);
      set.add(len + longer);
    }
    return set;
  }

  Set<Integer> allLengthsOptimized(int k, int shorter, int longer) {
    Set<Integer> lengths = new HashSet<>();
    for (int i = 0; i <= k; i++) {
      lengths.add(shorter * i + (k - i) * longer);
    }
    return lengths;
  }
}
