package pers.mingda.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LC0353DesignSnakeGame {

}

class SnakeGame {

    int score;
    int foodEaten;
    int[][] food;
    int width;
    int height;
    List<List<Integer>> snakeBody;
    Set<List<Integer>> bodySet;

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        this.score = 0;
        this.foodEaten = 0;
        List<Integer> head = Arrays.asList(0, 0);
        snakeBody = new LinkedList<>();
        snakeBody.add(head);
        bodySet = new HashSet<>();
        bodySet.add(head);
    }

    public int move(String direction) {
        List<Integer> currentHead = snakeBody.get(0);

        int headX = currentHead.get(0);
        int headY = currentHead.get(1);
        List<Integer> newHead = switch (direction) {
                case "L" -> Arrays.asList(headX, headY - 1);
                case "R" -> Arrays.asList(headX, headY + 1);
                case "U" -> Arrays.asList(headX - 1, headY);
                case "D" -> Arrays.asList(headX + 1, headY);
                default -> null;
        };

        if (!tryEatNextFood(newHead)) {
            List<Integer> oldTail = snakeBody.remove(getTailIndex());
            bodySet.remove(oldTail);
        }

        if (!boundaryCheck(newHead) || !bodyCheck(newHead)) {
            return -1;
        }
        snakeBody.add(0, newHead);
        bodySet.add(newHead);
        return score;

    }

    private boolean tryEatNextFood(List<Integer> head) {
        if (foodEaten == food.length)
            return false;
        int[] nextFood = food[foodEaten];
        if (nextFood[0] != head.get(0) || nextFood[1] != head.get(1))
            return false;
        foodEaten++;
        score++;
        return true;
    }

    private int getTailIndex() {
        return snakeBody.size() - 1;
    }

    private boolean boundaryCheck(List<Integer> head) {
        int x = head.get(0);
        int y = head.get(1);
        return x >= 0 && x < height && y >= 0 && y < width;
    }

    private boolean bodyCheck(List<Integer> head) {
        return !bodySet.contains(head);
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
