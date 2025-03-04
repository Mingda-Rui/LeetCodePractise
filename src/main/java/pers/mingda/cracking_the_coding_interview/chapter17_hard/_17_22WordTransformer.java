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
        Map<String, WordTransformerPathNode> paths = new HashMap<>();
        Set<String> startVisited = new HashSet<>();
        Set<String> stopVisited = new HashSet<>();
        Queue<WordTransformerGraphNode> startQueue = new LinkedList<>();
        Queue<WordTransformerGraphNode> stopQueue = new LinkedList<>();

        startQueue.add(graph.get(start));
        startVisited.add(start);
        stopQueue.add(graph.get(stop));
        stopVisited.add(stop);
        paths.put(start, new WordTransformerPathNode(start, null));
        paths.put(stop, new WordTransformerPathNode(stop, null));

        List<String> result = new ArrayList<>();

        while (!startQueue.isEmpty() || !stopQueue.isEmpty()) {
            List<String> startPaths = searchLevel(startQueue, startVisited, stopVisited, paths);
            if (!startPaths.isEmpty()) {
                result.addAll(startPaths);
                break;
            }
            List<String> stopPaths = searchLevel(stopQueue, stopVisited, startVisited, paths);
            if (!stopPaths.isEmpty()) {
                result.addAll(stopPaths);
                break;
            }
        }

        if (!result.isEmpty() && result.getFirst().equals(stop)) {
            return result.reversed();
        }
        return result;
    }

    List<String> searchLevel(Queue<WordTransformerGraphNode> queue,
                       Set<String> visited,
                       Set<String> oppositeVisited,
                       Map<String, WordTransformerPathNode> paths) {
        if (queue.isEmpty()) {
            return List.of();
        }
        WordTransformerGraphNode currentStart = queue.poll();
        if (!visited.contains(currentStart.val())) {
            for (WordTransformerGraphNode startS : currentStart.siblings()) {
                if (oppositeVisited.contains(startS.val())) {
                    WordTransformerPathNode path1 = paths.get(currentStart.val());
                    WordTransformerPathNode path2 = paths.get(startS.val());
                    return merge(path1, path2);
                }
                queue.add(startS);
                visited.add(startS.val());
                WordTransformerPathNode prev = paths.get(currentStart.val());
                paths.put(startS.val(), prev);
            }
        }
        return List.of();
    }

    List<String> merge(WordTransformerPathNode start, WordTransformerPathNode stop) {
        List<String> result = new LinkedList<>();
        while (start != null) {
            result.addFirst(start.val());
            start = start.prev();
        }

        while(stop != null) {
            result.add(stop.val());
            stop = stop.prev();
        }

        return result;
    };

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

record WordTransformerPathNode(String val, WordTransformerPathNode prev) {}
