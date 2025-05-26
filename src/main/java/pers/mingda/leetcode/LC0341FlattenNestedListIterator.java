package pers.mingda.leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class LC0341FlattenNestedListIterator {}

class NestedIterator implements Iterator<Integer> {

  private Iterator<Integer> iterator;

  public NestedIterator(List<LC0341NestedInteger> nestedList) {
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

  private List<Integer> parseNestedInt(List<LC0341NestedInteger> nestedList, List<Integer> result) {
    for (LC0341NestedInteger nestedInt : nestedList) {
      if (nestedInt.isInteger()) result.add(nestedInt.getInteger());
      else parseNestedInt(nestedInt.getList(), result);
    }
    return result;
  }
}

class NestedIteratorFlatAsYouGo implements Iterator<Integer> {

  Stack<LC0341NestedInteger> stack;

  public NestedIteratorFlatAsYouGo(List<LC0341NestedInteger> nestedList) {
    this.stack = new Stack<>();
    populateStack(nestedList);
  }

  @Override
  public Integer next() {
    LC0341NestedInteger next = stack.pop();
    return next.getInteger();
  }

  @Override
  public boolean hasNext() {
    while (!stack.isEmpty() && !stack.peek().isInteger()) {
      LC0341NestedInteger next = stack.pop();
      populateStack(next.getList());
    }
    return !stack.isEmpty();
  }

  private void populateStack(List<LC0341NestedInteger> nestedList) {
    for (int i = nestedList.size() - 1; i >= 0; i--) {
      LC0341NestedInteger next = nestedList.get(i);
      stack.push(next);
    }
  }
}

class NestedIteratorWithIteratorStack implements Iterator<Integer> {

  Stack<ListIterator<LC0341NestedInteger>> stack;

  public NestedIteratorWithIteratorStack(List<LC0341NestedInteger> nestedList) {
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
      ListIterator<LC0341NestedInteger> ite = stack.peek();
      if (ite.hasNext()) {
        LC0341NestedInteger next = ite.next();
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

  private void populateStack(List<LC0341NestedInteger> nestedList) {
    stack.push(nestedList.listIterator());
  }
}

interface LC0341NestedInteger {

  // @return true if this LC0341NestedInteger holds a single integer, rather than a nested list.
  public boolean isInteger();

  // @return the single integer that this LC0341NestedInteger holds, if it holds a single integer
  // Return null if this LC0341NestedInteger holds a nested list
  public Integer getInteger();

  // @return the nested list that this LC0341NestedInteger holds, if it holds a nested list
  // Return empty list if this LC0341NestedInteger holds a single integer
  public List<LC0341NestedInteger> getList();
}
