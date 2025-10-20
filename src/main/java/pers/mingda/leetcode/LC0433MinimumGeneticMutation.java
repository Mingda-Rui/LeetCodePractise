package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC0433MinimumGeneticMutation {}

class LC0433Solution {

  public int minMutation(String startGene, String endGene, String[] bank) {
    Map<String, Set<String>> mutationMap = buildMutationMap(startGene, bank);
    Set<String> seenGenes = new HashSet<>();
    return findMutation(startGene, endGene, mutationMap, seenGenes);
  }

  private int findMutation(
    String startGene,
    String endGene,
    Map<String, Set<String>> mutationMap,
    Set<String> seenGenes
  ) {
    if (startGene.equals(endGene)) {
      return 0;
    }
    int min = Integer.MAX_VALUE;
    for (String mutation : mutationMap.get(startGene)) {
      if (seenGenes.contains(mutation)) {
        continue;
      }
      seenGenes.add(mutation);
      int localMin = findMutation(mutation, endGene, mutationMap, seenGenes);

      seenGenes.remove(mutation);
      if (localMin != -1) {
        min = Math.min(min, localMin);
      }
    }
    return min == Integer.MAX_VALUE ? -1 : min + 1;
  }

  private Map<String, Set<String>> buildMutationMap(String startGene, String[] bank) {
    Map<String, Set<String>> map = new HashMap<>();
    Set<String> geneBank = new HashSet<>(Arrays.asList(bank));
    geneBank.add(startGene);
    for (String gene : geneBank) {
      if (map.containsKey(gene)) {
        continue;
      }
      Set<String> mutations = new HashSet<>();
      for (String mutation : bank) {
        if (isMutation(gene, mutation)) {
          mutations.add(mutation);
        }
      }
      map.put(gene, mutations);
    }
    return map;
  }

  private boolean isMutation(String startGene, String mutatedGene) {
    int diffCount = 0;
    if (startGene.length() != mutatedGene.length()) {
      return false;
    }
    for (int i = 0; i < startGene.length(); i++) {
      if (startGene.charAt(i) != mutatedGene.charAt(i)) {
        diffCount++;
      }
      if (diffCount > 1) {
        return false;
      }
    }
    return diffCount == 1;
  }
}
