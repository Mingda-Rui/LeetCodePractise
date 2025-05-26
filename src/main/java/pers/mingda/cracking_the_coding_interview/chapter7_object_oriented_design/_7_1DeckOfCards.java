package pers.mingda.cracking_the_coding_interview.chapter7_object_oriented_design;

import java.util.ArrayList;
import java.util.List;

public class _7_1DeckOfCards {}

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
    throw new IllegalArgumentException(
      "Can not determine suit of value " + value
    );
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
    if (remainingCards() < number) {
      throw new IllegalArgumentException("The deck doesn't have enough cards!");
    }
    ArrayList<T> newCards = new ArrayList<>(number);
    for (int i = 0; i < number; i++) {
      T card = dealCard();
      newCards.add(i, card);
    }
    return newCards;
  }

  public T dealCard() {
    if (remainingCards() < 1) {
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

class Hand<T extends Card> {

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

class BlackJackHand extends Hand<BlackJackCard> {

  /*
   * There are multiple possible scores for a blackjack hand, since aces have
   * multiple values. Return the highest possible score that's under 21, or the
   * lowest score that's over.
   */
  public int score() {
    ArrayList<Integer> scores = possibleScores();
    int maxUnder = Integer.MIN_VALUE;
    int minOver = Integer.MAX_VALUE;
    for (int score : scores) {
      if (score > 21 && score < minOver) {
        minOver = score;
      } else if (score <= 21 && score > maxUnder) {
        maxUnder = score;
      }
    }
    return maxUnder == Integer.MIN_VALUE ? minOver : maxUnder;
  }

  /* return a list of all possible scores this hand could have (evaluating each
   * ace as both 1 and 11 */
  private ArrayList<Integer> possibleScores() {
    return null;
  }

  public boolean busted() {
    return score() > 21;
  }

  public boolean is21() {
    return score() == 21;
  }

  public boolean isBlackJack() {
    return is21() && cards.size() == 2;
  }
}

class BlackJackCard extends Card {

  public BlackJackCard(int c, Suit s) {
    super(c, s);
  }

  @Override
  public int value() {
    if (isAce()) return 1;
    else if (isFaceCard()) return 10;
    else return faceValue;
  }

  public int minValue() {
    if (isAce()) return 1;
    else return value();
  }

  public int maxValue() {
    if (isAce()) return 11;
    else return value();
  }

  public boolean isAce() {
    return faceValue == 1;
  }

  public boolean isFaceCard() {
    return faceValue >= 11 && faceValue <= 13;
  }
}
