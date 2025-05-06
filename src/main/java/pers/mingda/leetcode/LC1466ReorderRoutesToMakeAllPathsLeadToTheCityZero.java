package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LC1466ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] connection: connections) {
            mapConnection(connection, map);
        }

        int result = 0;
        Set<List<Integer>> connectionSet =
                Arrays.stream(connections)
                        .map(arr -> Arrays.stream(arr).boxed().toList())
                        .collect(Collectors.toSet());
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        Set<Integer> seenCities = new HashSet<>();
        seenCities.add(0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int city = queue.remove();
                for (int dest: map.get(city)) {
                    if (seenCities.contains(dest)) {
                        continue;
                    }
                    seenCities.add(dest);
                    queue.offer(dest);
                    if (!connectionSet.contains(List.of(dest, city))) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    private void mapConnection(int[] connection, Map<Integer, Set<Integer>> map) {
        int origin = connection[0];
        int dest = connection[1];
        map.computeIfAbsent(origin, computeEmptySet()).add(dest);
        map.computeIfAbsent(dest, computeEmptySet()).add(origin);
    }

    private Function<Integer, Set<Integer>> computeEmptySet() {
        return (key) -> new HashSet<>();
    }
}