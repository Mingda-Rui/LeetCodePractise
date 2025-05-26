package pers.mingda.cracking_the_coding_interview.chapter16_moderate;

import java.util.ArrayList;
import java.util.Iterator;

public class _16_4TicTacWin {
  TicTacWinPiece hasWon(TicTacWinPiece[][] board) {
    if (board.length != board[0].length) {
      return TicTacWinPiece.Empty;
    }
    int size = board.length;

    ArrayList<TicTacWinPositionIterator> instructions = new ArrayList<>();
    for (int i = 0; i < board.length; i++) {
      instructions.add(new TicTacWinPositionIterator(new TicTacWinPosition(0, i), 1, 0, size));
      instructions.add(new TicTacWinPositionIterator(new TicTacWinPosition(i, 0), 0, 1, size));
    }
    instructions.add(new TicTacWinPositionIterator(new TicTacWinPosition(0, 0), 1, 1, size));
    instructions.add(
        new TicTacWinPositionIterator(new TicTacWinPosition(0, size - 1), 1, -1, size));

    for (TicTacWinPositionIterator iterator : instructions) {
      TicTacWinPiece winner = hasWon(board, iterator);
      if (winner != TicTacWinPiece.Empty) {
        return winner;
      }
    }
    return TicTacWinPiece.Empty;
  }

  TicTacWinPiece hasWon(TicTacWinPiece[][] board, TicTacWinPositionIterator iterator) {
    TicTacWinPosition firstPosition = iterator.next();
    TicTacWinPiece first = board[firstPosition.row][firstPosition.column];
    while (iterator.hasNext()) {
      TicTacWinPosition secondPosition = iterator.next();
      if (board[secondPosition.row][secondPosition.column] != first) {
        return TicTacWinPiece.Empty;
      }
    }
    return first;
  }
}

enum TicTacWinPiece {
  Empty,
  Red,
  Blue
}

class TicTacWinPositionIterator implements Iterator<TicTacWinPosition> {
  private final int rowIncrement;
  private final int colIncrement;
  private final int size;
  private TicTacWinPosition current;

  public TicTacWinPositionIterator(
      TicTacWinPosition p, int rowIncrement, int colIncrement, int size) {
    this.rowIncrement = rowIncrement;
    this.colIncrement = colIncrement;
    this.size = size;
    current = new TicTacWinPosition(p.row - rowIncrement, p.column - colIncrement);
  }

  @Override
  public boolean hasNext() {
    return current.row + rowIncrement < size && current.column + colIncrement < size;
  }

  @Override
  public TicTacWinPosition next() {
    current = new TicTacWinPosition(current.row + rowIncrement, current.column + colIncrement);
    return current;
  }
}

class TicTacWinPosition {
  public int row, column;

  public TicTacWinPosition(int row, int column) {
    this.row = row;
    this.column = column;
  }
}
