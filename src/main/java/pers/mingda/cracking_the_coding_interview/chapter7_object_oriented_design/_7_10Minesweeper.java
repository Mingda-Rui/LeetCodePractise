package pers.mingda.cracking_the_coding_interview.chapter7_object_oriented_design;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class _7_10Minesweeper {
  // Class: Board
  // Field: Cell[][]

  // Class: Cell
  // Field: CellType
  // Field: Status
  // Field: Optional<Integer>

  // Enum: CellType
  // Field: Blank, Number, Bomb

  // Enum: CellStatus
  // Field: Covered, Uncovered, Flagged

  // Class: Player

  // Class: MinesweeperGame
  // Field: Player
  // Field: Board
  // Field: Display

  // Func: boolean uncover(int x, int y);
  // Func: boolean unCoverSurroundings(int x, int y)
  // Func: flag(int x, int y);
  // Func: unFlag(int x, int y);

  // Class: Display
  // Func: refreshDisplay(Board);
}

class Cell {

  private int row;
  private int column;
  private boolean isBomb;
  private int number;
  private boolean isExposed = false;
  private boolean isGuess = false;

  public Cell(int r, int c) {
    // ...
  }

  /* Getters and setters for above variables */
  public int getRow() {
    return this.row;
  }

  public int getColumn() {
    return this.column;
  }

  public boolean flip() {
    isExposed = true;
    return !isBomb;
  }

  public boolean toggleGuess() {
    if (!isExposed) {
      isGuess = !isGuess;
    }
    return isGuess;
  }

  public void setRowAndColumn(int r, int c) {}

  public void incrementNumber() {
    number++;
  }

  public boolean isBlank() {
    return number == 0;
  }
}

class MinesweeperBoard {

  private int nRows;
  private int nColumns;
  private int nBombs = 0;
  private Cell[][] cells;
  private Cell[] bombs;
  private int numUnexposedRemaining;
  private int[][] deltas = { // Offsets of 8 surrounding cells
    { -1, -1 },
    { -1, 0 },
    { -1, 1 },
    { 0, -1 },
    { 0, 1 },
    { 1, -1 },
    { 1, 0 },
    { 1, 1 },
  };

  public MinesweeperBoard(int r, int c, int b) {
    // ...
  }

  private void initializeBoard() {
    // ...
  }

  private boolean flipCell(Cell cell) {
    // ...
    return false;
  }

  public void expandBlank(Cell cell) {
    Queue<Cell> toExplore = new LinkedList<>();
    toExplore.add(cell);

    while (!toExplore.isEmpty()) {
      Cell current = toExplore.remove();

      for (int[] delta : deltas) {
        int r = current.getRow() + delta[0];
        int c = current.getColumn() + delta[1];

        if (inBounds(r, c)) {
          Cell neighbor = cells[r][c];
          if (flipCell(neighbor) && neighbor.isBlank()) {
            toExplore.add(neighbor);
          }
        }
      }
    }
  }

  public UserPlayResult playFlip(UserPlay play) {
    // ...
    return null;
  }

  public int getNumRemaining() {
    return numUnexposedRemaining;
  }

  void shuffleBoard() {
    int nCells = nRows * nColumns;
    Random random = new Random();
    for (int index1 = 0; index1 < nCells; index1++) {
      int index2 = index1 + random.nextInt(nCells - index1);
      if (index1 != index2) {
        /* Get cell at index1. */
        int row1 = index1 / nColumns;
        int column1 = (index1 - row1 * nColumns) % nColumns;
        Cell cell1 = cells[row1][column1];

        /* Get cell at index2. */
        int row2 = index2 / nColumns;
        int column2 = (index2 - row2 * nColumns) % nColumns;
        Cell cell2 = cells[row2][column2];

        /* Swap. */
        cells[row1][column1] = cell2;
        cell2.setRowAndColumn(row1, column1);
        cells[row2][column2] = cell1;
        cell1.setRowAndColumn(row2, column2);
      }
    }
  }

  /* Set the cells around the bombs to the right number. Although the bombs have
   * been shuffled, the reference in the bombs array is still to same object */
  void setNumberedCells() {
    for (Cell bomb : bombs) {
      int row = bomb.getRow();
      int col = bomb.getColumn();
      for (int[] delta : deltas) {
        int r = row + delta[0];
        int c = col + delta[1];
        if (inBounds(r, c)) {
          cells[r][c].incrementNumber();
        }
      }
    }
  }

  private boolean inBounds(int r, int c) {
    // ...
    return false;
  }
}

class UserPlay {

  private int row;
  private int column;
  private boolean isGuess;
  /* constructor, getters, setters. */
}

class UserPlayResult {

  private boolean successful;
  private MinesweeperGame.GameState resultingState;
  /* constructor, getter, setters. */
}

class MinesweeperGame {

  public enum GameState {
    WON,
    LOST,
    RUNNING,
  }

  private MinesweeperBoard board;
  private int rows;
  private int columns;
  private int bombs;
  private GameState state;

  public MinesweeperGame(int r, int c, int b) {
    // ...
  }

  public boolean initialized() {
    // ...
    return false;
  }

  public boolean start() {
    // ...
    return false;
  }

  // Loops until game is over.
  public boolean playGame() {
    // ...
    return false;
  }
}
