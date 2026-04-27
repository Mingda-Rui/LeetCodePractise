package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class LC0721AccountsMerge {
}

class LC0721Solution {
  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    Map<String, List<Integer>> emailToAccount = new HashMap<>();
    for (int i = 0; i < accounts.size(); i++) {
      List<String> account = accounts.get(i);
      for (int j = 1; j < account.size(); j++) {
        String email = account.get(j);
        emailToAccount.computeIfAbsent(email, e -> new ArrayList<>()).add(i);
      }
    }

    int[] remainingAccounts = new int[accounts.size()];
    List<List<String>> result = new ArrayList<>();
    for (int i = 0; i < accounts.size(); i++) {
      if (remainingAccounts[i] != 0) {
        continue;
      }

      List<String> mergedAccount = mergeAccount(accounts, remainingAccounts, i, emailToAccount);
      result.add(mergedAccount);
    }
    return result;
  }

  private List<String> mergeAccount(List<List<String>> accounts, int[] remainingAccounts, int accountIndex, Map<String, List<Integer>> emailToAccount) {
    Set<String> mergedAccount = new HashSet<>();
    String name = "";

    Queue<Integer> queue = new LinkedList<>();
    queue.add(accountIndex);
    while (!queue.isEmpty()) {
      int current = queue.remove();
      if (remainingAccounts[current] != 0) {
        continue;
      }
      remainingAccounts[current] = 1;
      List<String> account = accounts.get(current);
      List<String> emails = account.subList(1, account.size());
      name = account.get(0);
      mergedAccount.addAll(emails);
      for (String email : emails) {
        queue.addAll(emailToAccount.get(email));
      }
    }

    List<String> result = new ArrayList<>();
    result.add(name);
    result.addAll(mergedAccount.stream().sorted().toList());
    return result;
  }
}

class LC0721UnionFindSolution {
  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    LC0721UnionFind uf = new LC0721UnionFind(accounts.size());

    Map<String, Integer> emailToAccountIndex = new HashMap<>();
    for (int i = 0; i < accounts.size(); i++) {
      List<String> account = accounts.get(i);
      for (int j = 1; j < account.size(); j++) {
        String email = account.get(j);
        if (emailToAccountIndex.containsKey(email)) {
          uf.union(emailToAccountIndex.get(email), i);
        } else {
          emailToAccountIndex.put(email, i);
        }
      }
    }

    Map<Integer, List<String>> mergedEmails = new HashMap<>();
    for (String email : emailToAccountIndex.keySet()) {
      int group = uf.find(emailToAccountIndex.get(email));
      mergedEmails.computeIfAbsent(group, g -> new LinkedList<>()).add(email);
    }

    List<List<String>> result = new ArrayList<>();
    for (int group : mergedEmails.keySet()) {
      List<String> emails = mergedEmails.get(group);
      Collections.sort(emails);
      String name = accounts.get(group).get(0);
      emails.addFirst(name);
      result.add(emails);
    }
    return result;
  }
}

class LC0721UnionFind {

  private final int[] groups;
  private final int[] sizes;

  public LC0721UnionFind(int size) {
    this.groups = new int[size];
    this.sizes = new int[size];
    for (int i = 0; i < size; i++) {
      groups[i] = i;
      sizes[i] = 1;
    }
  }

  public void union(int group1, int group2) {
    int parent1 = find(group1);
    int parent2 = find(group2);
    if (parent1 == parent2) {
      return;
    }
    if (sizes[parent1] > sizes[parent2]) {
      sizes[parent1] += sizes[parent2];
      groups[parent2] = parent1;
    } else {
      sizes[parent2] += sizes[parent1];
      groups[parent1] = parent2;
    }
  }

  public int find(int group) {
    if (group == groups[group]) {
      return group;
    }
    groups[group] = find(groups[group]);
    return groups[group];
  }
}