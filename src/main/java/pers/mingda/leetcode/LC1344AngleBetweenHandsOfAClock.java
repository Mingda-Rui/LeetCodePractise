package pers.mingda.leetcode;

public class LC1344AngleBetweenHandsOfAClock {
}

class LC1344Solution {
  public double angleClock(int hour, int minutes) {
    // 1. diff between 12 o'clock and the hour head
    // 2. diff between 12 o'clock and the minute head
    // 3. calculate the offset on the hour head based on the minute head
    // 4. return the smaller distance between the hour and the minute heads

    double hourDegrees = 360 * ((double)hour / 12.0);
    double minuteDegrees = 360 * ((double)minutes / 60.0);
    double offset = 30 * ((double)minutes / 60.0);
    hourDegrees += offset;

    double angle = Math.max(hourDegrees, minuteDegrees) - Math.min(hourDegrees, minuteDegrees);
    return Math.min(angle, 360 - angle);
  }
}
