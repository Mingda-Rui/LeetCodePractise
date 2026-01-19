package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LC0460LfuCache {}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

class LC0460LfuCacheSolution {

  private final int capacity;
  private final Map<Integer, Integer> cache;
  private final Map<Integer, Integer> keyToFreq;
  private final TreeMap<Integer, LinkedList<Integer>> freqToKey;

  public LC0460LfuCacheSolution(int capacity) {
    this.capacity = capacity;
    this.cache = new HashMap<>();
    this.keyToFreq = new HashMap<>();
    this.freqToKey = new TreeMap<>();
  }

  public int get(int key) {
    if (!cache.containsKey(key)) {
      return -1;
    }
    fresh(key);
    return cache.get(key);
  }

  public void put(int key, int value) {
    if (!cache.containsKey(key) && isFull()) {
      removeLeastFreqUsed();
    }
    cache.put(key, value);
    fresh(key);
  }

  private void fresh(int key) {
    int lastFreq = keyToFreq.getOrDefault(key, 0);
    int newFreq = lastFreq + 1;
    keyToFreq.put(key, newFreq);

    if (lastFreq > 0) {
      freqToKey.get(lastFreq).remove((Integer) key);
      if (freqToKey.get(lastFreq).isEmpty()) {
        freqToKey.remove(lastFreq);
      }
    }

    if (!freqToKey.containsKey(newFreq)) {
      freqToKey.put(newFreq, new LinkedList<>());
    }
    freqToKey.get(newFreq).add(key);
  }

  private boolean isFull() {
    return cache.size() == capacity;
  }

  private void removeLeastFreqUsed() {
    int leastFreq = freqToKey.firstKey();
    List<Integer> keys = freqToKey.get(leastFreq);
    int key = keys.getFirst();
    if (freqToKey.get(leastFreq).size() == 1) {
      freqToKey.remove(leastFreq);
    } else {
      freqToKey.get(leastFreq).remove((Integer) key);
    }
    keyToFreq.remove(key);
    cache.remove(key);
  }
}
