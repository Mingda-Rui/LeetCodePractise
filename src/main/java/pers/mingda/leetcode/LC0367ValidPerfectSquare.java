package pers.mingda.leetcode;

public class LC0367ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}
