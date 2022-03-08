package pers.mingda.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LC1971FindIfPathExistsInGraph {

    public boolean validPathUnionFind(int n, int[][] edges, int source, int destination) {
        int[] unionTable = new int[n];
        unionEdges(edges, unionTable);

        return find(unionTable, source) == find(unionTable, destination);
    }

    private void unionEdges(int[][] edges, int[] unionTable) {
        for (int i = 0; i < unionTable.length; i++) {
            unionTable[i] = i;
        }
        for (int[] edge: edges) {
            union(unionTable, edge[0], edge[1]);
        }
    }

    private void union(int[] unionTable, int a, int b) {
        int rootA = find(unionTable, a);
        int rootB = find(unionTable, b);
        if (rootA != rootB) {
            unionTable[rootA] = rootB;
        }
    }

    private int find(int[] unionTable, int node) {
        if (unionTable[node] == node)
            return node;
        else
            return find(unionTable, unionTable[node]);
    }

    // BFS
    public boolean validPathIteration(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        visited[source] = true;
        boolean newVisit = true;

        while (newVisit) {
            newVisit = false;
            for (int[] edge: edges) {
                if (visited[destination])
                    return true;
                int vertex1 = edge[0];
                int vertex2 = edge[1];
                if (visited[vertex1] && !visited[vertex2]) {
                    visited[vertex2] = true;
                    newVisit = true;
                } else if (!visited[vertex1] && visited[vertex2]) {
                    visited[vertex1] = true;
                    newVisit = true;
                }
            }
        }

        return visited[destination];
    }

    // DFS
    public boolean validPathMapSolution(int n, int[][] edges, int source, int destination) {
        // Given a vertex, get all its neighbors.
        // a table/array to record whether certain vertex is traversed.

        Set<Integer>[] map = new Set[n];
        for (int[] edge: edges) {
            recordEdge(map, edge);
        }
        boolean[] traverseTable = new boolean[n];
        return validPath(map, traverseTable, source, destination);
    }

    private void recordEdge(Set<Integer>[] map, int[] edge) {
        int vertex1 = edge[0];
        int vertex2 = edge[1];
        if (map[vertex1] == null)
            map[vertex1] = new HashSet<>();
        map[vertex1].add(vertex2);

        if (map[vertex2] == null)
            map[vertex2] = new HashSet<>();
        map[vertex2].add(vertex1);
    }

    private boolean validPath(Set<Integer>[] map, boolean[] traverseTable, int source, int destination) {
        if (traverseTable[source])
            return false;
        if (source == destination)
            return true;
        traverseTable[source] = true;
        for (int value: map[source]) {
            if (validPath(map, traverseTable, value, destination)) {
                return true;
            }
        }
        return false;
    }
}
