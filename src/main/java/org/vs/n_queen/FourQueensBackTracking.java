package org.vs.n_queen;

public class FourQueensBackTracking {

    static int size = 12;
    static Board board = new Board(size);

    public static void main(String[] args) {
        placeQueen(0, 0);
        System.out.println(board);
    }

    public static void placeQueen(int i, int j) {

        while (board.numberOfQueensPlaced() != size) {
            if (j > size - 1) {
                int columnForQueenOnRow = board.findColumnForQueenOnRow(i - 1);
                board.clearRow(i - 1);
                placeQueen(i - 1, columnForQueenOnRow + 1);
            }

            if (i < size && j < size && board.isAvailable(i, j)) {
                board.placeQueen(i, j);
                placeQueen(i + 1, 0);
            } else {
                if (j == size - 1) {
                    int columnForQueenOnRow = board.findColumnForQueenOnRow(i - 1);
                    board.clearRow(i - 1);
                    placeQueen(i - 1, columnForQueenOnRow + 1);
                }
                placeQueen(i, j + 1);
            }
        }
    }
}
