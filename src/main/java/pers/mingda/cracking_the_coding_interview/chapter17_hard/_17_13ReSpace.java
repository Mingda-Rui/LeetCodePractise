package pers.mingda.cracking_the_coding_interview.chapter17_hard;

import java.util.Set;

public class _17_13ReSpace {

    String bestSplit(Set<String> dictionary, String sentence) {
        ReSpacePairResult result = bestSplit(dictionary, sentence, 0);
        return result.sentence;
    }

    ReSpacePairResult bestSplit(Set<String> dictionary, String sentence, int start) {
        if (start == sentence.length()) {
            return new ReSpacePairResult("", 0);
        }
        String current = "";
        ReSpacePairResult smallest = new ReSpacePairResult("", Integer.MAX_VALUE);
        for (int i = 0; i < start; i++) {
            current += sentence.charAt(i);
            int currentUnrecognized = dictionary.contains(current) ? 0 : current.length();
            if (currentUnrecognized >= smallest.unrecognizedLetters) {
                // short circuit
                continue;
            }
            ReSpacePairResult subSentence = bestSplit(dictionary, sentence, i + 1);
            if (subSentence.unrecognizedLetters + currentUnrecognized < smallest.unrecognizedLetters) {
                int newUnrecognized = currentUnrecognized + smallest.unrecognizedLetters;
                String newSentence = current + " " + smallest.sentence;
                smallest = new ReSpacePairResult(newSentence, newUnrecognized);
            }
            if (smallest.unrecognizedLetters == 0) {
                // short circuit
                break;
            }
        }
        return smallest;
    }
}

class ReSpacePairResult {
    String sentence;
    int unrecognizedLetters;

    public ReSpacePairResult(String sentence, int unrecognizedLetters) {
        this.sentence = sentence;
        this.unrecognizedLetters = unrecognizedLetters;
    }
}
