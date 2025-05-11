package pers.mingda.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC0952LargestComponentSizeByCommonFactor {
    public int largestComponentSize(int[] nums) {
        int max = findMax(nums);
        UnionFind uf = new UnionFind(max);
        Map<Integer, Integer> numToFactor = new HashMap<>();
        for (int num : nums) {
            List<Integer> primeFactors = findAllPrimeFactors(num);
            //int smallestPrime = primeFactors.isEmpty() ? num : primeFactors.getFirst();
            int smallestPrime = primeFactors.getFirst();
            numToFactor.put(num, smallestPrime);
            for (int i = 0; i < primeFactors.size() - 1; i++) {
                uf.union(primeFactors.get(i), primeFactors.get(i + 1));
            }
        }

        int largestSize = 0;
        Map<Integer, Integer> groupCount = new HashMap<>();
        for (int num : nums) {
            int factor = numToFactor.get(num);
            int head = uf.find(factor);
            int size = groupCount.getOrDefault(head, 0) + 1;
            largestSize = Math.max(largestSize, size);
            groupCount.put(head, size);
        }
        return largestSize;
    }

    private List<Integer> findAllPrimeFactors(int num) {
        List<Integer> primeFactors = new ArrayList<>();
        int factor = 2;
        while (num >= factor * factor) {
            if (num % factor == 0) {
                if (primeFactors.isEmpty() || primeFactors.getLast() != factor) {
                    primeFactors.add(factor);
                }
                num /= factor;
            } else {
                factor++;
            }
        }
        if (primeFactors.isEmpty() || primeFactors.getLast() != num) {
            primeFactors.add(num);
        }
        return primeFactors;
    }

    private int findMax(int[] nums) {
        int max = -1;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }
}

class UnionFind {
    private final int[] elements;
    private final int[] sizes;

    public UnionFind(int size) {
        this.elements = new int[size + 1];
        this.sizes = new int[size + 1];
        Arrays.fill(sizes, 1);
        for (int i = 0; i <= size; i++) {
            elements[i] = i;
        }

    }

    public int find(int element) {
        if (elements[element] == element) {
            return element;
        }
        int e = find(elements[element]);
        elements[element] = e;
        return e;
    }

    public void union(int element1, int element2) {
        int head1 = find(element1);
        int head2 = find(element2);
        if (head1 == head2) {
            return;
        }
        int largeGroup = sizes[head1] < sizes[head2] ? head2 : head1;
        int smallGroup = sizes[head1] < sizes[head2] ? head1 : head2;
        elements[smallGroup] = largeGroup;
        sizes[largeGroup] += sizes[smallGroup];
    }
}