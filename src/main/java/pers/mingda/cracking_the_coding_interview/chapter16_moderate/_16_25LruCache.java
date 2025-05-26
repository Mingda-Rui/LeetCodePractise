package pers.mingda.cracking_the_coding_interview.chapter16_moderate;

import java.util.HashMap;
import java.util.Map;

public class _16_25LruCache {

  Map<Integer, LruCacheNode> map = new HashMap<>();
  LruCacheNode head;
  LruCacheNode tail;
  int size;
  int maxSize;

  String get(int key) {
    if (!map.containsKey(key)) {
      return null;
    }
    LruCacheNode node = map.get(key);
    remove(node);
    addToHead(node);
    return node.value;
  }

  void add(int key, String value) {
    LruCacheNode newNode = new LruCacheNode(key, value);
    add(newNode);
  }

  private void add(LruCacheNode node) {
    map.put(node.key, node);
    addToHead(node);
    if (size == maxSize) {
      removeTail();
    }
  }

  private void remove(LruCacheNode node) {
    LruCacheNode prev = node.prev;
    LruCacheNode next = node.next;
    if (prev == null) {
      head = next;
    } else {
      prev.next = next;
    }

    if (next == null) {
      tail = prev;
    } else {
      next.prev = prev;
    }

    node.prev = null;
    node.next = null;
    size--;
  }

  private void addToHead(LruCacheNode node) {
    node.next = head;
    if (head != null) {
      head.prev = node;
    }
    if (tail == null) {
      tail = node;
    }
    head = node;
    size++;
  }

  private void removeTail() {
    if (size == 0) {
      return;
    } else if (size == 1) {
      head = null;
      tail = null;
    } else {
      tail = tail.prev;
      tail.next.prev = null;
      tail.next = null;
    }
    size--;
  }
}

class LruCacheNode {

  int key;
  String value;
  LruCacheNode prev;
  LruCacheNode next;

  public LruCacheNode(int key, String value) {
    this.key = key;
    this.value = value;
  }
}
