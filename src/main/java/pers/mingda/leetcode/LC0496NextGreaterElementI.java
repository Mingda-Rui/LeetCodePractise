package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LC0496NextGreaterElementI {}

class LC0496Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            int num = nums2[i];
            for (int j = i + 1; j < nums2.length; j++) {
                int nextGreater = nums2[j];
                if (nums2[j] > num) {
                    map.put(num, nextGreater);
                    break;
                }
            }
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int num = nums1[i];
            result[i] = map.getOrDefault(num, -1);
        }
        return result;
    }
}

class StackSolution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {

            while (!stack.isEmpty() && stack.peek() < num) {
                int smaller = stack.pop();
                map.put(smaller, num);
            }
            stack.push(num);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int num = nums1[i];
            result[i] = map.getOrDefault(num, -1);
        }
        return result;
    }
}