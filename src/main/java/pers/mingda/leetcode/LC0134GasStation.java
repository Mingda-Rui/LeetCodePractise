package pers.mingda.leetcode;

public class LC0134GasStation {

  public int canCompleteCircuit(int[] gas, int[] cost) {
    int currentGas = 0;
    int totalGas = 0;
    int station = 0;
    for (int i = 0; i < gas.length; i++) {
      int netGas = gas[i] - cost[i];
      totalGas += netGas;
      currentGas += netGas;
      if (currentGas < 0) {
        station = (i + 1) % gas.length;
        currentGas = 0;
      }
    }
    return totalGas < 0 ? -1 : station;
  }
}
