package pers.mingda.leetcode;

public class LC0832FlippingAnImage {
  public int[][] flipAndInvertImage(int[][] image) {
    int column = image[0].length;
    for (int i = 0; i < image.length; i++) {
      for (int j = 0; j < (column + 1) / 2; j++) {
        int exchangeCol = column - j - 1;
        if (image[i][j] == image[i][exchangeCol]) {
          image[i][j] ^= 1;
          image[i][exchangeCol] = image[i][j];
        }
      }
    }
    return image;
  }
}
