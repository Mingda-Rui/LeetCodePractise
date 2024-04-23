package pers.mingda.cracking_the_coding_interview.chapter4_trees_and_graphs;

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
