package pers.mingda.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class LC0743NetworkDelayTime {

}

class LC0743Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, LC0743Node> network = buildNetwork(times);
        Comparator<LC0743Node> comparator = Comparator.comparingInt(LC0743Node -> LC0743Node.time);
        PriorityQueue<LC0743Node> queue = new PriorityQueue<>(comparator);
        LC0743Node start = network.get(k);
        start.time = 0;
        queue.add(start);
        Set<Integer> seen = new HashSet<>();
        int total = 0;
        while (!queue.isEmpty()) {
            LC0743Node current = queue.poll();
            seen.add(current.label);
            total = current.time;
            for (int neighLabel: current.map.keySet()) {
                LC0743Node neighLC0743Node = network.get(neighLabel);
                int newTime = current.time + current.map.get(neighLabel);
                if (newTime < neighLC0743Node.time) {
                    neighLC0743Node.time = newTime;
                    queue.add(neighLC0743Node);
                }
            }
        }
        return seen.size() == n ? total : -1;
    }

    private Map<Integer, LC0743Node> buildNetwork(int[][] times) {
        Map<Integer, LC0743Node> network = new HashMap<>();
        for (int[] time: times) {
            int from = time[0];
            int to = time[1];
            int distance = time[2];
            network.putIfAbsent(from, new LC0743Node(from));
            network.putIfAbsent(to, new LC0743Node(to));
            LC0743Node fromLC0743Node = network.get(from);
            fromLC0743Node.map.put(to, distance);
        }
        return network;
    }
}

class LC0743Node {
    int label;
    int time;
    Map<Integer, Integer> map;
    public LC0743Node(int label) {
        this.label = label;
        map = new HashMap<>();
        time = Integer.MAX_VALUE;
    }
}