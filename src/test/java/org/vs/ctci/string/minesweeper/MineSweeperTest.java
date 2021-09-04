package org.vs.ctci.string.minesweeper;

import org.junit.jupiter.api.Test;

import java.util.List;

class MineSweeperTest {

    @Test
    void should_return_mine_sweeper_board() {
        MineSweeper mineSweeper = new MineSweeper();
        MineSweeper.Point point1 = new MineSweeper.Point(0, 0);
        MineSweeper.Point point2 = new MineSweeper.Point(0, 1);

        int[][] board = mineSweeper.getMineSweeper2(List.of(point1, point2), 3, 4);
        print(board);
    }

    private void print(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}