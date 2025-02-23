package pers.mingda.cracking_the_coding_interview.chapter16_moderate;

public class _16_23Rand7FromRand5 {
    int rand7() {
        while (true) {
            int num = 5 * rand5() + rand5();
            if (num < 21) {
                return num % 7;
            }
        }
    }

    int rand5() {
        return (int) (Math.random() * 5);
    }
}
