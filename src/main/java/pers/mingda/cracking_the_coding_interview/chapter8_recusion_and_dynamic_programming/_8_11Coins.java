package pers.mingda.cracking_the_coding_interview.chapter8_recusion_and_dynamic_programming;

public class _8_11Coins {
    public int countRepresentations(int n) {
        if (n < 0) {
            return 0;
        } else if (n == 0) {
            return 1;
        }
        int repCount = 0;
        for (Coin coin: Coin.values()) {
            repCount += countRepresentations(n - coin.getCents());
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
