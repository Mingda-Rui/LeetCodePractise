package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LC0071SimplifyPath {
    public String simplifyPath(String path) {
        if (path.charAt(0) != '/')
            path = "/" + path;
        int current = -1;
        char[] arr = path.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            boolean startWithDot = false;
            if (current >= 0 && arr[current] == '/' && arr[i] == '.') {
                startWithDot = true;
                if (i + 1 == arr.length || arr[i + 1] == '/') {
                    i++;
                } else if ((i + 2 == arr.length && arr[i + 1] == '.')|| (arr[i + 1] == '.' && arr[i + 2] == '/') ) {
                    if (stack.size() > 1)
                        stack.pop();
                    current = stack.peek();
                    i += 2;
                } else {
                    startWithDot = false;
                }
            }
            if (!startWithDot && (current < 0 || arr[current] != '/' || arr[i] != '/') ) {
                current++;
                arr[current] = arr[i];
                if (arr[current] == '/')
                    stack.push(current);
            }
        }
        if (current > 0 && arr[current] == '/')
            current--;
        String result = String.valueOf(arr, 0, current + 1);
        return result;
    }

    public String simplifyPathShortSolution(String path) {
        String[] dirArr = path.split("/");
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        Set<String> set = new HashSet<>(Arrays.asList("", ".", ".."));
        for (String dir: dirArr) {
            if ("..".equals(dir) && !stack.isEmpty()) {
                stack.pop();
            } else if (!set.contains(dir)) {
                stack.push(dir);
            }
        }
        for (String dir: stack)
            sb.append("/").append(dir);
        return sb.isEmpty() ? "/" : sb.toString();
    }
}

