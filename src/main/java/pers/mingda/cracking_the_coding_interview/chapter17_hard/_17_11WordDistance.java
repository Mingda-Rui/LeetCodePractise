package pers.mingda.cracking_the_coding_interview.chapter17_hard;

public class _17_11WordDistance {
    int findClosest(String[] words, String word1, String word2) {
        int prevWord1Index = -1;
        int prevWord2Index = -1;
        int smallestDistance = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.equals(word1)) {
                prevWord1Index = i;
            } else if (word.equals(word2)) {
                prevWord2Index = i;
            }
            if (prevWord1Index != -1 && prevWord2Index != -1) {
                smallestDistance = Math.min(smallestDistance, Math.abs(prevWord1Index - prevWord2Index));
            }
        }
        return smallestDistance == Integer.MAX_VALUE ? -1 : smallestDistance;
    }
}
