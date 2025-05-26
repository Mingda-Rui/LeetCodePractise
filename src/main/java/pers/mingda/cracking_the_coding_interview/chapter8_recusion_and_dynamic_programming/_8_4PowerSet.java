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
      for (ArrayList<Integer> subset : allSubsets) {
        ArrayList<Integer> newSubset = new ArrayList<>(subset);
        newSubset.add(item);
        moreSubsets.add(newSubset);
      }
      allSubsets.addAll(moreSubsets);
    }
    return allSubsets;
  }

  ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set) {
    ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<>();
    int max = 1 << set.size();/* Compute 2^n */
    for (int k = 0; k < max; k++) {
      ArrayList<Integer> subset = convertIntToSet(k, set);
      allSubsets.add(subset);
    }
    return allSubsets;
  }

  ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set) {
    ArrayList<Integer> subset = new ArrayList<>();
    int index = 0;
    for (int k = x; k > 0; k >>= 1) {
      if ((k & 1) == 1) {
        subset.add(set.get(index));
      }
      index++;
    }
    return subset;
  }
}
