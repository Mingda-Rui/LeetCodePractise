package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LC0015ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Map<Integer, Integer> noOfValue = new HashMap<>();
        for (int num: nums) {
            noOfValue.putIfAbsent(num, 0);
            noOfValue.computeIfPresent(num, (k, v) -> v + 1);
        }
        List<Integer> values = noOfValue.keySet().stream().toList();

        for (int i = 0; i < values.size(); i++) {
            int firstVal = values.get(i);
            Map<Integer, Integer> tmpMap = new HashMap<>(noOfValue);
            tmpMap.computeIfPresent(firstVal, (k, v) -> v - 1);

            for (int j = i; j < values.size(); j++) {
                int secondVal = values.get(j);
                if (tmpMap.get(secondVal) > 0) {
                    tmpMap.computeIfPresent(secondVal, (k, v) -> v - 1);
                    int remain = - firstVal - secondVal;
                    if (tmpMap.getOrDefault(remain, 0) > 0)
                        result.add(Arrays.asList(firstVal, secondVal, remain));
                    // tmpMap.computeIfPresent(secondVal, (k, v) -> v + 1);
                }
                tmpMap.put(secondVal, 0);
            }
            noOfValue.put(firstVal, 0);
        }
        return result;
    }

    public List<List<Integer>> threeSumSortWithMap(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        Map<Integer, Integer> valueMap = new HashMap<>();
        for (int num: nums) {
            valueMap.putIfAbsent(num, 1);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int firstVal = nums[i];
                int secondVal = nums[j];
                int remain = - firstVal - secondVal;

                if (remain == secondVal && j + 1 < nums.length && nums[j + 1] == remain)
                    result.add(Arrays.asList(firstVal, secondVal, remain));
                else if (remain > secondVal && valueMap.getOrDefault(remain, 0) > 0)
                    result.add(Arrays.asList(firstVal, secondVal, remain));
                j = getLastSameIndex(nums, j);
            }
            i = getLastSameIndex(nums, i);
        }

        return result;

    }

    private int getLastSameIndex(int[] nums, int index) {
        if (index >= nums.length)
            return nums.length;
        int current = nums[index];
        while (index + 1 < nums.length && nums[index + 1] == current) {
            index++;
        }
        return index;
    }
}
