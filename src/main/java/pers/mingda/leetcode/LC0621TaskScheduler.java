package pers.mingda.leetcode;

public class LC0621TaskScheduler {

}

class LC0621Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] lettersFreq = new int[26];
        int maxFreq = 0;
        char maxFreqLetter = ' ';
        for (char l: tasks) {
            int letterIndex = l - 'A';
            lettersFreq[letterIndex]++;
            if (lettersFreq[letterIndex] > maxFreq) {
                maxFreq = lettersFreq[letterIndex];
                maxFreqLetter = l;
            }
        }

        int idleSlots = (maxFreq - 1) * n;
        for (int i = 0; i < lettersFreq.length; i++) {
            char l = (char)('A' + i);
            if (l == maxFreqLetter)
                continue;
            int freq = lettersFreq[i];
            int filledIdleSlot = Math.min(maxFreq - 1, freq);
            idleSlots -= filledIdleSlot;
        }
        idleSlots = Math.max(0, idleSlots);
        return tasks.length + idleSlots;
    }
}