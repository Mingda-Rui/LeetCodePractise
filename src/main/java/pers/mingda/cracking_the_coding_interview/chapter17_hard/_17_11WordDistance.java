package pers.mingda.cracking_the_coding_interview.chapter17_hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

  int findClosestReusable(String[] words, String word1, String word2) {
    Map<String, List<Integer>> wordLocMap = buildWordMap(words);
    return findClosest(wordLocMap, word1, word2);
  }

  Map<String, List<Integer>> buildWordMap(String[] words) {
    Map<String, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      List<Integer> wordHistory = map.computeIfAbsent(word, w -> new ArrayList<>());
      wordHistory.add(i);
    }
    return map;
  }

  int findClosest(Map<String, List<Integer>> wordLocMap, String word1, String word2) {
    if (!wordLocMap.containsKey(word1) || !wordLocMap.containsKey(word2)) {
      return -1;
    }
    List<Integer> wordLocs1 = wordLocMap.get(word1);
    List<Integer> wordLocs2 = wordLocMap.get(word2);

    int index1 = 0;
    int index2 = 0;
    int smallestDistance = Integer.MAX_VALUE;
    while (index1 < wordLocs1.size() && index2 < wordLocs2.size()) {
      int wordLoc1 = wordLocs1.get(index1);
      int wordLoc2 = wordLocs2.get(index2);
      smallestDistance = Math.min(smallestDistance, Math.abs(wordLoc1 - wordLoc2));
      if (wordLoc1 < wordLoc2) {
        index1++;
      } else {
        index2++;
      }
    }
    return smallestDistance;
  }
}
