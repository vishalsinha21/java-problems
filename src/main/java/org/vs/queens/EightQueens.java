package org.vs.queens;

import java.util.Random;

//this algorithm places eight queens on the board with brute force
public class EightQueens {

    public static void main(String[] args) {
        ChessBoard board = null;

        while (true) {

            board = new ChessBoard(8);

            for (int row = 0; row < 8; row++) {
                int column = new Random().nextInt(8);

                if (board.isAvailable(row, column)) {
                    board.placeQueen(row, column);
                }

                if (!board.anyPlaceAvailable()) {
                    break;
                }
            }

            if (board.numberOfQueensPlaced() == 8) {
                break;
            }
        }

        board.print();
    }
}
