package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC0146LruCache {}

class LRUCache {

  private DoubleLinkedNode head;
  private DoubleLinkedNode tail;
  private Map<Integer, DoubleLinkedNode> map;
  private int capacity;

  public LRUCache(int capacity) {
    this.map = new HashMap<>();
    this.capacity = capacity;
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      int val = map.get(key).getValue();
      refreshKey(key, val);
      return val;
    }

    return -1;
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      refreshKey(key, value);
    } else {
      DoubleLinkedNode node = new DoubleLinkedNode(key, value);
      if (map.isEmpty()) head = node;
      map.put(key, node);
      addToTail(node);
    }

    if (map.size() > capacity) removeHead();
  }

  private void refreshKey(int key, int value) {
    DoubleLinkedNode node = map.get(key);
    moveToTail(node);
    tail.setValue(value);
  }

  private void removeHead() {
    int oldKey = head.getKey();
    removeNode(head);
    map.remove(oldKey);
  }

  private void moveToTail(DoubleLinkedNode node) {
    removeNode(node);
    addToTail(node);
  }

  private void removeNode(DoubleLinkedNode node) {
    DoubleLinkedNode prev = node.prev;
    DoubleLinkedNode next = node.next;
    if (prev != null) prev.next = next;
    if (next != null) next.prev = prev;
    if (head == node && next != null) head = next;
    if (tail == node && prev != null) tail = prev;
  }

  private void addToTail(DoubleLinkedNode node) {
    if (tail != null) tail.next = node;
    node.prev = tail;
    node.next = null;
    tail = node;
  }
}

class DoubleLinkedNode {

  private int key;
  private int value;
  DoubleLinkedNode prev;
  DoubleLinkedNode next;

  public DoubleLinkedNode(int key, int value) {
    this.key = key;
    this.value = value;
  }

  public int getKey() {
    return key;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }
}
/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj = new
 * LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
