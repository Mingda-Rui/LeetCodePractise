package pers.mingda.leetcode;

public class LC0027RemoveElement {
    public int removeElement(int[] nums, int val) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            int curVal = nums[fast];
            if (nums[fast] == val) {
                nums[slow] = curVal;
                slow++;
            }
        }
        return slow;
    }

    public int removeElementOptimized(int[] nums, int val) {
        int head = 0;
        int tail = nums.length;
        while (head < tail) {
            if (nums[head] == val) {
                tail--;
                nums[head] = nums[tail];
            } else {
                head++;
            }
        }
        return tail;
    }
}
