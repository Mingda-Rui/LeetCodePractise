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
        for (Employee employee: employees) {
            map.put(employee.id, employee);
            if (employee.id == id)
                queue.add(employee);
        }
        int totalImportance = 0;
        while (!queue.isEmpty()) {
            Employee employee = queue.remove();
            totalImportance += employee.importance;
            for (int subId: employee.subordinates) {
                Employee sub = map.get(subId);
                queue.add(sub);
            }
        }
        return totalImportance;
    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}
