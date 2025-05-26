package pers.mingda.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

public class LC0316RemoveDuplicateLetters {
  public String removeDuplicateLetters(String s) {
    Queue<String> queue = new PriorityQueue<>((str1, str2) -> str2.length() - str1.length());

    return null;
  }
}

class FoodRating {
  private String food;
  private String cuisine;
  private int rating;

  public FoodRating(String food, String cuisine, int rating) {
    this.food = food;
    this.cuisine = cuisine;
    this.rating = rating;
  }

  public String getName() {
    return food;
  }

  public String getCuisine() {
    return cuisine;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }
}
// a d c b
// a d b c
