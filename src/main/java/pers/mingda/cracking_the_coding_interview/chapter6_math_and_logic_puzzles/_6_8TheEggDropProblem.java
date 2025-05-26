package pers.mingda.cracking_the_coding_interview.chapter6_math_and_logic_puzzles;

public class _6_8TheEggDropProblem {

  private static final int TOTAL_FLOORS = 100;

  private int findMinWorstCaseByFixedStepApproach() {
    int min = 100;
    for (int i = 1; i < 100; i++) {
      int total = simulateSteps(i);
      if (total < min) {
        min = total;
      }
    }
    return min;
  }

  private int simulateSteps(int step) {
    int largeSteps = TOTAL_FLOORS / step;
    return largeSteps + (step - 2);
  }

  private int findMinWorstCaseByBrutalForceApproach(
    int floorsRemain,
    int steps
  ) {
    if (floorsRemain <= 1) {
      return steps;
    }
    steps++;
    int worstStep = 100;
    for (int i = 2; i <= floorsRemain; i++) {
      // case 1, the egg 1 is not broken
      int caseOne = findMinWorstCaseByBrutalForceApproach(
        floorsRemain - i,
        steps
      );

      // case 2, the egg 1 is broken
      int caseTwo = steps + (i - 1);
      int worstRemainSteps = Math.max(caseOne, caseTwo);
      worstStep = Math.min(worstStep, worstRemainSteps);
    }
    return worstStep;
  }

  private int findMinWorstCaseMostOptimalApproach(int totalFloors) {
    int currFloor = 0;
    int step = 0;
    while (currFloor < totalFloors) {
      step++;
      currFloor += step;
    }
    return step;
  }
}
