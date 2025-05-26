package pers.mingda.cracking_the_coding_interview.chapter17_hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _17_7BabyNames {
  Map<String, Integer> trulyMostPopular(Map<String, Integer> names, String[][] synonyms) {
    Map<String, Set<String>> synonymMap = buildSynonymMap(synonyms);
    return getTrulyMostPopular(names, synonymMap);
  }

  Map<String, Set<String>> buildSynonymMap(String[][] synonyms) {
    Map<String, Set<String>> synonymMap = new HashMap<>();
    for (String[] synonym : synonyms) {
      merge(synonym, synonymMap);
    }
    return synonymMap;
  }

  void merge(String[] synonym, Map<String, Set<String>> synonymMap) {
    String name1 = synonym[0];
    String name2 = synonym[1];

    Set<String> set1 = synonymMap.computeIfAbsent(name1, k -> new HashSet<>());
    Set<String> set2 = synonymMap.computeIfAbsent(name2, k -> new HashSet<>());
    set1.addAll(set2);

    for (String name : set1) {
      synonymMap.put(name, set1);
    }
  }

  Map<String, Integer> getTrulyMostPopular(
      Map<String, Integer> names, Map<String, Set<String>> synonymMap) {
    Map<String, Integer> trulyMostPopular = new HashMap<>();
    for (Set<String> synonyms : new HashSet<>(synonymMap.values())) {
      String trueName = synonyms.iterator().next();
      trulyMostPopular.put(trueName, synonyms.stream().mapToInt(names::get).sum());
    }
    return trulyMostPopular;
  }
}
