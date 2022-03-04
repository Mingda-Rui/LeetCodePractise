package pers.mingda.crackingcodinginterview.chapter4treesandgraphs;

import java.util.List;

/**
 *  4.1 Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
 *  route between two nodes
 */

public class _4_1RouteBetweenNodes {
    public static boolean search(Graph g, Node start, Node end) {
        if (g == null || start == null || end == null)
            return false;
        List<Node> nodes = start.getAdjacent();
        while (!nodes.isEmpty()) {
            Node node = nodes.remove(0);
            if (node == end)
                return true;
            node.state = State.Visited;
            for (Node next: node.getAdjacent())
                if (next.state != State.Visited)
                    nodes.add(next);
        }

        return false;
    }
}
