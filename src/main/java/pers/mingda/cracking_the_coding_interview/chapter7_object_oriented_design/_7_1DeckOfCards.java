package pers.mingda.cracking_the_coding_interview.chapter7_object_oriented_design;

import java.util.ArrayList;
import java.util.List;

public class _7_1DeckOfCards {
}

enum Suit {
    Club(0),
    Diamond(1),
    Heart(2),
    Spade(3);

    private int value;

    private Suit(int v) {
        value = v;
    }

    public int getValue() {
        return value;
    }

    public static Suit getSuitFromValue(int value) {
        for (Suit suit : Suit.values()) {
            if (suit.getValue() == value) {
                return suit;
            }
        }
        throw new IllegalArgumentException("Can not determine suit of value " + value);
    }
}

class Desk<T extends Card> {
    private ArrayList<T> cards = new ArrayList<>(); // all cards, dealt or not
    private int dealtIndex = 0; // marks first un-dealt card

    public void setDeckOfCards(ArrayList<T> deckOfCards) {}

    public void shuffle() {}

    public int remainingCards() {
        return cards.size() - dealtIndex;
    }

    public List<T> dealHand(int number) {
        ArrayList<T> newCards = new ArrayList<>(number);
        for (int i = 0; i < number; i++) {
            T card = dealCard();
            newCards.add(i, card);
        }
        return newCards;
    }

    public T dealCard() {
        if (dealtIndex == cards.size() - 1) {
            throw new IllegalArgumentException("The deck is exhausted!");
        }
        T card = cards.get(dealtIndex);
        dealtIndex++;
        return card;
    }


}

abstract class Card {
    private boolean available = true;

    /*
    * number or face that's on card - a number 2 through 10, or 11 for Jack, 12 for
    * Queen, 13 for King, or 1 for Ace
    * */
    protected int faceValue;
    protected Suit suit;

    public Card(int c, Suit s) {
        faceValue = c;
        suit = s;
    }

    public abstract int value();

    public Suit suit() {
        return suit;
    }

    /* Checks if the card is available to be given out to someone */
    public boolean isAvailable() {
        return available;
    }

    public void markUnavailable() {
        available = false;
    }

    public void markAvailable() {
        available = true;
    }
}

class Hand <T extends Card> {
    protected ArrayList<T> cards = new ArrayList<>();

    public int score() {
        int score = 0;
        for (T card : cards) {
            score += card.value();
        }
        return score;
    }

    public void addCard(T card) {
        cards.add(card);
    }
}


