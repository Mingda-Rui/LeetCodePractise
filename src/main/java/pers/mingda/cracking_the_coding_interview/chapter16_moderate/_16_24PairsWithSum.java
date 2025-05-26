package pers.mingda.cracking_the_coding_interview.chapter16_moderate;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class _16_24PairsWithSum {

  List<PairWithSum> printPariSums(int[] array, int sum) {
    Multimap<Integer, Integer> valueToIndex = ArrayListMultimap.create();
    for (int i = 0; i < array.length; i++) {
      valueToIndex.put(array[i], i);
    }
    Set<PairWithSum> pairs = new HashSet<>();
    for (int i = 0; i < array.length; i++) {
      int target = sum - array[i];
      if (valueToIndex.containsKey(target)) {
        for (int index : valueToIndex.values()) {
          if (index != i) {
            pairs.add(new PairWithSum(i, index));
          }
        }
      }
    }

    return pairs.stream().toList();
  }
}

class PairWithSum {

  int left, right;

  public PairWithSum(int left, int right) {
    this.left = Math.min(left, right);
    this.right = Math.max(left, right);
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof PairWithSum other) {
      return this.left == other.left && this.right == other.right;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(left, right);
  }
}
