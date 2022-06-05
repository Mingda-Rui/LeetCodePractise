package pers.mingda.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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