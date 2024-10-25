package pers.mingda.cracking_the_coding_interview.chapter7_object_oriented_design;

public class _7_8Othello {
}

enum Direction {
    left, right, up, down
}

enum Color {
    White, Black
}

class Game {
    private Player[] players;
    private static Game instance;
    private Board board;
    private final int ROWS = 10;
    private final int COLUMNS = 10;

    private Game() {
        board = new Board(ROWS, COLUMNS);
        players = new Player[2];
        players[0] = new Player(Color.Black);
        players[1] = new Player(Color.White);
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public Board getBoard() {
        return board;
    }
}

class Board {
    private int blackCount = 0;
    private int whiteCount = 0;
    private Piece[][] board;

    public Board(int rows, int columns) {
        board = new Piece[rows][columns];
    }

    public void initialize() {
        /* initialize center black and white pieces */
    }

    /*
    * Attempt to place a piece of color at (row, column). Return true if we
    * were successful.
    * */
    public boolean placeColor(int row, int column, Color color) {
        // ...
        return false;
    }

    /* Flips pieces starting at (row, column) and proceeding in direction d. */
    private int flipSection(int row, int column, Color color, Direction d) {
        // ...
        return 0;
    }

    public int getScoreForColor(Color c) {
        if (c == Color.Black) {
            return blackCount;
        } else {
            return whiteCount;
        }
    }

    /*
    * Update board with additional newPieces pieces of color newColor. Decrease
    * score of opposite color
    * */
    public void updateScore(Color newColor, int newPieces) {
        // ...
    }
}

class OthelloPiece {
    private Color color;
    public OthelloPiece(Color c) {
        color = c;
    }

    public void flip() {
        if (color == Color.Black) {
            color = Color.White;
        } else {
            color = Color.Black;
        }
    }

    public Color getColor() {
        return color;
    }
}

class Player {
    private Color color;
    public Player(Color c) {
        color = c;
    }

    public int getScore() {
        // ...
        return 0;
    }

    public boolean playPiece(int r, int c) {
        return Game.getInstance().getBoard().placeColor(r, c, color);
    }

    public Color getColor() {
        return color;
    }
}
