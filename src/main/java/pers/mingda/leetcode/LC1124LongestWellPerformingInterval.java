package pers.mingda.leetcode;

public class LC1124LongestWellPerformingInterval {
    public int longestWPI(int[] hours) {
        int[] tiringDays = new int[hours.length];
        int numOfTiringDays = 0;
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] > 8) {
                tiringDays[numOfTiringDays] = i;
                numOfTiringDays++;
            }
        }

        int max = 0;
        for (int size = numOfTiringDays; size > 0 && max == 0; size--) {
            for (int head = 0; head + size - 1 < numOfTiringDays; head++) {
                int tail = head + size - 1;
                int days = tiringDays[tail] - tiringDays[head] + 1;
                int relaxDays = days - size;
                if (size > relaxDays) {
                    int diff = size - relaxDays;
                    int pDays = days + Math.min(diff - 1, tiringDays[head] + (hours.length - tiringDays[tail] - 1));
                    max = Math.max(max, pDays);
                }
            }
        }
        return max;
    }
}
