package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LC0981TimeBasedKeyValueStore {}

class TimeMap {

  Map<String, TreeMap<Integer, String>> map;

  public TimeMap() {
    this.map = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    map.putIfAbsent(key, new TreeMap<>());
    TreeMap<Integer, String> keyMap = map.get(key);
    keyMap.put(timestamp, value);
  }

  public String get(String key, int timestamp) {
    if (!map.containsKey(key)) return "";
    Map.Entry<Integer, String> tsVal = map.get(key).floorEntry(timestamp);
    return tsVal == null ? "" : tsVal.getValue();
  }
}

class TimeMapBinarySearchSolution {

  Map<String, List<TimestampedValue>> map;

  public TimeMapBinarySearchSolution() {
    this.map = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    map.putIfAbsent(key, new ArrayList<>());
    TimestampedValue tsVal = new TimestampedValue(timestamp, value);
    map.get(key).add(tsVal);
  }

  public String get(String key, int timestamp) {
    if (!map.containsKey(key)) return "";
    List<TimestampedValue> timestamps = map.get(key);
    TimestampedValue tsVal = findFloor(timestamps, timestamp);
    return tsVal == null ? "" : tsVal.value;
  }

  private TimestampedValue findFloor(List<TimestampedValue> timestamps, int timestamp) {
    return findFloor(timestamps, 0, timestamps.size(), timestamp);
  }

  private TimestampedValue findFloor(
      List<TimestampedValue> timestamps, int start, int end, int timestamp) {
    if (start + 1 == end) {
      TimestampedValue floorTsVal = timestamps.get(start);
      return floorTsVal.timestamp <= timestamp ? floorTsVal : null;
    }
    int mid = start + (end - start) / 2;
    TimestampedValue tsVal = timestamps.get(mid);
    if (tsVal.timestamp < timestamp) return findFloor(timestamps, mid, end, timestamp);
    else if (tsVal.timestamp > timestamp) return findFloor(timestamps, start, mid, timestamp);
    return tsVal;
  }
}

class TimestampedValue {
  int timestamp;
  String value;

  public TimestampedValue(int timestamp, String value) {
    this.timestamp = timestamp;
    this.value = value;
  }
}

/**
 * Your TimeMap object will be instantiated and called as such: TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp); String param_2 = obj.get(key,timestamp);
 */
