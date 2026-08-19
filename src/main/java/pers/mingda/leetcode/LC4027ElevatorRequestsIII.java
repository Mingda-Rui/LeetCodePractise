package pers.mingda.leetcode;

public class LC4027ElevatorRequestsIII {}

class LC4027Solution {
  public long elevatorRequests(int n, int start, int[][] requests) {
    int dpSize = 1 << requests.length;
    long[][] dp = new long[dpSize][requests.length];
    for (int i = 0; i < dp.length; i++) {
      for (int j = 0; j < dp[0].length; j++) {
        dp[i][j] = Long.MAX_VALUE;
      }
    }
    for (int i = 0; i < requests.length; i++) {
      int[] request = requests[i];
      int arrival = request[0];
      int floor = request[1];
      int dist = Math.abs(floor - start);
      dp[1 << i][i] = Math.max(dist, arrival);
    }

    for (int mask = 0; mask < dpSize; mask++) {
      for (int prev = 0; prev < requests.length; prev++) {

        if (dp[mask][prev] == Long.MAX_VALUE) {
          continue;
        }
        int prevFloor = requests[prev][1];
        for (int i = 0; i < requests.length; i++) {
          int nextMask = mask | (1 << i);
          if (mask == nextMask) {
            continue;
          }

          int[] request = requests[i];
          int arrival = request[0];
          int floor = request[1];

          long dist = Math.abs(floor - prevFloor);
          long minTime = Math.max(dp[mask][prev] + dist, arrival);
          dp[nextMask][i] = Math.min(dp[nextMask][i], minTime);
        }
      }
    }

    long result = Long.MAX_VALUE;
    int fullMask = (1 << requests.length) - 1;
    for (int i = 0; i < requests.length; i++) {
      if (dp[fullMask][i] == Long.MAX_VALUE) {
        continue;
      }
      result = Math.min(result, dp[fullMask][i]);
    }

    return result;
  }
}
