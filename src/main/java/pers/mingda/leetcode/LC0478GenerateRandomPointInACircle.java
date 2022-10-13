package pers.mingda.leetcode;

public class LC0478GenerateRandomPointInACircle {

}

class LC0478Solution {

    private double x;
    private double y;
    private double radius;

    public LC0478Solution(double radius, double x_center, double y_center) {
        this.x = x_center;
        this.y = y_center;
        this.radius = radius;
    }

    public double[] randPoint() {
        double xOffset = getRandome(-radius, radius);
        double yOffset = getRandome(-radius, radius);
        while (distanceToCenter(xOffset, yOffset) > radius) {
            xOffset = getRandome(-radius, radius);
            yOffset = getRandome(-radius, radius);
        }
        double[] result = {x + xOffset, y + yOffset};
        return result;
    }

    private double getRandome(double min, double max) {
        return Math.random() * (max - min) + min;
    }

    private double distanceToCenter(double x, double y) {
        return Math.sqrt(x * x + y * y);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */