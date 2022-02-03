package pers.mingda.crackingcodinginterview.chapter3stacksandqueues;

import java.util.Stack;

/**
 *  3.2 Stack Min: How would you design a stack which, in addition to push and pop, has a function min
 *  which returns the minimum element? Push, pop and min should all operate in O(1) time.
 */

public class _3_2StackMin {

}

class StackWithMin extends Stack<NodeWithMin> {
    public int min() {
        if (this.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        return this.peek().min;
    }

    public NodeWithMin push(int val) {
        int min = Math.min(min(), val);
        NodeWithMin node = new NodeWithMin(val, min);
        return super.push(node);
    }
}

class NodeWithMin {
    int val;
    int min;

    public NodeWithMin(int val, int min) {
        this.val = val;
        this.min = min;
    }
}
