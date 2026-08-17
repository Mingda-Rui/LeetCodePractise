package pers.mingda.leetcode;

public class LC4025MinimizeTheMaximumWaitingTimeAtSynchronizedTrafficLights {}

class LC4025Solution {
  public int minPenalty(int period, int[] lights, int[] arrivalTime) {
    int maxLight = 0;
    for (int light : lights) {
      maxLight = Math.max(maxLight, light);
    }

    int result = 0;
    for (int aTime : arrivalTime) {
      int normalizedTime = aTime % period;
      if (normalizedTime < maxLight) {
        continue;
      }
      result = Math.max(result, period - normalizedTime);
    }

    return result;
  }
}
