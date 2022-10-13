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

class LC0478RadianSolution {

    private double radius;
    private double xCenter;
    private double yCenter;

    public LC0478RadianSolution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.xCenter = x_center;
        this.yCenter = y_center;
    }

    public double[] randPoint() {
        double radian = generateRandom(0, 2 * Math.PI);

        double random = generateRandom(0, 1) ;
        double hypotenuse = Math.sqrt(random) * radius;
        double x = Math.cos(radian) * hypotenuse;
        double y = Math.sin(radian) * hypotenuse;

        double[] result = {x + xCenter, y + yCenter};
        return result;
    }

    private double generateRandom(double min, double max) {
        return Math.random() * (max - min) + min;
    }
}