package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class LC2300SuccessfulPairsOfSpellsAndPotions {
}

class LC2300Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);

        int[] result = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            result[i] = findSuccess(potions, (long) Math.ceil(1.0 * success / spells[i]));
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

    private int findSuccess(int[] potions, long success) {
        if (potions[potions.length - 1] < success) {
            return 0;
        }
        int head = 0;
        int tail = potions.length - 1;
        while (head < tail) {
            int mid = (head + tail) / 2;
            if (potions[mid] < success) {
                head = mid + 1;
            } else {
                tail = mid;
            }
        }

        return potions.length - head;
    }
}

class LC2300SlidingWindowSolution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[][] sortedSpells = new int[spells.length][2];
        for (int i = 0; i < spells.length; i++) {
            sortedSpells[i][0] = spells[i];
            sortedSpells[i][1] = i;
        }
        Arrays.sort(sortedSpells, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(potions);

        int[] result = new int[spells.length];
        int potionIndex = potions.length - 1;
        for (int[] sortedSpell : sortedSpells) {
            long spell = (long) sortedSpell[0];
            int resultIndex = sortedSpell[1];

            while (potionIndex >= 0 && (long) spell * potions[potionIndex] >= success) {
                potionIndex--;
            }
            result[resultIndex] = potions.length - potionIndex - 1;
        }
        return result;
    }
}
