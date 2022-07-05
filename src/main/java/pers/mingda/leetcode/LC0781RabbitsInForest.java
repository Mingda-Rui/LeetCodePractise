package pers.mingda.leetcode;

public class LC0781RabbitsInForest {
    public int numRabbits(int[] answers) {
        int max = 0;
        for (int num: answers)
            max = Math.max(num, max);
        int[] record = new int[max + 1];
        for (int num: answers)
            record[num]++;
        int total = 0;
        for (int i = 0; i < record.length; i++) {
            int count = record[i];
            int numOfColor = count / (i + 1) + (count % (i + 1) > 0 ? 1 : 0);
            total += numOfColor * (i + 1);
        }
        return total;
    }
}
