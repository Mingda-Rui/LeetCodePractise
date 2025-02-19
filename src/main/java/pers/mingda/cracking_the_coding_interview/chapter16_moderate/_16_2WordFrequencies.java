package pers.mingda.cracking_the_coding_interview.chapter16_moderate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _16_2WordFrequencies {

    private Map<String, Integer> cache = new HashMap<>();

    int getFrequency(String[] book, String word) {
        if (!cache.containsKey(word)) {
            long count = Arrays.stream(book).filter(s -> s.contains(word)).count();
            cache.put(word, Math.toIntExact(count));
        }
        return cache.get(word);
    }
}
