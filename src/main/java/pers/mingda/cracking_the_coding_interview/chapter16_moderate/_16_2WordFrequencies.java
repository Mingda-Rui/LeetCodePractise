package pers.mingda.cracking_the_coding_interview.chapter16_moderate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _16_2WordFrequencies {

    private final Map<String, Integer> cache = new HashMap<>();

    int getFrequency(String[] book, String word) {
        String trimmedWord = word.trim().toLowerCase();
        if (!cache.containsKey(trimmedWord)) {
            long count = Arrays.stream(book).filter(s -> s.toLowerCase().contains(trimmedWord)).count();
            cache.put(trimmedWord, Math.toIntExact(count));
        }
        return cache.get(trimmedWord);
    }
}
