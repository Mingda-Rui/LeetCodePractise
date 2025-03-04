package pers.mingda.cracking_the_coding_interview.chapter17_hard;

import java.util.*;

public class _17_22WordTransformer {
    List<String> transform(String start, String stop, String[] words) {
        Map<String, WordTransformer> graph = buildGraph(words);
        WordTransformer startNode = graph.get(start);
        WordTransformer stopNode = graph.get(stop);
        return findStop(graph, startNode, stopNode, new ArrayList<>(), new HashSet<>());
    }

    Map<String, WordTransformer> buildGraph(String[] words) {
        Map<String, WordTransformer> graph = new HashMap<>();
        for (String word : words) {
            WordTransformer node = new WordTransformer(word, new HashSet<>());
            for (String value : graph.keySet()) {
                WordTransformer prev = graph.get(value);
                if (oneLetterApart(prev, node)) {
                    prev.siblings().add(node);
                    node.siblings().add(prev);
                }
            }
            graph.put(word, node);
        }

        return graph;
    }

    boolean oneLetterApart(WordTransformer node1, WordTransformer node2) {
        int count = 0;
        for (int i = 0; i < node1.val().length(); i++) {
            if (node1.val().charAt(i) != node2.val().charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }



    List<String> findStop(Map<String, WordTransformer> graph, WordTransformer current, WordTransformer stop, List<String> path, Set<String> seen) {
        if (seen.contains(current.val())) {
            return List.of();
        }
        path.add(current.val());
        seen.add(current.val());
        if (current.val().equals(stop.val())) {
            return path;
        }

        for (WordTransformer node: current.siblings()) {
            List<String> result = findStop(graph, node, stop, path, seen);
            if (!result.isEmpty()) {
                return result;
            }
        }
        path.removeLast();
        return List.of();
    }
}

record WordTransformer(String val, Set<WordTransformer> siblings) {}
