package pers.mingda.cracking_the_coding_interview.chapter8_recusion_and_dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class _8_7PermutationsWithoutDups {
  public List<String> permutationsWithoutDups(String str) {
    if (str.isEmpty() || str.length() == 1) {
      return List.of(str);
    }

    List<String> allPermutations = new ArrayList<>();
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      StringBuilder sb = new StringBuilder(str);
      sb.deleteCharAt(i);
      List<String> partialP =
          permutationsWithoutDups(sb.toString()).stream().map(p -> c + p).toList();
      allPermutations.addAll(partialP);
    }
    return allPermutations;
  }
}
