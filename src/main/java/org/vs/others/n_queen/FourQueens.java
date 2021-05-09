package org.vs.others.n_queen;

import org.vs.others.queens.ChessBoard;

import java.util.Random;

public class FourQueens {

    public static void main(String[] args) {
        Board board = null;

        while (true) {

            board = new Board(4);

            for (int row = 0; row < 4; row++) {
                int column = new Random().nextInt(4);

                if (board.isAvailable(row, column)) {
                    board.placeQueen(row, column);
                }

                if (!board.isAnyPlaceAvailable()) {
                    break;
                }
            }

            if (board.numberOfQueensPlaced() == 4) {
                break;
            }
        }

        System.out.println(board);
    }
}
