package pers.mingda.cracking_the_coding_interview.chapter16_moderate;

public class _16_23Rand7FromRand5 {
    int rand7() {
        return rand5() * 7 / 5;
    }

    int rand5() {
        return (int) (Math.random() * 5);
    }
}
