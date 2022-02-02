package pers.mingda.crackingcodinginterview.chapter3stacksandqueues;

import java.util.Stack;

/**
 *  3.2 Stack Min: How would you design a stack which, in addition to push and pop, has a function min
 *  which returns the minimum element? Push, pop and min should all operate in O(1) time.
 */

public class _3_2StackMin {

}

class StackWithMin extends Stack<NodeWithMin> {
    int min = Integer.MAX_VALUE;

    public int min() {
        return min;
    }

    @Override
    public NodeWithMin pop() {
        NodeWithMin node = super.pop();
        if (node.val == min)
            min = node.previousMin;
        return node;
    }

    public NodeWithMin push(int val) {
        NodeWithMin node = new NodeWithMin(val, this.min);
        super.push(node);
        min = val < min ? val : min;
        return node;
    }
}

class NodeWithMin {
    int val;
    int previousMin;

    public NodeWithMin(int val, int previousMin) {
        this.val = val;
        this.previousMin = previousMin;
    }
}