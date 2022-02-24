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
        Map<String, Set<String>> blockerTable = new HashMap<>();
        Map<String, Set<String>> dependentTable = new HashMap<>();


        for (String[] dependency: dependencies) {
            String first = dependency[0];
            String second = dependency[1];
            blockerTable.computeIfAbsent(second, blocker -> new HashSet<>()).add(first);
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

                if (blockerTable.containsKey(dependent)) {
                    Set<String> blockers = blockerTable.get(dependent);
                    blockers.remove(project);
                    if (blockers.isEmpty()) {
                        readyProjects.add(dependent);
                        blockerTable.remove(dependent);
                    }
                }
            }

        }

        return result.toArray(String[]::new);
    }
}
