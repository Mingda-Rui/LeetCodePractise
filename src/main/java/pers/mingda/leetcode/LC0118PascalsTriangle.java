package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC0118PascalsTriangle {

}

class LC0118Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> currentRow = Arrays.asList(1);
        result.add(currentRow);
        for (int i = 1; i < numRows; i++) {
            List<Integer> nextRow = generateNextRow(currentRow);
            currentRow = nextRow;
            result.add(currentRow);
        }

        return result;
    }

    private List<Integer> generateNextRow(List<Integer> currentRow) {
        List<Integer> nextRow = new ArrayList<>();
        nextRow.add(1);
        for (int i = 1; i < currentRow.size(); i++) {
            int item = currentRow.get(i - 1) + currentRow.get(i);
            nextRow.add(item);
        }
        nextRow.add(1);
        return nextRow;
    }
}
