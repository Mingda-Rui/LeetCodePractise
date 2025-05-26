package pers.mingda.cracking_the_coding_interview.chapter4_trees_and_graphs;

import java.util.List;

public class Graph {

  private List<Node> nodes;

  public Graph(List<Node> nodes) {
    this.nodes = nodes;
  }

  public List<Node> getNodes() {
    return nodes;
  }
}
