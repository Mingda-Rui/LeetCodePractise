package pers.mingda.cracking_the_coding_interview.chapter17_hard;

import java.util.*;

public class _17_18ShortestSuperSequence {
    int[] shortestSuperSequence(int[] bigArray, int[] smallArray) {
        int[][] locMap = buildLocMap(bigArray, smallArray);
        int start = 0;
        int end = Integer.MAX_VALUE;
        for (int i = 0; i < bigArray.length; i++) {
            int[] loc = locMap[i];
            int maxTail = getMax(loc);
            if (maxTail == -1) {
                break;
            }
            if (maxTail - i < end - start) {
                start = i;
                end = maxTail;
            }
        }
        return new int[] {start, end};
    }

    int[][] buildLocMap(int[] bigArray, int[] smallArray) {
        int[][] locMap = new int[bigArray.length][smallArray.length];
        for (int i = bigArray.length - 1; i >= 0; i--) {
            int current = bigArray[i];
            for (int j = 0; j < smallArray.length; j++) {
                int small = smallArray[j];
                if (small == current) {
                    locMap[i][j] = i;
                } else if (i == bigArray.length - 1) {
                    locMap[i][j] = -1;
                } else {
                    locMap[i][j] = locMap[i + 1][j];
                }
            }
        }
        return locMap;
    }

    int getMax(int[] loc) {
        int max = 0;
        for (int num: loc) {
            if (num == -1) {
                return -1;
            }
            max = Math.max(max, num);
        }
        return max;
    }

    int[] shortestSuperSequenceMinHeap(int[] bigArray, int[] smallArray) {
        List<Queue<Integer>> locs = buildLocs(bigArray, smallArray);
        return computeShortestSeq(locs);
    }

    List<Queue<Integer>> buildLocs(int[] bigArray, int[] smallArray) {
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int small: smallArray) {
            map.put(small, new LinkedList<>());
        }

        for (int i = 0; i < bigArray.length; i++) {
            int val = bigArray[i];
            if (map.containsKey(val)) {
                map.get(val).add(i);
            }
        }
        return map.values().stream().toList();
    }

    int[] computeShortestSeq(List<Queue<Integer>> locs) {
        PriorityQueue<ShortestSuperSequenceNode> minHeap = new PriorityQueue<>();
        int max = 0;
        for (int i = 0; i < locs.size(); i++) {
            int headIndex = locs.get(i).remove();
            max = Math.max(max, headIndex);
            minHeap.add(new ShortestSuperSequenceNode(i, headIndex));
        }

        int start = 0;
        int end = Integer.MAX_VALUE;

        while (true) {
            ShortestSuperSequenceNode minNode = minHeap.poll();
            if (max - minNode.index <= end - start) {
                end = max;
                start = minNode.index;
            }
            if (locs.get(minNode.val).isEmpty()) {
                break;
            }
            int newHeadIndex = locs.get(minNode.val).remove();
            max = Math.max(max, newHeadIndex);
            minHeap.add(new ShortestSuperSequenceNode(minNode.val, newHeadIndex));
        }

        return new int[] {start, end};
    }
}

class ShortestSuperSequenceNode {
    int val;
    int index;

    public ShortestSuperSequenceNode(int val, int index) {
        this.val = val;
        this.index = index;
    }
}
