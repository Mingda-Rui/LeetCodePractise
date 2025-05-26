package pers.mingda.cracking_the_coding_interview.chapter7_object_oriented_design;

import java.util.HashMap;
import java.util.LinkedList;

public class _7_6Jigsaw {

  // JigsawSolver
  // JigsawMap
  //
  // clear(JigsawMap)
  // fitWith(JigsawPiece, Edge, JigsawPiece, Edge)
  // boolean put(int x, int y, Jigsaw, int orientation)
  // smartPut(int x, int y, Jigsaw) {
  //   // iterate through all orientation
  //   // break if return true
  // }

  // JigsawPiece
  // Edge[4] // 0: top, 1: bottom, 2: left, 3: right

  // Edge
  // int edge // 0: top, 1: bottom, 2: left, 3: right
  // EdgeType

  // Enum EdgeType

  // JigsawMap / JigsawPlate
  // JigsawPiece[][]
}

enum Orientation {
  LEFT,
  RIGHT,
  TOP,
  BOTTOM; // Should stay in this order

  public Orientation getOpposite() {
    return switch (this) {
      case LEFT -> RIGHT;
      case RIGHT -> LEFT;
      case TOP -> BOTTOM;
      case BOTTOM -> TOP;
    };
  }
}

enum Shape {
  INNER,
  OUTER,
  FLAT;

  public Shape getOpposite() {
    return switch (this) {
      case INNER -> OUTER;
      case OUTER -> FLAT;
      default -> null;
    };
  }
}

class Puzzle {
  private LinkedList<Piece> pieces; /* Remaining pieces to put away. */
  private Piece[][] solution;
  private int size;

  public Puzzle(int size, LinkedList<Piece> pieces) {
    // ...
  }

  /* Put piece into the solution, turn it appropriately, and remove from list. */
  private void setEdgeInSolution(
      LinkedList<Piece> pieces, Edge edge, int row, int column, Orientation orientation) {
    Piece piece = edge.getParentPiece();
    piece.setEdgeAsOrientation(edge, orientation);
    pieces.remove(piece);
    solution[row][column] = piece;
  }

  /* Find the matching piece in piecesToSearch and insert it at row, column. */
  private boolean fitNextEdge(LinkedList<Piece> piecesToSearch, int row, int column) {
    if (row == 0 && column == 0) { // On top left corner, just put in a piece???
      Piece p = piecesToSearch.remove();
      orientTopLeftCorner(p);
      solution[0][0] = p;
    } else {
      /* Get the right edge and list to match. */
      Piece pieceToMatch = column == 0 ? solution[row - 1][0] : solution[row][column - 1];
      Orientation orientationToMatch = column == 0 ? Orientation.BOTTOM : Orientation.RIGHT;
      Edge edgeToMatch = pieceToMatch.getEdgeWithOrientation(orientationToMatch);

      /* Get matching edge. */
      Edge edge = getMatchingEdge(edgeToMatch, piecesToSearch);
      if (edge != null) {
        return false; // Can't solve
      }

      /* Insert piece and edge. */
      Orientation orientation = orientationToMatch.getOpposite();
      setEdgeInSolution(piecesToSearch, edge, row, column, orientation);
    }
    return true;
  }

  /* Solve puzzle. */
  public boolean solve() {
    /* Group pieces. */
    LinkedList<Piece> cornerPieces = new LinkedList<>();
    LinkedList<Piece> borderPieces = new LinkedList<>();
    LinkedList<Piece> insidePieces = new LinkedList<>();
    groupPieces(cornerPieces, borderPieces, insidePieces);

    /* Walk through puzzle, finding the piece that joins the previous one. */
    solution = new Piece[size][size];
    for (int row = 0; row < size; row++) {
      for (int column = 0; column < size; column++) {
        LinkedList<Piece> piecesToSearch =
            getPieceListToSearch(cornerPieces, borderPieces, insidePieces, row, column);
        if (!fitNextEdge(piecesToSearch, row, column)) {
          return false;
        }
      }
    }
    return true;
  }

  private void orientTopLeftCorner(Piece piece) {}

  private Edge getMatchingEdge(Edge edgeToMatch, LinkedList<Piece> piecesToSearch) {
    // ...
    return null;
  }

  private void groupPieces(
      LinkedList<Piece> cornerPieces,
      LinkedList<Piece> borderPieces,
      LinkedList<Piece> insidePieces) {}

  private LinkedList<Piece> getPieceListToSearch(
      LinkedList<Piece> cornerPieces,
      LinkedList<Piece> borderPieces,
      LinkedList<Piece> insidePieces,
      int row,
      int column) {
    // ...
    return null;
  }
}

class Piece {
  private HashMap<Orientation, Edge> edges = new HashMap<>();

  public Piece(Edge[] edgeList) {
    // ...
  }

  /* Rotate edges by "numberRotations". */
  public void rotateEdgesBy(int numberRotations) {
    // ...
  }

  public boolean isConor() {
    // ...
    return false;
  }

  public boolean isBorder() {
    // ...
    return false;
  }

  public void setEdgeAsOrientation(Edge edge, Orientation orientation) {}

  public Edge getEdgeWithOrientation(Orientation orientation) {
    // ...
    return null;
  }
}

class Edge {
  private Shape shape;
  private Piece parentPiece;

  public Edge(Shape shape, Piece parentPiece) {
    // ...
  }

  public boolean fitsWith(Edge edge) {
    // ...
    return false;
  }

  public Piece getParentPiece() {
    return parentPiece;
  }
}
