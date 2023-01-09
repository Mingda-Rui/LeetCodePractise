package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC0261GraphValidTree {

}

class LC0261Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Set<Integer> seen = new HashSet<>();
        checkCircle(0, seen, graph);
        return seen.size() == n;
    }

    private boolean checkCircle(int node, Set<Integer> seen, List<List<Integer>> graph) {
        if (seen.contains(node))
            return false;
        seen.add(node);
        for (int neighbour: graph.get(node))
            checkCircle(neighbour, seen, graph);

        return true;
    }
}

class LC0261UnionFindSolution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1)
            return false;
        UnionFind uf = new UnionFind(n);
        for (int[] edge: edges)
            uf.union(edge[0], edge[1]);

        return uf.getSetCount() == 1;
    }
}

class UnionFind {
    private int[] parent;

    public UnionFind(int size) {
        this.parent = new int[size];
        for (int i = 0; i < size; i++)
            parent[i] = i;
    }

    private int find(int node) {
        while (parent[node] != node)
            node = parent[node];
        return node;
    }

    public void union(int node1, int node2) {
        int parent1 = find(node1);
        int parent2 = find(node2);
        parent[parent1] = parent2;
    }

    public int getSetCount() {
        Set<Integer> set = new HashSet<>();
        for (int node: parent)
            set.add(find(node));

        return set.size();
    }
}
