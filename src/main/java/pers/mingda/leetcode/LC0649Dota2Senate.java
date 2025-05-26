package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class LC0649Dota2Senate {

  public String predictPartyVictory(String senate) {
    Queue<Character> queue = new LinkedList<>();
    int rCount = 0;
    int dCount = 0;
    for (char individualSenate : senate.toCharArray()) {
      queue.offer(individualSenate);
      if (individualSenate == 'R') {
        rCount++;
      } else {
        dCount++;
      }
    }

    int pendingRBan = 0;
    int pendingDBan = 0;
    while (rCount != 0 && dCount != 0 && !queue.isEmpty()) {
      char nextSenate = queue.poll();
      if (nextSenate == 'R' && pendingRBan == 0) {
        pendingDBan++;
        queue.offer(nextSenate);
      } else if (nextSenate == 'D' && pendingDBan == 0) {
        pendingRBan++;
        queue.offer(nextSenate);
      } else if (nextSenate == 'R') {
        rCount--;
        pendingRBan--;
      } else if (nextSenate == 'D') {
        dCount--;
        pendingDBan--;
      }
    }
    return rCount == 0 ? "Dire" : "Radiant";
  }
}
