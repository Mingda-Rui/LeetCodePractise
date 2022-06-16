package pers.mingda.leetcode;

import java.util.List;
import java.util.Stack;

public class LC0636ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> funcIdStack = new Stack<>();
        int prevTs = 0;
        int[] result = new int[n];
        for (String log: logs) {
            String[] parsedLog = log.split(":");
            int funcId = Integer.valueOf(parsedLog[0]);
            String op = parsedLog[1];
            int timestamp = Integer.valueOf(parsedLog[2]);

            if (!funcIdStack.isEmpty()) {
                int prevFuncId = funcIdStack.peek();
                result[prevFuncId] += timestamp - prevTs;
            }

            if ("start".equals(op)) {
                funcIdStack.push(funcId);
                prevTs = timestamp;
            } else {
                funcIdStack.pop();
                prevTs = timestamp + 1;
                result[funcId]++;
            }
        }
        return result;
    }
}
