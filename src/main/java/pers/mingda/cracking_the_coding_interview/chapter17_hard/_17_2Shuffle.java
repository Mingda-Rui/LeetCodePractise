package pers.mingda.cracking_the_coding_interview.chapter17_hard;

public class _17_2Shuffle {

    /* Random number between lower and higher, inclusive */
    int rand(int lower, int higher) {
        return lower + (int)(Math.random() * (higher - lower + 1));
    }

    int[] shuffleArrayRecursively(int[] cards, int i) {
        if (i == 0) return cards;

        shuffleArrayRecursively(cards, i - 1); // Shuffle earlier part
        int k = rand(0, i); // Pick random index to swap with

        /* Swap element k and i */
        int temp = cards[k];
        cards[k] = cards[i];
        cards[i] = temp;

        /* Return shuffled array */
        return cards;
    }

    void shuffleArrayIteratively(int[] cards) {
        for (int i = 0; i < cards.length; i++) {
            int k = rand(0, i);
            int temp = cards[k];
            cards[k] = cards[i];
            cards[i] = temp;
        }
    }
}
