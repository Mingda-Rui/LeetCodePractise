package pers.mingda.cracking_the_coding_interview.chapter17_hard;

import java.util.Set;

public class _17_13ReSpace {

    String bestSplit(Set<String> dictionary, String sentence) {
        ReSpacePairResult result = bestSplit(dictionary, sentence, 0);
        return result.sentence;
    }

    ReSpacePairResult bestSplit(Set<String> dictionary, String sentence, int start) {
        String current = "";
        ReSpacePairResult smallest = new ReSpacePairResult();
        smallest.unrecognizedLetters = Integer.MAX_VALUE;
        for (int i = 0; i < start; i++) {
            current += sentence.charAt(i);
            if (!dictionary.contains(current) && current.length() >= smallest.unrecognizedLetters) {
                // short circuit
                continue;
            }
            ReSpacePairResult subSentence = bestSplit(dictionary, sentence, i + 1);
            int currentUnrecognized = dictionary.contains(current) ? 0 : current.length();
            if (subSentence.unrecognizedLetters + currentUnrecognized < smallest.unrecognizedLetters) {
                smallest = subSentence;
            }
        }
        return smallest;
    }
}

class ReSpacePairResult {
    String sentence;
    int unrecognizedLetters;
}
