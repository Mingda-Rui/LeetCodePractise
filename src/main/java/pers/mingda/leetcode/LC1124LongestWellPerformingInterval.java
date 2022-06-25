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

    public int longestWPIBruteForce(int[] hours) {
        int[] record = new int[hours.length];
        int current = 0;
        int max = 0;
        for (int i = 0; i < hours.length; i++) {
            int hour = hours[i];
            if (hour > 8)
                current++;
            else
                current--;

            record[i] = current;
            if (current < 1) {
                for (int j = 0; j < i; j++) {
                    if (current - record[j] > 0) {
                        max = Math.max(max, i - j);
                        break;
                    }
                }
            } else {
                max = Math.max(max, i + 1);
            }

        }
        return max;
    }
}
