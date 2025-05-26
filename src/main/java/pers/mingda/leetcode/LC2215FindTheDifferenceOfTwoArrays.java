package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LC2215FindTheDifferenceOfTwoArrays {

  public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
    Set<Integer> set1 = Arrays.stream(nums1)
      .boxed()
      .collect(Collectors.toSet());
    Set<Integer> set2 = Arrays.stream(nums2)
      .boxed()
      .collect(Collectors.toSet());

    Set<Integer> newSet1 = new HashSet<>(set1);
    newSet1.removeAll(set2);
    set2.removeAll(set1);

    List<Integer> list1 = newSet1.stream().toList();
    List<Integer> list2 = set2.stream().toList();
    return List.of(list1, list2);
  }
}
