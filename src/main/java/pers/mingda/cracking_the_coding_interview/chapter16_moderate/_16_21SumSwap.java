package pers.mingda.cracking_the_coding_interview.chapter16_moderate;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class _16_21SumSwap {

  int[] findSwapValues(int[] array1, int[] array2) {
    Optional<Integer> maybeTarget = getTargetDiff(array1, array2);
    if (maybeTarget.isEmpty()) {
      return null;
    }

    int target = maybeTarget.get();
    Set<Integer> set2 = buildSet(array2);
    for (int num1 : array1) {
      int num2 = num1 - target;
      if (set2.contains(num2)) {
        return new int[] { num1, num2 };
      }
    }

    return null;
  }

  int sum(int[] array) {
    return Arrays.stream(array).sum();
  }

  Optional<Integer> getTargetDiff(int[] array1, int[] array2) {
    int sum1 = sum(array1);
    int sum2 = sum(array2);
    int diff = sum1 - sum2;
    if (diff % 2 != 0) {
      return Optional.empty();
    }
    return Optional.of(diff / 2);
  }

  Set<Integer> buildSet(int[] array) {
    return Arrays.stream(array).boxed().collect(Collectors.toSet());
  }
}
