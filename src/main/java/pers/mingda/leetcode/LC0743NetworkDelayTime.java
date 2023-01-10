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
        Map<Integer, Node> network = buildNetwork(times);
        Comparator<Node> comparator = Comparator.comparingInt(node -> node.time);
        PriorityQueue<Node> queue = new PriorityQueue<>(comparator);
        Node start = network.get(k);
        start.time = 0;
        queue.add(start);
        Set<Integer> seen = new HashSet<>();
        int total = 0;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            seen.add(current.label);
            total = current.time;
            for (int neighLabel: current.map.keySet()) {
                Node neighNode = network.get(neighLabel);
                int newTime = current.time + current.map.get(neighLabel);
                if (newTime < neighNode.time) {
                    neighNode.time = newTime;
                    queue.add(neighNode);
                }
            }
        }
        return seen.size() == n ? total : -1;
    }

    private Map<Integer, Node> buildNetwork(int[][] times) {
        Map<Integer, Node> network = new HashMap<>();
        for (int[] time: times) {
            int from = time[0];
            int to = time[1];
            int distance = time[2];
            network.putIfAbsent(from, new Node(from));
            network.putIfAbsent(to, new Node(to));
            Node fromNode = network.get(from);
            fromNode.map.put(to, distance);
        }
        return network;
    }
}

class Node {
    int label;
    int time;
    Map<Integer, Integer> map;
    public Node(int label) {
        this.label = label;
        map = new HashMap<>();
        time = Integer.MAX_VALUE;
    }
}