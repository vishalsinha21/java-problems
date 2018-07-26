package org.vs.queens;

public class ChessBoard {

    private int length = 8;
    private int[][] board = new int[length][length];

    final int AVAILABLE = 0;
    final int UNAVAILABLE = 9;
    final int QUEEN = 1;

    public ChessBoard(int length) {
        this.length = length;
    }

    public void placeQueen(int row, int column) {
        markQueenAttack(row, column);
        board[row][column] = QUEEN;

    }

    public boolean isAvailable(int row, int column) {
        return board[row][column] == AVAILABLE;
    }

    private void markQueenAttack(int row, int column) {
        for (int j = 0; j < length; j++) {
            board[row][j] = UNAVAILABLE;
        }

        for (int i = 0; i < length; i++) {
            board[i][column] = UNAVAILABLE;
        }

        for (int i = 1; i < length; i++) {
            if (row + i < length && column + i < length) {
                board[row + i][column + i] = UNAVAILABLE;
            }
            if (row - i >= 0 && column + i < length) {
                board[row - i][column + i] = UNAVAILABLE;
            }
            if (row + i < length && column - i >= 0) {
                board[row + i][column - i] = UNAVAILABLE;
            }
            if (row - i >= 0 && column - i >= 0) {
                board[row - i][column - i] = UNAVAILABLE;
            }
        }
    }

    public void print() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard(8);
        chessBoard.print();

        chessBoard.placeQueen(3, 3);
        chessBoard.print();

        System.out.println(chessBoard.isAvailable(3, 3));
        System.out.println(chessBoard.isAvailable(7, 6));
    }

    public boolean anyPlaceAvailable() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (isAvailable(i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    public int numberOfQueensPlaced() {
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (board[i][j] == QUEEN) {
                    count++;
                }
            }
        }

        return count;
    }
}
