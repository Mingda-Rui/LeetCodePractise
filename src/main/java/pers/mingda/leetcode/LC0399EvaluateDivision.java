package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.math3.util.Pair;

public class LC0399EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Pair<String, Double>>> equationMap = recordEquations(equations, values);
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            result[i] = findResult(equationMap, query.getFirst(), query.getLast(), new HashSet<>());
        }
        return result;
    }

    private Map<String, List<Pair<String, Double>>> recordEquations(List<List<String>> equations, double[] values) {
        Map<String, List<Pair<String, Double>>> equationMap = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            recordEquation(equationMap, equation.getFirst(), equation.getLast(), values[i]);
        }
        return equationMap;
    }

    private double findResult(Map<String, List<Pair<String, Double>>> equationMap, String current, String target, Set<String> seen) {
        if (!equationMap.containsKey(current) || !equationMap.containsKey(target)) {
            return -1;
        }
        if (current.equals(target)) {
            return 1;
        }
        seen.add(current);
        for (Pair<String, Double> nextPair : equationMap.get(current)) {
            String next = nextPair.getKey();
            double nextVal = nextPair.getValue();
            if (next.equals(target)) {
                return nextVal;
            }
            if (!seen.contains(next) && nextVal != -1) {
                double result = findResult(equationMap, next, target, seen);
                if (result != -1) {
                    result *= nextVal;
                    recordEquation(equationMap, current, target, result);
                    return result;
                }
            }
        }
        recordEquation(equationMap, current, target, -1);
        return -1;
    }

    private void recordEquation(Map<String, List<Pair<String, Double>>> equationMap, String current, String target, double result) {
        equationMap.computeIfAbsent(current, (k) -> new ArrayList<>()).add(new Pair<>(target,result));
        equationMap.computeIfAbsent(target, (k) -> new ArrayList<>()).add(new Pair<>(current, 1 / result));
    }
}
