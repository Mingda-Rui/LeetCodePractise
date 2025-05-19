package pers.mingda.leetcode;

import java.util.Arrays;

public class LC2300SuccessfulPairsOfSpellsAndPotions {
}

class LC2300Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        reverse(potions);
        int[] result = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            result[i] = findSuccess(spells[i], potions, success);
        }
        return result;
    }

    private void reverse(int[] array) {
        int len = array.length;
        for (int i = 0; i < (len + 1) / 2; i++) {
            int opposite = len - 1 - i;
            int tmp = array[i];
            array[i] = array[opposite];
            array[opposite] = tmp;
        }
    }

    private int findSuccess(double spell, int[] potions, long success) {
        int head = 0;
        int tail = potions.length;
        while (head + 1 < tail) {
            int mid = (head + tail) / 2;
            if ((long) potions[mid] * spell < success) {
                tail = mid;
            } else {
                head = mid;
            }
        }

        return (long) potions[head] * spell >= success ? head + 1 : head;
    }
}
