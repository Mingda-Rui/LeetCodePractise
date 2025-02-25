package pers.mingda.cracking_the_coding_interview.chapter17_hard;

public class _17_1AddWithoutPlus {
    int add(int a, int b) {
        if (b == 0) return a;
        int sum = a ^ b; // add without carrying;
        int carry = (a & b) << 1; // carry, but don't add
        return add(sum, carry);
    }
}
