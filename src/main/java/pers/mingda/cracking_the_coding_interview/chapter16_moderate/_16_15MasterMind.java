package pers.mingda.cracking_the_coding_interview.chapter16_moderate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _16_15MasterMind {

  MasterMindResult estimate(String guess, String solution) {
    int hits = getHits(guess, solution);
    int pseudoHits = getPseudoHits(guess, solution);
    return new MasterMindResult(hits, pseudoHits);
  }

  int getHits(String guess, String solution) {
    int count = 0;
    for (int i = 0; i < guess.length(); i++) {
      if (guess.charAt(i) == solution.charAt(i)) {
        count++;
      }
    }
    return count;
  }

  int getPseudoHits(String guess, String solution) {
    Map<Character, Integer> guessMap = new HashMap<>();
    Map<Character, Integer> solutionMap = new HashMap<>();
    for (int i = 0; i < guess.length(); i++) {
      char guessChar = guess.charAt(i);
      char solutionChar = solution.charAt(i);
      if (guessChar != solutionChar) {
        int currentGuess = guessMap.getOrDefault(guessChar, 0);
        guessMap.put(guessChar, currentGuess + 1);

        int currentSolution = solutionMap.getOrDefault(solutionChar, 0);
        solutionMap.put(solutionChar, currentSolution + 1);
      }
    }

    return Arrays.stream(MasterMindColor.values())
      .map(MasterMindColor::getCode)
      .map(c -> Math.min(guessMap.get(c), solutionMap.get(c)))
      .mapToInt(Integer::intValue)
      .sum();
  }
}

class MasterMindResult {

  int hits;
  int pseudoHits;

  public MasterMindResult(int hits, int pseudoHits) {
    this.hits = hits;
    this.pseudoHits = pseudoHits;
  }
}

enum MasterMindColor {
  RED("R"),
  YELLOW("Y"),
  GREEN("G"),
  BLUE("B");

  String code;

  MasterMindColor(String code) {
    this.code = code;
  }

  public char getCode() {
    return code.charAt(0);
  }
}
