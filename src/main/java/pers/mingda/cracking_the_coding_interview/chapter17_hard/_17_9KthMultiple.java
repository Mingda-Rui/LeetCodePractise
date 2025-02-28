package pers.mingda.cracking_the_coding_interview.chapter17_hard;

import java.util.ArrayList;
import java.util.List;

public class _17_9KthMultiple {
    int getKthMagicNumber(int k) {
        List<Integer> nums = new ArrayList<>();
        int factorOfThrees = 0;
        int factorOfFives = 0;
        int factorOfSevens = 0;
        nums.add(3);
        nums.add(5);
        nums.add(7);
        while (nums.size() < k) {
            int nextThree = nums.get(factorOfThrees) * 3;
            int nextFive = nums.get(factorOfFives) * 5;
            int nextSeven = nums.get(factorOfSevens) * 7;
            if (nextThree < nextFive && nextThree < nextSeven) {
                factorOfThrees++;
                nums.add(nextThree);
            } else if (nextFive < nextSeven && nextFive < nextThree) {
                factorOfFives++;
                nums.add(nextFive);
            } else {
                factorOfSevens++;
                nums.add(nextSeven);
            }
        }
        return nums.get(k - 1);
    }
}
