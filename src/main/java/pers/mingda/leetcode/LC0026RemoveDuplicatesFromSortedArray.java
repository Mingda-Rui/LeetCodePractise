package pers.mingda.leetcode;

public class LC0026RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int num : nums) {
            if (num != nums[index]) {
                index++;
                nums[index] = num;
            }
        }
        return index + 1;
    }
}
