package org.vs.ctci.string.minesweeper;

import java.util.List;

public class MineSweeper {

    public int[][] getMineSweeper1(List<Point> bombs, int rows, int cols) {
        int[][] board = new int[rows][cols];

        bombs.forEach(p -> board[p.x][p.y] = -1);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int adjacentBombs = 0;
                if (board[i][j] != -1) {
                    if (hasBomb(board, i + 1, j + 1)) adjacentBombs++;
                    if (hasBomb(board, i + 1, j - 1)) adjacentBombs++;
                    if (hasBomb(board, i - 1, j + 1)) adjacentBombs++;
                    if (hasBomb(board, i - 1, j - 1)) adjacentBombs++;
                    if (hasBomb(board, i, j + 1)) adjacentBombs++;
                    if (hasBomb(board, i, j - 1)) adjacentBombs++;
                    if (hasBomb(board, i - 1, j)) adjacentBombs++;
                    if (hasBomb(board, i + 1, j)) adjacentBombs++;

                    board[i][j] = adjacentBombs;
                }
            }
        }

        return board;
    }

    public int[][] getMineSweeper2(List<Point> bombs, int rows, int cols) {
        int[][] board = new int[rows][cols];

        bombs.forEach(p -> {
            int x = p.x;
            int y = p.y;
            board[x][y] = -1;

            for (int i = x - 1; i <= x + 1; i++) {
                for (int j = y - 1; j <= y + 1; j++) {
                    if (i >= 0 && i < rows && j >= 0 && j < cols) {
                        if (board[i][j] != -1) {
                            board[i][j]++;
                        }
                    }
                }

            }

        });

        return board;
    }

    private boolean hasBomb(int[][] board, int i, int j) {
        int rows = board.length;
        int cols = board[0].length;

        if (i >= 0 && i < rows && j >= 0 && j < cols) {
            return board[i][j] == -1;
        }

        return false;
    }


    static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
