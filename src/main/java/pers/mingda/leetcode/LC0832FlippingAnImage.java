package pers.mingda.leetcode;

public class LC0832FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] image) {
        int column = image[0].length;
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < (column + 1) / 2; j++) {
                int exchangeCol = column - j - 1;
                int tmp = image[i][j] == 0 ? 1 : 0;
                image[i][j] = image[i][exchangeCol] == 0 ? 1 : 0;
                image[i][exchangeCol] = tmp;
            }
        }
        return image;
    }
}
