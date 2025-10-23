package pers.mingda.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LC0433MinimumGeneticMutation {}

class LC0433Solution {

  public int minMutation(String startGene, String endGene, String[] bank) {
    Set<String> seenGenes = new HashSet<>();
    Queue<String> queue = new LinkedList<>();
    queue.add(startGene);

    int step = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String next = queue.remove();
        if (seenGenes.contains(next)) {
          continue;
        }
        if (next.equals(endGene)) {
          return step;
        }
        seenGenes.add(next);
        for (String geneInBank : bank) {
          if (!seenGenes.contains(geneInBank) && isMutation(next, geneInBank)) {
            queue.add(geneInBank);
          }
        }
      }
      step++;
    }
    return -1;
  }

  private boolean isMutation(String gene1, String gene2) {
    if (gene1.length() != gene2.length()) {
      return false;
    }
    int diffCount = 0;
    for (int i = 0; i < gene1.length(); i++) {
      if (gene1.charAt(i) != gene2.charAt(i)) {
        diffCount++;
      }
      if (diffCount > 1) {
        return false;
      }
    }
    return diffCount == 1;
  }
}
