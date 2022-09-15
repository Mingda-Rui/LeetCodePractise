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
