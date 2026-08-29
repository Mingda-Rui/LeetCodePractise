package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LC4032LongestSubarrayWithAtMostKDistinctPrimeFactors {}

class Solution {
  public int longestSubarray(int[] nums, int k) {
    int max = Arrays.stream(nums).max().orElseThrow();

    boolean[] primeCandidates = new boolean[max + 1];
    int maxSquared = (int) Math.ceil(Math.sqrt(max));
    for (int i = 2; i <= maxSquared; i++) {
      if (i * i <= max && primeCandidates[i * i]) {
        continue;
      }
      for (int j = i * i; j <= max; j += i) {
        primeCandidates[j] = true;
      }
    }

    List<Integer> primes = new ArrayList<>();
    for (int i = 2; i < primeCandidates.length; i++) {
      if (!primeCandidates[i]) {
        primes.add(i);
      }
    }

    Map<Integer, Set<Integer>> primeFactorRecord = new HashMap<>();
    for (int num : nums) {
      getPrimeFactors(num, primes, 0, primeFactorRecord);
    }

    int start = 0;
    int end = 0;
    int maxLen = 0;
    Map<Integer, Integer> primeCount = new HashMap<>();
    while (end <= nums.length) {
      if (primeCount.size() > k) {
        for (int prime : primeFactorRecord.get(nums[start])) {
          int count = primeCount.get(prime);
          if (count == 1) {
            primeCount.remove(prime);
          } else {
            primeCount.put(prime, count - 1);
          }
        }
        start++;
      } else {
        maxLen = Math.max(maxLen, end - start);
        if (end < nums.length) {
          for (int prime : primeFactorRecord.get(nums[end])) {
            int count = primeCount.getOrDefault(prime, 0);
            primeCount.put(prime, count + 1);
          }
        }
        end++;
      }
    }

    return maxLen;
  }

  private Set<Integer> getPrimeFactors(
      int num, List<Integer> primes, int primeIndex, Map<Integer, Set<Integer>> primeFactorRecord) {
    if (primeFactorRecord.containsKey(num)) {
      return primeFactorRecord.get(num);
    }

    if (num < 4) {
      primeFactorRecord.put(num, Set.of(num));
      return primeFactorRecord.get(num);
    }

    Set<Integer> result = new HashSet<>();
    int prime = primes.get(primeIndex);
    if (prime * prime > num) {
      result.add(num);
      return result;
    }
    if (num % prime == 0) {
      result.add(prime);
      if (prime < num) {
        result.addAll(getPrimeFactors(num / prime, primes, primeIndex, primeFactorRecord));
      }
    } else {
      result.addAll(getPrimeFactors(num, primes, primeIndex + 1, primeFactorRecord));
    }
    primeFactorRecord.put(num, result);
    return result;
  }
}
