package pers.mingda.cracking_the_coding_interview.chapter16_moderate;

import java.util.Arrays;

public class _16_2WordFrequencies {
    int getFrequency(String[] book, String word) {
        long count = Arrays.stream(book).filter(s -> s.contains(word)).count();
        return Math.toIntExact(count);
    }
}
