package pers.mingda.cracking_the_coding_interview.chapter8_recusion_and_dynamic_programming;

import java.util.Arrays;
import java.util.List;

public class _8_11Coins {
    public int countReps(int n) {
        List<Coin> coins = Arrays.asList(Coin.values());
        return countReps(n, coins);
    }

    private int countReps(int amount, List<Coin> remains) {
        if (remains.size() == 1) {
            // only one cent penny left
            return 1;
        }

        Coin coin = remains.getLast();
        remains.removeLast();

        int repCount = 0;
        for (int coinCount = 0; coinCount <= amount / coin.getCents(); coinCount++) {
            int remainAmount = amount - coin.getCents() * coinCount;
            repCount += countReps(remainAmount, remains);
        }
        return repCount;
    }
}

enum Coin {
    Quarter(25),
    Dime(10),
    Nickel(5),
    Penny(1);
    private final int cents;
    Coin(int cents) {
        this.cents = cents;
    }

    public int getCents() {
        return cents;
    }
}
