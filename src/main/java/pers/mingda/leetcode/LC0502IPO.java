package pers.mingda.leetcode;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LC0502IPO {}

class LC0502Solution {

  public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
    // k! = k * (k - 1) * ... * 1
    LinkedList<Integer> rankedByProfits = rankByProfits(profits);
    while (k != 0) {
      int p = findNextMostProfitableProjectByCapital(w, rankedByProfits, capital);
      k--;
      if (p == -1 || profits[p] == 0) {
        break;
      }
      w += profits[p];
    }
    return w;
  }

  private LinkedList<Integer> rankByProfits(int[] profits) {
    Comparator<Integer> profitComparator = Comparator.comparingInt(i -> profits[i]);
    return IntStream.range(0, profits.length)
      .boxed()
      .sorted(profitComparator.reversed())
      .collect(Collectors.toCollection(LinkedList::new));
  }

  private int findNextMostProfitableProjectByCapital(
    int w,
    LinkedList<Integer> rankedByProfits,
    int[] capital
  ) {
    Iterator<Integer> it = rankedByProfits.iterator();
    while (it.hasNext()) {
      int p = it.next();
      if (!isEnoughCapitalForProject(p, w, capital)) {
        continue;
      }
      it.remove();
      return p;
    }
    return -1;
  }

  private boolean isEnoughCapitalForProject(int p, int w, int[] capital) {
    return w >= capital[p];
  }
}
