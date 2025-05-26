package pers.mingda.leetcode;

import java.util.Stack;

public class LC0735AsteroidCollision {
  public int[] asteroidCollision(int[] asteroids) {
    Stack<Integer> stack = new Stack<>();
    int asteroidIndex = 0;
    while (asteroidIndex < asteroids.length) {
      int asteroid = asteroids[asteroidIndex];
      if (stack.isEmpty() || !willCollide(stack.peek(), asteroid)) {
        stack.push(asteroid);
        asteroidIndex++;
      } else if (compareSize(stack.peek(), asteroid) > 0) {
        asteroidIndex++;
      } else if (compareSize(stack.peek(), asteroid) < 0) {
        stack.pop();
      } else if (compareSize(stack.peek(), asteroid) == 0) {
        stack.pop();
        asteroidIndex++;
      }
    }
    return toArray(stack);
  }

  private boolean willCollide(int leftAsteroid, int rightAsteroid) {
    return leftAsteroid > 0 && rightAsteroid < 0;
  }

  private int compareSize(int asteroid1, int asteroid2) {
    return Math.abs(asteroid1) - Math.abs(asteroid2);
  }

  private int[] toArray(Stack<Integer> stack) {
    int[] result = new int[stack.size()];
    for (int i = stack.size() - 1; i >= 0; i--) {
      result[i] = stack.pop();
    }
    return result;
  }
}
