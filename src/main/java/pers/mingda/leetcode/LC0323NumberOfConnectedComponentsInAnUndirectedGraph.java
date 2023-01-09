package pers.mingda.leetcode;

public class LC0323NumberOfConnectedComponentsInAnUndirectedGraph {

}

class LC0323UnionFindSolution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge: edges)
            uf.union(edge[0], edge[1]);
        return uf.countRootNode();
    }
}

class UnionFind {
    private int[] parent;

    public UnionFind(int n) {
        this.parent = new int[n];
        for (int i = 0; i < n; i ++)
            parent[i] = i;
    }

    private int find(int node) {
        while (parent[node] != node)
            node = parent[node];
        return node;
    }

    public void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        parent[root1] = root2;
    }

    public int countRootNode() {
        int counter = 0;
        for (int i = 0; i < parent.length; i++)
            if (i == parent[i])
                counter++;
        return counter;
    }
}