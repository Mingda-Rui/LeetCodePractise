package pers.mingda.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class LC1584MinCostToConnectAllPoints {

}

class Solution {

    Map<int[], Integer> map = new HashMap<>();

    public int minCostConnectPoints(int[][] points) {
        Comparator<int[][]> edgeComparator = Comparator.comparingInt(this::getLengthOfEdge);
        Queue<int[][]> queue = new PriorityQueue<>(edgeComparator);

        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            map.put(point, i);

            for (int j = i + 1; j < points.length; j++) {
                int[] point2 = points[j];
                int[][] edge = {point, point2};
                queue.offer(edge);
            }
        }

        boolean[] seen = new boolean[points.length];
        int numOfEdge = 0;
        int sumOfEdge = 0;
        Set<int[][]> disjointEdges = new HashSet<>();
        while (!queue.isEmpty() && numOfEdge < points.length - 1) {
            int[][] edge = queue.poll();
            if (!circleCheck(seen, edge)) {
                System.out.println("remove circle!");
                continue;
            } else if (checkIsConnected(seen, edge, numOfEdge)) {
                sumOfEdge += getLengthOfEdge(edge);
                numOfEdge ++;
                queue.addAll(disjointEdges);
                disjointEdges = new HashSet<>();
            } else {
                disjointEdges.add(edge);
            }
        }
        return sumOfEdge;
    }

    private boolean circleCheck(boolean[] seen, int[][] edge) {
        int point1 = map.get(edge[0]);
        int point2 = map.get(edge[1]);
        return !seen[point1] || !seen[point2];
    }

    private boolean checkIsConnected(boolean[] seen, int[][] edge, int numOfEdge) {
        int point1 = map.get(edge[0]);
        int point2 = map.get(edge[1]);
        boolean isConnected = seen[point1] || seen[point2];
        if (isConnected || numOfEdge == 0) {
            seen[point1] = true;
            seen[point2] = true;
            return true;
        }

        return false;
    }

    private int getLengthOfEdge(int[][] edge) {
        int[] point1 = edge[0];
        int[] point2 = edge[1];
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }
}

class UnionFindSolution {
    public int minCostConnectPoints(int[][] points) {
        Comparator<int[][]> edgeComparator = Comparator.comparingInt(this::getLengthOfEdge);
        Queue<int[][]> queue = new PriorityQueue<>(edgeComparator);
        Map<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            map.put(point, i);

            for (int j = i + 1; j < points.length; j++) {
                int[] point2 = points[j];
                int[][] edge = {point, point2};
                queue.offer(edge);
            }
        }

        int numOfEdge = 0;
        int sumOfEdge = 0;
        UnionFind uf = new UnionFind(points.length);
        while (!queue.isEmpty() && numOfEdge < points.length - 1) {
            int[][] edge = queue.poll();
            int point1 = map.get(edge[0]);
            int point2 = map.get(edge[1]);

            if (uf.union(point1, point2)) {
                sumOfEdge += getLengthOfEdge(edge);
                numOfEdge ++;
            }
        }
        return sumOfEdge;
    }

    private int getLengthOfEdge(int[][] edge) {
        int[] point1 = edge[0];
        int[] point2 = edge[1];
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
    }
}

class UnionFind {
    private int[] group;
    private int[] rank;

    public UnionFind(int size) {
        this.group = new int[size];
        this.rank = new int[size];
        for (int i = 0; i < group.length; i++)
            group[i] = i;
    }

    public boolean union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        if (root1 == root2)
            return false;
        if (rank[root1] < rank[root2]) {
            group[root1] = root2;
            rank[root2]++;
        } else {
            group[root2] = root1;
            rank[root1]++;
        }
        return true;
    }

    public int find(int node) {
        while (group[node] != node)
            node = group[node];
        return node;
    }
}
