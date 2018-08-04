package org.vs.queens;

public class EightQueenByBacktracking {

    static ChessBoard board = new ChessBoard(8);

    public static void main(String[] args) {
        placeQueen(0, 0);
        board.print();
    }

    public static void placeQueen(int i, int j) {
        if (board.numberOfQueensPlaced() == 8) {
            return;
        }

        if (board.isAvailable(i, j)) {
            board.placeQueen(i, j);
            placeQueen(i + 1, j);
        } else {
            if (j >= 8) {
                placeQueen(i - 1, 0);
            }
            placeQueen(i, j + 1);
        }

    }
}
