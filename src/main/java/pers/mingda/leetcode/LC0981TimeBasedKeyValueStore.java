package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LC0981TimeBasedKeyValueStore {

}

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
        if (map.containsKey(key)) {
            Map.Entry<Integer, String> tsVal = map.get(key).floorEntry(timestamp);
            return tsVal == null ? "" : tsVal.getValue();
        } else {
            return "";
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
