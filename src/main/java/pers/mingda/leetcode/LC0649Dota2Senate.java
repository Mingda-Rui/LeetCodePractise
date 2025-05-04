package pers.mingda.leetcode;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class LC0649Dota2Senate {
    public String predictPartyVictory(String senate) {
        Optional<String> winner = findWinner(senate);
        while(winner.isEmpty()) {
            senate = vote(senate);
            winner = findWinner(senate);
        }
        return winner.orElseThrow();
    }

    private Optional<String> findWinner(String senate) {
        char party = senate.charAt(0);
        for (char c : senate.toCharArray()) {
            if (c != party) {
                return Optional.empty();
            }
        }
        String winner = party == 'R' ? "Radiant" : "Dire";
        return Optional.of(winner);
    }

    private String vote(String senate) {
        int bannedRadiant = 0;
        int bannedDire = 0;
        Queue<Character> queue = new LinkedList<>();
        for (char c: senate.toCharArray()) {
            boolean isRadiant = c == 'R';
            boolean isDire = !isRadiant;
            if (isRadiant && bannedRadiant != 0) {
                bannedRadiant--;
            } else if (isDire && bannedDire != 0) {
                bannedDire--;
            } else {
                queue.offer(c);
                if (isRadiant) {
                    bannedDire++;
                } else {
                    bannedRadiant++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            if (c == 'R' && bannedRadiant != 0) {
                bannedRadiant--;
            } else if (c == 'D' && bannedDire != 0) {
                bannedDire--;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
