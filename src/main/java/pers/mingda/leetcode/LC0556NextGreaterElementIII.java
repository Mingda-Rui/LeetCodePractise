package pers.mingda.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class LC0556NextGreaterElementIII {}

class LC0556Solution {
    public int nextGreaterElement(int n) {
        String s = String.valueOf(n);
        Stack<Character> stack = new Stack<>();
        int index = s.length() - 1;
        while (index >= 0 && (stack.isEmpty() || s.charAt(index) >= stack.peek())) {
            stack.push(s.charAt(index));
            index--;
        }
        if (index < 0) return -1;
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

        int swapIndex = len - 2;
        while (swapIndex >= 0 && chars[swapIndex] >= chars[swapIndex + 1]) swapIndex--;

        if (swapIndex < 0) return -1;

        int nextGreaterIndex = swapIndex;
        char toBeSwapped = chars[swapIndex];
        while (nextGreaterIndex + 1 < len && chars[nextGreaterIndex + 1] > toBeSwapped) nextGreaterIndex++;

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
            swap(chars, head, tail);
            head++;
            tail--;
        }
    }
}