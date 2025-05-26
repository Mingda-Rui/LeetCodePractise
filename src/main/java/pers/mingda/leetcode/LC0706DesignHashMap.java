package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC0706DesignHashMap {}

class LC0706MyHashMap {

  private final int mod = 2069;
  private final List<LC0706Bucket> buckets;

  public LC0706MyHashMap() {
    buckets = new ArrayList<>();
    for (int i = 0; i < mod; i++) {
      buckets.add(new LC0706Bucket());
    }
  }

  public void put(int key, int value) {
    getBucket(key).put(key, value);
  }

  public int get(int key) {
    return getBucket(key).find(key);
  }

  public void remove(int key) {
    getBucket(key).remove(key);
  }

  private LC0706Bucket getBucket(int key) {
    int hash = hash(key);
    return buckets.get(hash);
  }

  private int hash(int key) {
    return key % mod;
  }
}

class LC0706Bucket {
  private final List<LC0706Pair> records;

  public LC0706Bucket() {
    this.records = new LinkedList<>();
  }

  public void put(int key, int value) {
    LC0706Pair next = new LC0706Pair(key, value);
    for (int i = 0; i < records.size(); i++) {
      if (records.get(i).key() == key) {
        records.set(i, next);
        return;
      }
    }
    records.add(next);
  }

  public int find(int key) {
    for (LC0706Pair record : records) {
      if (record.key() == key) {
        return record.val();
      }
    }
    return -1;
  }

  public void remove(int key) {
    for (LC0706Pair record : records) {
      if (record.key() == key) {
        records.remove(record);
        return;
      }
    }
  }
}

record LC0706Pair(int key, int val) {}

/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj = new MyHashMap();
 * obj.put(key,value); int param_2 = obj.get(key); obj.remove(key);
 */
