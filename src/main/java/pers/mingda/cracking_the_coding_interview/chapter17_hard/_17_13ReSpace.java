package pers.mingda.cracking_the_coding_interview.chapter17_hard;

import java.util.Set;

public class _17_13ReSpace {

    int bestSplit(Set<String> dictionary, String sentence) {
        return bestSplit(dictionary, sentence, 0, 0);
    }

    int bestSplit(Set<String> dictionary, String sentence, int start, int unRecognized) {
        if (start == sentence.length()) {
            return unRecognized;
        }
        String word = findNextWord(dictionary, sentence, start);
        int smallestUnRecognized = Integer.MAX_VALUE;
        if (word.isEmpty()) {
            int newUnRecognized = unRecognized + (sentence.length() - start);
            smallestUnRecognized = Math.min(smallestUnRecognized, newUnRecognized);
        } else {
            int newUnRecognized2 = bestSplit(dictionary, sentence, start + word.length(), unRecognized);
            smallestUnRecognized = Math.min(smallestUnRecognized, newUnRecognized2);
        }
        int newUnRecognized3 = bestSplit(dictionary, sentence, start + 1, unRecognized + 1);
        smallestUnRecognized = Math.min(smallestUnRecognized, newUnRecognized3);
        return smallestUnRecognized;
    }

    String findNextWord(Set<String> dictionary, String sentence, int start) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < sentence.length(); i++) {
            sb.append(sentence.charAt(i));
            String current = sb.toString();
            if (dictionary.contains(current)) {
                return current;
            }
        }
        return "";
    }
}
