package pers.mingda.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LC0997FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        if (n == 1) return n;

        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> nonJudge = new HashSet<>();
        int judge = -1;
        for (int[] trustRelation : trust) {
            int person = trustRelation[0];
            int trustee = trustRelation[1];
            nonJudge.add(person);
            int trustedCount = map.getOrDefault(trustee, 0) + 1;
            map.put(trustee, trustedCount);
            if (trustedCount == n - 1) {
                judge = trustee;
            }
        }
        return nonJudge.contains(judge) ? -1 : judge;
    }
}
