package pers.mingda.leetcode;

public class LC0781RabbitsInForest {
    public int numRabbits(int[] answers) {
        int[] record = new int[1001];
        int total = 0;
        for (int i = 0; i < answers.length; i++) {
            int num = answers[i] + 1;
            int curVal = record[num];
            if (curVal % num == 0) total += num;
            record[num]++;
        }
        return total;
    }
}
