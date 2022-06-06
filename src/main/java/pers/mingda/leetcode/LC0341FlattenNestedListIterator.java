package pers.mingda.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class LC0341FlattenNestedListIterator {

}

class NestedIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;

    public NestedIterator(List<NestedInteger> nestedList) {
        List<Integer> flattendList = parseNestedInt(nestedList, new LinkedList<>());
        this.iterator = flattendList.iterator();
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    private List<Integer> parseNestedInt(List<NestedInteger> nestedList, List<Integer> result) {
        for (NestedInteger nestedInt: nestedList) {
            if (nestedInt.isInteger())
                result.add(nestedInt.getInteger());
            else
                parseNestedInt(nestedInt.getList(), result);
        }
        return result;
    }
}

class NestedIteratorFlatAsYouGo implements Iterator<Integer> {

    Stack<NestedInteger> stack;

    public NestedIteratorFlatAsYouGo(List<NestedInteger> nestedList) {
        this.stack = new Stack<>();
        populateStack(nestedList);
    }

    @Override
    public Integer next() {
        NestedInteger next = stack.pop();
        return next.getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            NestedInteger next = stack.pop();
            populateStack(next.getList());
        }
        return !stack.isEmpty();
    }


    private void populateStack(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            NestedInteger next = nestedList.get(i);
            stack.push(next);
        }
    }
}

class NestedIteratorWithIteratorStack implements Iterator<Integer> {

    Stack<ListIterator<NestedInteger>> stack;

    public NestedIteratorWithIteratorStack(List<NestedInteger> nestedList) {
        this.stack = new Stack<>();
        populateStack(nestedList);
    }

    @Override
    public Integer next() {
        return stack.peek().next().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            ListIterator<NestedInteger> ite = stack.peek();
            if (ite.hasNext()) {
                NestedInteger next = ite.next();
                if (next.isInteger()) {
                    ite.previous();
                    return true;
                } else {
                    populateStack(next.getList());
                }
            } else {
                stack.pop();
            }
        }
        return false;
    }

    private void populateStack(List<NestedInteger> nestedList) {
        stack.push(nestedList.listIterator());
    }
}

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}