package pers.mingda.crackingcodinginterview.chapter4treesandgraphs;

import java.util.LinkedList;
import java.util.List;

public class Node {
    State state;
    int value;
    List<Node> adjacentNodes;

    public Node(int value) {
        this.value = value;
        this.state = State.Unvisited;
        this.adjacentNodes = new LinkedList<>();
    }

    public List<Node> getAdjacent() {
        return adjacentNodes;
    }

    public void setAdjacentNodes(List<Node> adjacentNodes) {
        this.adjacentNodes = adjacentNodes;
    }

    public void addAdjacentNode(Node node) {
        this.adjacentNodes.add(node);
    }

}

enum State { Unvisited, Visited, Visiting; }
