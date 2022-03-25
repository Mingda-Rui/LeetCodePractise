package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LC0207CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> preMap = new HashMap<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] prerequisite: prerequisites) {
            int first = prerequisite[1];
            int second = prerequisite[0];
            preMap.putIfAbsent(first, new HashSet<>());
            preMap.putIfAbsent(second, new HashSet<>());
            preMap.get(first).add(second);

            map.putIfAbsent(second, new HashSet<>());
            map.putIfAbsent(first, new HashSet<>());
            map.get(second).add(first);
        }
        int totalNum = map.size();

        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Set<Integer>> entry: map.entrySet()) {
            if (entry.getValue().isEmpty())
                queue.add(entry.getKey());
        }

        while (!queue.isEmpty()) {
            int preCourse = queue.remove();
            totalNum--;
            for (int course: preMap.get(preCourse)) {
                Set<Integer> preCourses = map.get(course);
                preCourses.remove(preCourse);
                if (preCourses.isEmpty())
                    queue.add(course);

            }
        }

        return totalNum == 0;
    }
}
