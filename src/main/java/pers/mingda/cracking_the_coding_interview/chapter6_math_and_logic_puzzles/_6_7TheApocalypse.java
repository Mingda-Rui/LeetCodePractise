package pers.mingda.cracking_the_coding_interview.chapter6_math_and_logic_puzzles;

import com.google.common.primitives.Ints;

public class _6_7TheApocalypse {
  public double runNFamilies(int families) {
    int girls = 0;
    int boys = 0;
    for (int i = 0; i < families; i++) {
      girls++;
      boys += runOneFamily();
    }
    return (double) girls / (boys + girls);
  }

  private int runOneFamily() {
    int boys = 0;
    while (randomIsBoy()) {
      boys++;
    }
    return boys;
  }

  private boolean randomIsBoy() {
    return Ints.saturatedCast(Math.round(Math.random())) == 1;
  }
}
