package pers.mingda.cracking_the_coding_interview.chapter8_recusion_and_dynamic_programming;

public class _8_1TripleStep {

  public int countPossibleWays(int nSteps) {
    int[] possibleWays = new int[nSteps + 1];
    possibleWays[0] = 1;
    return countPossibleWays(nSteps, possibleWays);
  }

  private int countPossibleWays(int nSteps, int[] possibleWays) {
    if (nSteps < 0) {
      return 0;
    }
    if (possibleWays[nSteps] != 0) {
      return possibleWays[nSteps];
    }

    int ways =
      countPossibleWays(nSteps - 1, possibleWays) +
      countPossibleWays(nSteps - 2, possibleWays) +
      countPossibleWays(nSteps - 3, possibleWays);
    possibleWays[nSteps] = ways;
    return ways;
  }
}
