package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LC0734SentenceSimilarity {

}

class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length)
            return false;
        Map<String, Set<String>> similarMap = buildSimilarMap(similarPairs);
        for (int i = 0; i < sentence1.length; i++) {
            String word1 = sentence1[i];
            String word2 = sentence2[i];
            if (!word1.equals(word2))
                if (!similarMap.containsKey(word1) || !similarMap.get(word1).contains(word2))
                    return false;
        }
        return true;
    }


    private Map<String, Set<String>> buildSimilarMap(List<List<String>> similarPairs) {
        Map<String, Set<String>> similarMap = new HashMap<>();
        for (List<String> similarPair: similarPairs) {
            String word1 = similarPair.get(0);
            String word2 = similarPair.get(1);
            similarMap.putIfAbsent(word1, new HashSet<>());
            similarMap.get(word1).add(word2);
            similarMap.putIfAbsent(word2, new HashSet<>());
            similarMap.get(word2).add(word1);
        }
        return similarMap;
    }
}
