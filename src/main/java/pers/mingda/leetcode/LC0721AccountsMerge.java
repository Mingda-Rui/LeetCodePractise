package pers.mingda.leetcode;

import java.util.ArrayList;
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