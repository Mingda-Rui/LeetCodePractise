package pers.mingda.crackingcodinginterview.chapter4treesandgraphs;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 *  4.7 Build Order: You are given a list of projects and a list of dependencies (which is a list of pairs of
 *  projects, where the second project is dependent on the first project). All of a project's dependencies
 *  must be built before the project is. Find a build order that will allow the projects to be built. If there
 *  is no valid build order, return an error.
 *  EXAMPLE
 *  Input:
 *    projects: a, b, c, d, e, f
 *    dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
 *  Output: f, e, a, b, d, c
 */

public class _4_7BuildOrder {
    public static String[] findBuildOrder(String[] projects, String[][] dependencies) {
        Map<String, Integer> blockerTable = new HashMap<>();
        Map<String, Set<String>> dependentTable = new HashMap<>();


        for (String[] dependency: dependencies) {
            String first = dependency[0];
            String second = dependency[1];
            int numOfBlockers = blockerTable.computeIfAbsent(second, k -> 0);
            blockerTable.put(second, numOfBlockers + 1);
            dependentTable.computeIfAbsent(first, dependent -> new HashSet<>()).add(second);
        }

        Queue<String> readyProjects = new LinkedList<>();
        for (String project: projects)
            if (!blockerTable.containsKey(project))
                readyProjects.add(project);

        List<String> result = new LinkedList<>();
        while (!readyProjects.isEmpty()) {
            String project = readyProjects.remove();
            result.add(project);

            for (String dependent: dependentTable.getOrDefault(project, Collections.emptySet())) {

                int numOfBlockers = blockerTable.computeIfPresent(dependent, (k, v) -> v - 1);
                if (numOfBlockers == 0) {
                    readyProjects.add(dependent);
                    blockerTable.remove(dependent);
                }
            }

        }

        if (!blockerTable.isEmpty()) {
            throw new RuntimeException("Loop dependencies found!");
        }

        return result.toArray(String[]::new);
    }

    private static final int UNPROCESSED = 0;
    private static final int PROCESSING = 1;
    private static final int PROCESSED = 2;

    public static String[] findBuildOrderDfs(String[] projects, String[][]dependencies) {
        List<String> result = new LinkedList<>();
        Map<String, Integer> processed = new HashMap<>();
        Map<String, Set<String>> blockerTable = new HashMap<>();
        for (String[] dependency: dependencies) {
            String blocker = dependency[0];
            String project = dependency[1];
            Set<String> blockers = blockerTable.computeIfAbsent(project, p -> new HashSet<>());
            blockers.add(blocker);
        }
        for (String project: projects) {
            if (!findBuildOrderDfs(project, result, processed, blockerTable))
                throw new RuntimeException("Loop dependencies found!");
        }

        return result.toArray(String[]::new);
    }

    private static boolean findBuildOrderDfs(String project, List<String> result, Map<String, Integer> processed, Map<String, Set<String>> blockerTable) {
        int processStatus = processed.getOrDefault(project, UNPROCESSED);
        if (processStatus == PROCESSED)
            return true;
        if (processStatus == PROCESSING)
            return false;
        processed.put(project, PROCESSING);
        for (String blocker: blockerTable.getOrDefault(project, Collections.emptySet())) {
            if (!findBuildOrderDfs(blocker, result, processed, blockerTable))
                return false;
        }
        processed.put(project, PROCESSED);
        result.add(project);
        return true;
    }


}
