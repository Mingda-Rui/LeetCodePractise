package pers.mingda.leetcode;

import java.util.List;
import java.util.Stack;

public class LC0636ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> funcIdStack = new Stack<>();
        Stack<Integer> tsStack = new Stack<>();
        int[] result = new int[n];
        for (String log: logs) {
            String[] parsedLog = log.split(":");
            int funcId = Integer.valueOf(parsedLog[0]);
            String op = parsedLog[1];
            int timestamp = Integer.valueOf(parsedLog[2]);

            if ("start".equals(op)) {
                if (!funcIdStack.isEmpty()) {
                    int prevFuncId = funcIdStack.peek();
                    int prevTs = tsStack.peek();
                    result[prevFuncId] += timestamp - prevTs;
                }
                funcIdStack.push(funcId);
                tsStack.push(timestamp);
            } else {
                funcId = funcIdStack.pop();
                int resumedTime = tsStack.pop();
                if (!tsStack.isEmpty()) {
                    tsStack.pop();
                    tsStack.push(timestamp + 1);
                }
                result[funcId] += timestamp - resumedTime + 1;
            }
        }
        return result;
    }
}
