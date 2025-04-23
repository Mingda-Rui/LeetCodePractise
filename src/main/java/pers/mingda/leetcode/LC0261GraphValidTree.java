package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC0261GraphValidTree {}

class LC0261Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Set<Integer> seen = new HashSet<>();
        checkCircle(0, seen, graph);
        return seen.size() == n;
    }

    private boolean checkCircle(int node, Set<Integer> seen, List<List<Integer>> graph) {
        if (seen.contains(node)) return false;
        seen.add(node);
        for (int neighbour : graph.get(node)) checkCircle(neighbour, seen, graph);

        return true;
    }
}

class LC0261UnionFindSolution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        LC0261UnionFind uf = new LC0261UnionFind(n);
        for (int[] edge : edges) if (!uf.union(edge[0], edge[1])) return false;

        return true;
    }
}

class LC0261UnionFind {
    private int[] parent;
    private int[] size;

    public LC0261UnionFind(int n) {
        this.parent = new int[n];
        this.size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    private int find(int node) {
        int root = node;
        while (parent[root] != root) root = parent[root];

        while (parent[node] != root) {
            int oldParent = parent[node];
            parent[node] = root;
            node = oldParent;
        }
        return root;
    }

    public boolean union(int node1, int node2) {
        int parent1 = find(node1);
        int parent2 = find(node2);

        if (parent1 == parent2) return false;

        if (size[parent1] < size[parent2]) {
            parent[parent1] = parent2;
            size[parent2] += size[parent1];
        } else {
            parent[parent2] = parent1;
            size[parent1] += size[parent2];
        }

        return true;
    }
}