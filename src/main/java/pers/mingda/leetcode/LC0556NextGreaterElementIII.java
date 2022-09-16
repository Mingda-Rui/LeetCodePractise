package pers.mingda.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class LC0556NextGreaterElementIII {

}

class Solution {
    public int nextGreaterElement(int n) {
        String s = String.valueOf(n);
        Stack<Character> stack = new Stack<>();
        int index = s.length() - 1;
        while (index >= 0
               && (stack.isEmpty() || s.charAt(index) >= stack.peek()) ) {
            stack.push(s.charAt(index));
            index--;
        }
        if (index < 0)
            return -1;
        String originalPart = s.substring(0, index);
        int nextGreater = index;
        while (!stack.isEmpty() && s.charAt(index) < stack.peek()) {
            stack.pop();
            nextGreater++;
        }
        originalPart += s.charAt(nextGreater);
        Queue<Character> queue = new PriorityQueue<>();
        for (int i = index; i < s.length(); i++) {
            if (i != nextGreater) {
                queue.offer(s.charAt(i));
            }
        }

        while (!queue.isEmpty()) {
            originalPart += queue.poll();
        }
        long result = Long.valueOf(originalPart);
        return result > Integer.MAX_VALUE ? -1 : (int) result;
    }
}

class ArraySolution {
    public int nextGreaterElement(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int len = chars.length;
        int swapIndex = len - 1;
        for (int i = len - 2; i >= 0; i--) {
            char toBeSwapped = chars[i];
            char next = chars[i + 1];
            if (toBeSwapped < next) {
                swapIndex = i;
                break;
            }
        }

        if (swapIndex == len - 1)
            return -1;
        int nextGreaterIndex = len - 1;
        char toBeSwapped = chars[swapIndex];
        for (int i = swapIndex + 1; i < len; i++) {
            char c = chars[i];
            if (toBeSwapped < c)
                nextGreaterIndex = i;
            else
                break;
        }

        swap(chars, swapIndex, nextGreaterIndex);
        reverse(chars, swapIndex + 1, len);
        long result = Long.valueOf(String.valueOf(chars));
        return result > Integer.MAX_VALUE ? -1 : (int) result;
    }

    private void swap(char[] chars, int index1, int index2) {
        char tmp = chars[index1];
        chars[index1] = chars[index2];
        chars[index2] = tmp;
    }

    private void reverse(char[] chars, int start, int end) {
        int head = start;
        int tail = end - 1;
        while (head < tail) {
            char tmp = chars[head];
            chars[head] = chars[tail];
            chars[tail] = tmp;
            head++;
            tail--;
        }
    }
}