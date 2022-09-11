package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class LC0380InsertDeleteGetRandomO1 {

}

class RandomizedSet {

    List<Integer> list;
    Map<Integer, Integer> map;
    Random random;

    public RandomizedSet() {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
        this.random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        int index = map.get(val);
        swapWithTail(index);
        int tailIndex = list.size() - 1;
        list.remove(tailIndex);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }

    private void swapWithTail(int index) {
        int val = list.get(index);
        int tailIndex = list.size() - 1;
        int tailVal = list.get(tailIndex);
        list.set(index, tailVal);
        list.set(tailIndex, val);
        map.put(val, tailIndex);
        map.put(tailVal, index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */