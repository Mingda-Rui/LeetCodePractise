package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LC0690EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        Queue<Employee> queue = new LinkedList<>();
        for (Employee employee : employees) map.put(employee.id, employee);
        int totalImportance = 0;
        Employee theBoss = map.get(id);
        queue.add(theBoss);
        while (!queue.isEmpty()) {
            Employee employee = queue.remove();
            totalImportance += employee.importance;
            for (int subId : employee.subordinates) {
                Employee sub = map.get(subId);
                queue.add(sub);
            }
        }
        return totalImportance;
    }

    public int getImportanceDfs(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) map.put(employee.id, employee);
        return getImportanceDfsHelper(map, id);
    }

    private int getImportanceDfsHelper(Map<Integer, Employee> map, int id) {
        Employee employee = map.get(id);
        int totalImportance = employee.importance;
        for (int subId : employee.subordinates) totalImportance += getImportanceDfsHelper(map, subId);
        return totalImportance;
    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}
