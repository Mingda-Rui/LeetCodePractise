package pers.mingda.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC1337TheKWeakestRowsInAMatrix {
}


class LC1337Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        Queue<LC1337Weakness> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < mat.length; i++) {
            queue.add(getWeakness(mat[i], i));
            if (queue.size() > k) {
                queue.remove();
            }
        }

        int[] result = new int[k];
        for (int j = k - 1; j >= 0 ; j--) {
            result[j] = queue.remove().row();
        }

        return result;
    }

    private LC1337Weakness getWeakness(int[] row, int rowNum) {
        return new LC1337Weakness(countSoldiers(row), rowNum);
    }

    private int countSoldiers(int[] row) {
        int count = 0;
        for (int person : row) {
            count += person;
            if (person == 0) {
                break;
            }
        }
        return count;
    }
}

record LC1337Weakness(int soldiers, int row) implements Comparable<LC1337Weakness>{
    @Override
    public int compareTo(LC1337Weakness weakness) {
        if (this.soldiers != weakness.soldiers) {
            return this.soldiers < weakness.soldiers ? -1 : 1;
        }
        if (this.row == weakness.row) {
            return 0;
        }
        return this.row < weakness.row ? -1 : 1;
    }
}

class LC1337SolutionVerticalIteration {
    public int[] kWeakestRows(int[][] mat, int k) {
        int resultIndex = 0;
        int[] result = new int[k];
        for (int j = 0; j < mat[0].length; j++) {
            for (int i = 0; i < mat.length; i++) {
                if (mat[i][j] == 0 && (j == 0 || mat[i][j - 1] == 1)) {
                    result[resultIndex] = i;
                    resultIndex++;
                    if (resultIndex == k) {
                        return result;
                    }
                }
            }
        }

        for (int i = 0; i < mat.length; i++) {
            if (mat[i][mat[0].length - 1] == 1) {
                result[resultIndex] = i;
                resultIndex++;
                if (resultIndex == k) {
                    return result;
                }
            }
        }

        return result;
    }
}