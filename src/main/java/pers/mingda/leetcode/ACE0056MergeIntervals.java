package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.LinkedList;

public class ACE0056MergeIntervals {

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
        int[][] test = {{362,367},{314,315},{133,138},{434,443},{202,203},{144,145},{229,235},{205,212},{314,323},{128,129},{413,414},{342,345},{43,49},{333,342},{173,178},{386,391},{131,133},{157,163},{187,190},{186,186},{17,19},{63,69},{70,79},{386,391},{98,102},{236,239},{195,195},{338,338},{169,170},{151,153},{409,416},{377,377},{90,96},{156,165},{182,186},{371,372},{228,233},{297,306},{56,61},{184,190},{401,403},{221,228},{203,212},{39,43},{83,84},{66,68},{80,83},{32,32},{182,182},{300,306},{235,238},{267,272},{458,464},{114,120},{452,452},{372,375},{275,280},{302,302},{5,9},{54,62},{237,237},{432,439},{415,421},{340,347},{356,358},{165,168},{15,17},{259,265},{201,204},{192,197},{376,383},{210,211},{362,367},{481,488},{59,64},{307,315},{155,164},{465,467},{55,60},{20,24},{297,304},{207,210},{322,328},{139,142},{192,195},{28,36},{100,108},{71,76},{103,105},{34,38},{439,441},{162,168},{433,433},{368,369},{137,137},{105,112},{278,280},{452,452},{131,132},{475,480},{126,129},{95,104},{93,99},{394,403},{70,78}};
        ACE0056MergeIntervals mi = new ACE0056MergeIntervals();
        int[][] result = mi.merge(test);
        System.out.println(Arrays.deepToString(result));
    }
}
