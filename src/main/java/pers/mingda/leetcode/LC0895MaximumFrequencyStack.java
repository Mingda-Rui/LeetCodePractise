package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LC0895MaximumFrequencyStack {}

class FreqStack {

    Map<Integer, Integer> itemFreqMap;
    Map<Integer, Stack<Integer>> freqStackMap;
    int maxFreq;

    public FreqStack() {
        this.itemFreqMap = new HashMap<>();
        this.freqStackMap = new HashMap<>();
        this.maxFreq = 0;
    }

    public void push(int val) {
        int freq = itemFreqMap.getOrDefault(val, 0);
        freq++;
        itemFreqMap.put(val, freq);
        maxFreq = Math.max(maxFreq, freq);

        freqStackMap.putIfAbsent(freq, new Stack<>());
        freqStackMap.get(freq).push(val);
    }

    public int pop() {
        if (maxFreq == 0) return -1;
        Stack<Integer> stack = freqStackMap.get(maxFreq);
        int result = stack.pop();
        itemFreqMap.put(result, maxFreq - 1);
        if (stack.isEmpty()) maxFreq--;
        return result;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
