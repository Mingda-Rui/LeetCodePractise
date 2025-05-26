package pers.mingda.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LC0448FindAllNumbersDisappearedInAnArray {

  public List<Integer> findDisappearedNumbers(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int i = 1; i <= nums.length; i++) set.add(i);
    for (int num : nums) set.remove(num);
    return new LinkedList<>(set);
  }

  public List<Integer> findDisappearedNumbersInPlaceSolution(int[] nums) {
    int index = 0;
    while (index < nums.length) {
      int val = nums[index];
      if (val != index + 1 && nums[val - 1] != val) swap(nums, index, val - 1);
      else index++;
    }

    List<Integer> result = new LinkedList<>();
    for (int i = 0; i < nums.length; i++) if (nums[i] != i + 1) result.add(
      i + 1
    );
    return result;
  }

  private void swap(int[] nums, int index1, int index2) {
    int tmp = nums[index1];
    nums[index1] = nums[index2];
    nums[index2] = tmp;
  }

  public List<Integer> findDisappearedNumbersInPlaceSolutionV2(int[] nums) {
    for (int num : nums) {
      int absNum = Math.abs(num);
      int index = absNum - 1;
      int absVal = Math.abs(nums[index]);
      nums[index] = -absVal;
    }

    List<Integer> result = new LinkedList<>();
    for (int i = 0; i < nums.length; i++) if (nums[i] > 0) result.add(i + 1);
    return result;
  }
}
