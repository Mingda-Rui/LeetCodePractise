package pers.mingda.leetcode;

public class LC0074SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;
        int total = row * column;
        int start = 0;
        int end = total;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int calcRow = mid / column;
            int calcColumn = mid % column;
            int val = matrix[calcRow][calcColumn];
            if (val == target)
                return true;
            else if (val > target)
                end = mid;
            else
                start = mid + 1;
        }
        return false;
    }

    public boolean searchMatrixSearch2Axis(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;
        int start = 0;
        int end = row;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int val = matrix[mid][0];
            if (val == target)
                return true;
            else if (val < target)
                start = mid + 1;
            else
                end = mid;
        }
        int rowNum = Math.max(start - 1, 0);
        start = 0;
        end = column;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int val = matrix[rowNum][mid];
            if (val == target)
                return true;
            else if (val < target)
                start = mid + 1;
            else
                end = mid;
        }
        return false;
    }
}
