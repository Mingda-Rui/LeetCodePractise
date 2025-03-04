package pers.mingda.cracking_the_coding_interview.chapter17_hard;

import java.util.*;

public class _17_22WordTransformer {
    List<String> transform(String start, String stop, String[] words) {
        Map<String, WordTransformer> graph = buildGraph(words);
        WordTransformer startNode = graph.get(start);
        WordTransformer stopNode = graph.get(stop);
        Queue<WordTransformer> queue = new LinkedList<>();
        Set<String> seen = new HashSet<>();
        Map<String, List<String>> paths = new HashMap<>();
        queue.add(startNode);
        seen.add(start);
        paths.put(start, List.of(start));
        return findStop(stopNode, seen, queue, paths);
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

    List<String> findStop(WordTransformer stop, Set<String> seen, Queue<WordTransformer> queue, Map<String, List<String>> paths) {
        if (queue.isEmpty()) {
            return List.of();
        }
        WordTransformer current = queue.poll();
        List<String> path = paths.get(current.val());
        if (current.val().equals(stop.val())) {
            return path;
        }

        for (WordTransformer s: current.siblings()) {
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

record WordTransformer(String val, Set<WordTransformer> siblings) {}
