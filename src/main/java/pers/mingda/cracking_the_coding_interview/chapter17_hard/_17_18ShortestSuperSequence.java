package pers.mingda.cracking_the_coding_interview.chapter17_hard;

public class _17_18ShortestSuperSequence {
    int[] shortestSuperSequence(int[] bigArray, int[] smallArray) {
        int[][] locMap = buildLocMap(bigArray, smallArray);
        int start = 0;
        int end = Integer.MAX_VALUE;
        for (int i = 0; i < bigArray.length; i++) {
            int[] loc = locMap[i];
            int maxTail = getMax(loc);
            if (maxTail == -1) {
                break;
            }
            if (maxTail - i < end - start) {
                start = i;
                end = maxTail;
            }
        }
        return new int[] {start, end};
    }

    int[][] buildLocMap(int[] bigArray, int[] smallArray) {
        int[][] locMap = new int[bigArray.length][smallArray.length];
        for (int i = bigArray.length - 1; i >= 0; i--) {
            int current = bigArray[i];
            for (int j = 0; j < smallArray.length; j++) {
                int small = smallArray[j];
                if (small == current) {
                    locMap[i][j] = i;
                } else if (i == bigArray.length - 1) {
                    locMap[i][j] = -1;
                } else {
                    locMap[i][j] = locMap[i + 1][j];
                }
            }
        }
        return locMap;
    }

    int getMax(int[] loc) {
        int max = 0;
        for (int num: loc) {
            if (num == -1) {
                return -1;
            }
            max = Math.max(max, num);
        }
        return max;
    }
}
