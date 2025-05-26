package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LC1431KidsWithTheGreatestNumberOfCandies {
  public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    int maxCandies = 0;
    for (int candy : candies) {
      maxCandies = Math.max(maxCandies, candy);
    }
    List<Boolean> result = new ArrayList<>();
    for (int candy : candies) {
      result.add(candy + extraCandies >= maxCandies);
    }
    return result;
  }
}
