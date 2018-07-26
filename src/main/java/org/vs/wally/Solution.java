package org.vs.wally;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.vs.wally.Direction.EAST;
import static org.vs.wally.Direction.NORTH;
import static org.vs.wally.Direction.SOUTH;
import static org.vs.wally.Direction.WEST;

public class Solution {

    public static void main(String[] args) {
        Path path = new Path();

        Scanner scanner = new Scanner(System.in);
        List<Point> obstacles = new ArrayList<>();

        int obstacleCount = scanner.nextInt();
        int stepsCount = scanner.nextInt();

        for (int i = 0; i < obstacleCount; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Point point = new Point(x, y);
            obstacles.add(point);
        }

        for (int i = 0; i < stepsCount; i++) {
            String[] queries = scanner.next().split(" ");

            switch (queries[0]) {
                case "M":
                    int moves = scanner.nextInt();
                    path.increment(moves, obstacles);
                    break;
                case "L":
                    path.takeLeft();
                    break;
                case "R":
                    path.takeRight();
                    break;
            }
        }

        System.out.println(path.maxDistance);
    }

}

class Path {
    Point current;
    Direction currentDirection;
    Double maxDistance = 0.0;

    public Path() {
        current = new Point(0, 0);
        currentDirection = NORTH;
    }

    public void takeLeft() {
        currentDirection = left();
    }

    private Direction left() {
        switch (currentDirection) {
            case NORTH:
                return WEST;
            case SOUTH:
                return EAST;
            case EAST:
                return NORTH;
            case WEST:
                return SOUTH;
            default:
                return currentDirection;
        }
    }

    public void takeRight() {
        currentDirection = right();
    }


    private Direction right() {
        switch (currentDirection) {
            case NORTH:
                return EAST;
            case SOUTH:
                return WEST;
            case EAST:
                return SOUTH;
            case WEST:
                return NORTH;
            default:
                return currentDirection;
        }
    }

    public void increment(int moves, List<Point> obstacles) {
        for (int i = 0; i < moves; i++) {
            Point point = increment();
            if (obstacles.contains(point)) {
                break;
            } else {
                current = point;
            }
        }

        maxDistance = Math.max(maxDistance, distance(0, 0, current.x, current.y));
    }

    static double distance(int x1, int y1, int x2, int y2) {
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) * 1.0);
        return new BigDecimal(distance).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    private Point increment() {
        Point temp = new Point(current);
        switch (currentDirection) {
            case NORTH:
                temp.moveNorth();
                break;
            case SOUTH:
                temp.moveSouth();
                break;
            case EAST:
                temp.moveEast();
                break;
            case WEST:
                temp.moveWest();
                break;
            default:
                break;
        }

        return temp;
    }

    @Override
    public String toString() {
        return current + "," + currentDirection;
    }

}

enum Direction {
    NORTH, SOUTH, EAST, WEST;
}


class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point point) {
        this.x = point.x;
        this.y = point.y;
    }

    public void moveNorth() {
        y++;
    }

    public void moveSouth() {
        y--;
    }

    public void moveEast() {
        x++;
    }

    public void moveWest() {
        x--;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Point point = (Point) o;

        if (x == point.x && y == point.y) {
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }
}