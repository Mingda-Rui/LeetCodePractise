package pers.mingda.cracking_the_coding_interview.chapter8_recusion_and_dynamic_programming;

import java.util.ArrayList;

public class _8_4PowerSet {
    ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allSubsets;
        if (set.size() == index) { // Base case - add empty set
            allSubsets = new ArrayList<>();
            allSubsets.add(new ArrayList<>()); // Empty set
        } else {
            allSubsets = getSubsets(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<>();
            for (ArrayList<Integer> subset: allSubsets) {
                ArrayList<Integer> newSubset = new ArrayList<>();
                newSubset.addAll(subset);
                newSubset.add(item);
                moreSubsets.add(newSubset);
            }
            allSubsets.addAll(moreSubsets);
        }
        return allSubsets;
    }
}
