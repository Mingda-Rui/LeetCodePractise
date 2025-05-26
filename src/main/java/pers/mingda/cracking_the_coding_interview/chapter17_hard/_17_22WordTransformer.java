package pers.mingda.cracking_the_coding_interview.chapter17_hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.function.BiConsumer;

public class _17_22WordTransformer {
  List<String> transform(String start, String stop, String[] words) {
    Map<String, WordTransformerGraphNode> graph = buildGraph(words);

    WordTransFormerBfsData startData = new WordTransFormerBfsData(start);
    WordTransFormerBfsData stopData = new WordTransFormerBfsData(stop);

    while (!startData.toVisit.isEmpty() || !stopData.toVisit.isEmpty()) {
      String collision1 = search(startData, stopData, graph);
      if (collision1 != null) {
        return merge(startData, stopData, collision1);
      }
      String collision2 = search(stopData, startData, graph);
      if (collision2 != null) {
        return merge(startData, stopData, collision2);
      }
    }

    return null;
  }

  String search(
      WordTransFormerBfsData primary,
      WordTransFormerBfsData secondary,
      Map<String, WordTransformerGraphNode> graph) {
    if (primary.isFinished()) {
      return null;
    }
    WordTransformerPathNode current = primary.toVisit.poll();
    if (secondary.visited.containsKey(current.val())) {
      return current.val();
    }
    for (WordTransformerGraphNode next : graph.get(current.val()).siblings()) {
      if (!primary.visited.containsKey(next.val())) {
        WordTransformerPathNode pathNode = new WordTransformerPathNode(next.val(), current);
        primary.toVisit.add(pathNode);
        primary.visited.put(pathNode.val(), pathNode);
      }
    }

    return null;
  }

  List<String> merge(
      WordTransFormerBfsData startData, WordTransFormerBfsData stopData, String collision) {
    List<String> result = new LinkedList<>();
    List<String> startList = startData.visited.get(collision).collapseFromStart();
    List<String> stopList = stopData.visited.get(collision).collapseFromStart();
    stopList.removeFirst();
    result.addAll(startList);
    result.addAll(stopList);
    return result;
  }
  ;

  Map<String, WordTransformerGraphNode> buildGraph(String[] words) {
    Map<String, WordTransformerGraphNode> graph = new HashMap<>();
    for (String word : words) {
      WordTransformerGraphNode node = new WordTransformerGraphNode(word, new HashSet<>());
      for (String value : graph.keySet()) {
        WordTransformerGraphNode prev = graph.get(value);
        if (oneLetterApart(prev, node)) {
          prev.siblings().add(node);
          node.siblings().add(prev);
        }
      }
      graph.put(word, node);
    }

    return graph;
  }

  boolean oneLetterApart(WordTransformerGraphNode node1, WordTransformerGraphNode node2) {
    int count = 0;
    for (int i = 0; i < node1.val().length(); i++) {
      if (node1.val().charAt(i) != node2.val().charAt(i)) {
        count++;
      }
    }
    return count == 1;
  }
}

record WordTransformerGraphNode(String val, Set<WordTransformerGraphNode> siblings) {}

record WordTransformerPathNode(String val, WordTransformerPathNode prev) {
  /* Traverse path and return linked list of nodes. */
  public List<String> collapseFromStart() {
    return collapse(List::addFirst);
  }

  public List<String> collapseFromEnd() {
    return collapse(List::addLast);
  }

  private List<String> collapse(BiConsumer<List<String>, String> biConsumer) {
    List<String> path = new LinkedList<>();
    WordTransformerPathNode node = this;
    while (node != null) {
      biConsumer.accept(path, node.val);
      node = node.prev();
    }
    return path;
  }
}

class WordTransFormerBfsData {
  public Queue<WordTransformerPathNode> toVisit = new LinkedList<>();
  public Map<String, WordTransformerPathNode> visited = new HashMap<>();

  public WordTransFormerBfsData(String root) {
    WordTransformerPathNode sourcePath = new WordTransformerPathNode(root, null);
    toVisit.add(sourcePath);
    visited.put(root, sourcePath);
  }

  public boolean isFinished() {
    return toVisit.isEmpty();
  }
}
