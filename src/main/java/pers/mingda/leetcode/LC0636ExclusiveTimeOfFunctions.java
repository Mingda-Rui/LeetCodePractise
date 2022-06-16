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

            if ("start".equals(op)) {
                if (!funcIdStack.isEmpty()) {
                    int prevFuncId = funcIdStack.peek();
                    result[prevFuncId] += timestamp - prevTs;
                }
                funcIdStack.push(funcId);
                prevTs = timestamp;
            } else {
                funcId = funcIdStack.pop();
                result[funcId] += timestamp - prevTs + 1;
                prevTs = timestamp + 1;
            }
        }
        return result;
    }
}
