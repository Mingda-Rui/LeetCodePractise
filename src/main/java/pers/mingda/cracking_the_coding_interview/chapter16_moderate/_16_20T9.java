package pers.mingda.cracking_the_coding_interview.chapter16_moderate;

import java.util.*;

public class _16_20T9 {
    List<String> getValidT9Words(String number, Set<String> wordList) {
        Map<String, List<String>> wordMap = buildWordMap(wordList);
        return wordMap.getOrDefault(number, List.of());
    }

    Map<String, List<String>> buildWordMap(Set<String> wordList) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : wordList) {
            String digits = toDigits(word);
            map.putIfAbsent(digits, new ArrayList<>());
            map.computeIfAbsent(digits, this::createList).add(word);
        }
        return map;
    }

    List<String> createList(String d) {
        return new ArrayList<>();
    }

    String toDigits(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            sb.append(toDigit(c));
        }
        return sb.toString();
    }

    char toDigit(char c) {
        return lettersT9[c - 'a'];
    }

    /* Mapping of letters to digits. */
    char[] lettersT9 = {'2', '2', '2',
            '3', '3', '3',
            '4', '4', '4',
            '5', '5', '5',
            '6', '6', '6',
            '7', '7', '7', '7',
            '8', '8', '8',
            '9', '9', '9', '9'};
}
