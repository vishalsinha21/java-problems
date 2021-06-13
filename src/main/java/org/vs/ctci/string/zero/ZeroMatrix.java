package org.vs.ctci.string.zero;

import java.util.ArrayList;
import java.util.List;

public class ZeroMatrix {

    public static int[][] convertToZeroMatrix(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        int[][] temp = new int[m][n];
        List<Point> list  =new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = arr[i][j];
                if (arr[i][j] == 0) {
                    Point point = new Point(i, j);
                    list.add(point);
                }
            }
        }

        for (Point point: list) {
            for (int i = 0; i < m; i++) {
                temp[point.x][i] = 0;
            }
            for (int i = 0; i < m; i++) {
                temp[i][point.y] = 0;
            }
        }

        return temp;
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
