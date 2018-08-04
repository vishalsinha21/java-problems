package org.vs.n_queen;

public class NQueensBackTracking {

    private static int size = 4;

    public static void main(String[] args) {
        Board board = new Board(size);

        if (placeQueenByRow(board, 0)) {
            System.out.println(board);
        } else {
            System.out.println("placing queens not possible on " + size + "x" + size);
        }

    }

    private static boolean placeQueenByRow(Board board, int row) {
        if (board.numberOfQueensPlaced() >= size) {
            return true;
        }

        for (int i = 0; i < size; i++) {
            if (board.isAvailable(row, i)) {
                board.placeQueen(row, i);
                if (placeQueenByRow(board, row + 1)) {
                    return true;
                }
                board.removeQueen(row, i);
            }
        }

        return false;
    }

    private static boolean placeQueenByColumn(Board board, int col) {
        if (board.numberOfQueensPlaced() >= size) {
            return true;
        }

        for (int i = 0; i < size; i++) {
            if (board.isAvailable(i, col)) {
                board.placeQueen(i, col);
                if (placeQueenByColumn(board, col + 1)) {
                    return true;
                }
                board.removeQueen(i, col);
            }
        }

        return false;
    }
}
