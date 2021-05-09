package org.vs.others.n_queen;

public class Board {

    int size = 0;
    int[][] board = null;

    public Board(int size) {
        this.size = size;
        board = new int[size][size];
    }

    public void clearRow(int row) {
        for (int i = 0; i < size; i++) {
            board[row][i] = 0;
        }
    }

    public void placeQueen(int row, int column) {
        board[row][column] = 1;
    }

    public void removeQueen(int row, int column) {
        board[row][column] = 0;
    }

    public boolean isAnyPlaceAvailable() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (isAvailable(i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                builder.append(board[i][j] + " ");
            }
            builder.append("\n");
        }
        builder.append("\n");

        return builder.toString();
    }

    public int findColumnForQueenOnRow(int row) {
        for (int i = 0; i < size; i++) {
            if (board[row][i] == 1) {
                return i;
            }
        }

        return -1;
    }

    public boolean isAvailable(int row, int column) {
        for (int i = 0; i < size; i++) {
            if (board[row][i] == 1 || board[i][column] == 1) {
                return false;
            }

            if (row + i < size && column + i < size && board[row + i][column + i] == 1) {
                return false;
            }
            if (row - i >= 0 && column + i < size && board[row - i][column + i] == 1) {
                return false;
            }
            if (row + i < size && column - i >= 0 && board[row + i][column - i] == 1) {
                return false;
            }
            if (row - i >= 0 && column - i >= 0 && board[row - i][column - i] == 1) {
                return false;
            }
        }

        return true;
    }

    public int numberOfQueensPlaced() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

}
