package pers.mingda.leetcode;

import java.util.HashSet;
import java.util.Set;

public class CXV1971FindIfPathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
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
