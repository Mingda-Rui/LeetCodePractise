package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC0133CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        Map<Node, Node> map = new HashMap<>();
        return cloneGraph(node, map);
    }

    public Node cloneGraph(Node node, Map<Node, Node> map) {
        if (map.containsKey(node)) return map.get(node);

        map.put(node, new Node(node.val));
        Node newNode = map.get(node);

        for (Node neighbor : node.neighbors) {
            Node newNeighbor = cloneGraph(neighbor, map);
            newNode.neighbors.add(newNeighbor);
        }

        return newNode;
    }

    public Node cloneGraphArray(Node node) {
        if (node == null) return node;
        Node[] array = new Node[101];
        return cloneGraphArray(node, array);
    }

    public Node cloneGraphArray(Node node, Node[] array) {
        if (array[node.val] != null) return array[node.val];

        Node newNode = new Node(node.val);
        array[node.val] = newNode;

        for (Node neighbor : node.neighbors) {
            Node newNeighbor = cloneGraphArray(neighbor, array);
            newNode.neighbors.add(newNeighbor);
        }
        return newNode;
    }
}
