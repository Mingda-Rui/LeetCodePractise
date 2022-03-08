package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class LC0056MergeIntervals {

    /**
     * O(n), iterate three times.
     * @param intervals
     * @return
     */
    public int[][] merge_v1(int[][] intervals) {
        if (intervals.length == 0) return intervals;
        int length = 3000;
        int[] lefts = new int[length];
        int[] rights = new int[length];

        for (int[] interval : intervals) {
            lefts[interval[0]]++;
            rights[interval[1]]++;
        }

        int offset = 0;
        int resultLength = 0;
        for (int i = 0; i < length; i++) {
            if (lefts[i] != 0) {
                int originalOffset = offset;
                offset += lefts[i];
                if (originalOffset != 0) lefts[i] = 0;
            }
            if (rights[i] != 0) {
                offset -= rights[i];
                if (offset != 0) rights[i] = 0;
                else resultLength++;
            }
        }

        int[][] result = new int[resultLength][2];
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (lefts[i] != 0) result[index][0] = i;
            if (rights[i] != 0) {
                result[index][1] = i;
                index++;
            }
        }
        return result;
    }

    /**
     * Compared to the first version, use a LinkedList, iterate twice,
     * but slower and use more memory
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return intervals;
        int length = 3000;
        int[] lefts = new int[length];
        int[] rights = new int[length];

        for (int[] interval : intervals) {
            lefts[interval[0]]++;
            rights[interval[1]]++;
        }

        int offset = 0;
        int previousLegitStart = 0;
        LinkedList<int[]> merged = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            if (lefts[i] != 0) {
                int originalOffset = offset;
                offset += lefts[i];
                if (originalOffset != 0) lefts[i] = 0;
                else previousLegitStart = i;
            }
            if (rights[i] != 0) {
                offset -= rights[i];
                if (offset != 0) rights[i] = 0;
                else merged.add(new int[]{previousLegitStart, i});
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String ... args) {
        LC0056MergeIntervals test = new LC0056MergeIntervals();
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");


        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(2);
    }


}
