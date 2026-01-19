package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LC0460LfuCache {}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

class LC0460LfuCacheSolution {

  private final int capacity;
  private int leastFreq;
  private final Map<Integer, Integer> cache;
  private final Map<Integer, Integer> keyToFreq;
  private final Map<Integer, LinkedHashSet<Integer>> freqToKey;

  public LC0460LfuCacheSolution(int capacity) {
    this.capacity = capacity;
    this.leastFreq = 0;
    this.cache = new HashMap<>();
    this.keyToFreq = new HashMap<>();
    this.freqToKey = new HashMap<>();
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
      freqToKey.get(lastFreq).remove(key);
      if (freqToKey.get(lastFreq).isEmpty()) {
        freqToKey.remove(lastFreq);
        if (lastFreq == leastFreq) {
          leastFreq++;
        }
      }
    } else {
      leastFreq = newFreq;
    }

    LinkedHashSet<Integer> keys = freqToKey.computeIfAbsent(newFreq, n -> new LinkedHashSet<>());
    keys.add(key);
  }

  private boolean isFull() {
    return cache.size() == capacity;
  }

  private void removeLeastFreqUsed() {
    LinkedHashSet<Integer> keys = freqToKey.get(leastFreq);
    int key = keys.getFirst();
    if (freqToKey.get(leastFreq).size() == 1) {
      freqToKey.remove(leastFreq);
    } else {
      freqToKey.get(leastFreq).remove(key);
    }
    keyToFreq.remove(key);
    cache.remove(key);
  }
}
