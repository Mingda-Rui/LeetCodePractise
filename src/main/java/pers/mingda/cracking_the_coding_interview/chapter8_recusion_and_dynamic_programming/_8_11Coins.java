package pers.mingda.cracking_the_coding_interview.chapter8_recusion_and_dynamic_programming;

import java.util.Arrays;
import java.util.List;

public class _8_11Coins {
    public int countReps(int n) {
        List<Coin> coins = Arrays.asList(Coin.values());
        return countReps(n, coins);
    }

    private int countReps(int n, List<Coin> remains) {
        if (n == 0 && remains.isEmpty()) {
            return 1;
        } else  if (n < 0 || remains.isEmpty()) {
          return 0;
        }

        Coin coin = remains.getLast();
        remains.removeLast();

        int repCount = 0;
        for (int coinCount = 0; coinCount <= n / coin.getCents(); coinCount++) {
            repCount += countReps(n - coin.getCents() * coinCount, remains);
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
