package pers.mingda.leetcode;

public class LC0006ZigzagConversion {

}

class Solution {
    public String convert(String s, int numRows) {
        if (numRows < 2)
            return s;
        char[] result = new char[s.length()];
        int resultIndex = 0;
        for (int i = 0; i < numRows; i++) {
            int index = i;
            while (index < s.length()) {
                char c = s.charAt(index);
                result[resultIndex] = c;
                index = getNextIndex(index, numRows);
                resultIndex++;
            }
        }
        return String.valueOf(result);
    }

    private int getNextIndex(int index, int numRows) {
        int groupSize = numRows + numRows - 2;
        int idInGroup = index % groupSize;
        int row = Math.min(idInGroup, groupSize - idInGroup);
        int nextIndex = index;
        if (row == 0 || row == numRows - 1) {
            nextIndex += groupSize;
        } else {
            if (idInGroup < numRows - 1) {
                nextIndex += (groupSize - (row * 2));
            } else {
                nextIndex += (row * 2);
            }
        }
        return nextIndex;
    }
}