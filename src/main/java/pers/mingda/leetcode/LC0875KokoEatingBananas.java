package pers.mingda.leetcode;

public class LC0875KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int total = 0;
        int maxPile = 0;
        for (int pile: piles) {
            total += pile;
            maxPile = Math.max(maxPile, pile);
        }

        int start = Math.max(1, total / h);
        int end = maxPile + 1;
        int speed = 0;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int hours = calcHours(piles, mid);
            if (hours > h) {
                start = mid + 1;
            } else if (hours <= h) {
                speed = mid;
                end = mid;
            }
        }
        return speed;
    }

    private int calcHours(int[] piles, int speed) {
        int hours = 0;
        for (int pile: piles) {
            int carry = pile % speed > 0 ? 1 : 0;
            hours += pile / speed + carry;
        }
        return hours;
    }
}
