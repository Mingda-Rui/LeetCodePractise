package pers.mingda.cracking_the_coding_interview.chapter17_hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class _17_22WordTransformer {
    List<String> transform(String start, String stop, String[] words) {
        Map<String, WordTransformerGraphNode> graph = buildGraph(words);
        WordTransformerGraphNode startNode = graph.get(start);
        WordTransformerGraphNode stopNode = graph.get(stop);
        Queue<WordTransformerGraphNode> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        Map<String, List<String>> paths = new HashMap<>();
        queue.add(startNode);
        seen.add(start);
        paths.put(start, List.of(start));
        return findStop(stopNode, seen, queue, paths);
    }

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

    List<String> findStop(WordTransformerGraphNode stop, Set<String> seen, Queue<WordTransformerGraphNode> queue, Map<String, List<String>> paths) {
        if (queue.isEmpty()) {
            return List.of();
        }
        WordTransformerGraphNode current = queue.poll();
        List<String> path = paths.get(current.val());
        if (current.val().equals(stop.val())) {
            return path;
        }

        for (WordTransformerGraphNode s: current.siblings()) {
            if (!seen.contains(s.val())) {
                seen.add(s.val());
                queue.offer(s);
                List<String> nextPath = new ArrayList<>(path);
                nextPath.add(s.val());
                paths.put(s.val(), nextPath);
            }
        }

        return findStop(stop, seen, queue, paths);
    }
}

record WordTransformerGraphNode(String val, Set<WordTransformerGraphNode> siblings) {}
